package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecommerce.entity.UserEntity;
import com.example.ecommerce.repository.UserRepository;

@Service

public class UserService {
	
	@Autowired
	
	private UserRepository repo;
	
	public List<UserEntity> getAllUsers(){
		
		return repo.findAll();
	}

    public UserEntity addUser(@RequestBody UserEntity user) {

       return repo.save(user);

}
    public UserEntity updateUser(@RequestBody UserEntity user) {

        return repo.save(user);

}
    public String deleteUser (@PathVariable Integer id) {

        repo. deleteById(id);
        
		return "User deleted";
}

    public Page<UserEntity> getUsers(int page, int size) {

        PageRequest pageable = PageRequest.of(page, size);

        return repo.findAll(pageable);

    }
    
   
}