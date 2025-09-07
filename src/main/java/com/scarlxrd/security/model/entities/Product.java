package com.scarlxrd.security.model.entities;

import com.scarlxrd.security.model.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private BigDecimal price;


    public Product(ProductRequestDto requestDto) {
        this.price = requestDto.price();
        this.name = requestDto.name();
    }
}
