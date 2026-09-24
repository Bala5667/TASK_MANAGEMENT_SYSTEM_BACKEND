package com.example.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.CustEntity;
import com.example.ecommerce.entity.LoginRequest;

import com.example.ecommerce.service.CustService;

@RestController
@RequestMapping("/auth")
public class CustController {

    @Autowired
    private CustService service;
    
    @GetMapping("/secure")
    public String secureApi() {
        return "JWT WORKING ✅";
    }

    @GetMapping("/test")
    public String test() {
        return "OK"; 
    }

    @PostMapping("/signup")
    public CustEntity save(@RequestBody CustEntity customer) {
        return service.register(customer);
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody LoginRequest request) {

        String token = service.login(request);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;
    }
}



