package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.ecommerce.entity.CustEntity;
import com.example.ecommerce.entity.JwtUtil;

import com.example.ecommerce.repository.CustRepository;

import com.example.ecommerce.entity.LoginRequest;


@Service

public class CustService {
	
	@Autowired	
	private CustRepository Repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @Autowired
    private JwtUtil jwtUtil;
	
    public CustEntity register(CustEntity customer) {

        // 🔥 THIS LINE IS REQUIRED
        customer.setPassword(
            passwordEncoder.encode(customer.getPassword())
        );

        return Repository.save(customer);
    }
    
    public String login(LoginRequest request) {

        CustEntity user =
            Repository.findByUsername(request.getUsername());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }

}


