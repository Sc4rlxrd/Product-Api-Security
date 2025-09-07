package com.scarlxrd.security.model.dto;


import com.scarlxrd.security.model.entities.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponseDto {
    private UUID id;
    private String name;
    private BigDecimal price;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
