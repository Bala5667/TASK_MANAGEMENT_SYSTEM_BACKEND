package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommerce.entity.UserEntity;



@Repository

public interface UserRepository 

extends JpaRepository<UserEntity, Integer>{

	}

