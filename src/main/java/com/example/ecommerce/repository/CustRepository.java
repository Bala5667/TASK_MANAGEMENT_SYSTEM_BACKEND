package com.example.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ecommerce.entity.CustEntity;

@Repository
public interface CustRepository extends JpaRepository<CustEntity, Integer> {
	
	CustEntity findByUsername(String username);
}

