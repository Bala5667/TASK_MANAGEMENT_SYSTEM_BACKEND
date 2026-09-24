package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity

@Table(name = "products")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;
    
    @NotBlank(message = "Enter a valid name")
    private String prodName;
    
    @NotNull (message = "Enter a valid amount")
    private String prodPrice;

    public UserEntity() {}

    public UserEntity(Integer id, String prodName, String prodPrice) {
        this.id = id;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }
}
