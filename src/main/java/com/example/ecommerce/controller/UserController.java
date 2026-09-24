package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.UserEntity;
import com.example.ecommerce.service.UserService;
import jakarta.validation.Valid;


@RestController

public class UserController {
	
	@Autowired
	
	private UserService Service;
		@GetMapping("/Order")
		
		public List<UserEntity> getAllUsers(){
		
		return Service.getAllUsers();		
	
	}

	    @PostMapping("/addUser")
	    public UserEntity addUser(@Valid @RequestBody UserEntity user) {

        return Service.addUser(user);  

	    }
	    
	    @PutMapping("/update")
	    public UserEntity updateUser(@RequestBody UserEntity user) {
	
	        return Service.updateUser(user);
	    }
        
        @DeleteMapping("/deleteUser/{id}") 
        
        public String deleteUser(@PathVariable Integer id) {
        
        return Service.deleteUser(id); 
        
        }
        
        @GetMapping("/users")     // Controller for pagenation view
        
		public Page<UserEntity> getUsers(
		
		        @RequestParam int page,
		        @RequestParam int size
		) {
		
		    return Service.getUsers(page, size);
		}
		        
		    }





