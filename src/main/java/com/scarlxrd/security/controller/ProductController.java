package com.scarlxrd.security.controller;

import com.scarlxrd.security.model.dto.ProductRequestDto;
import com.scarlxrd.security.model.dto.ProductResponseDto;
import com.scarlxrd.security.model.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto requestDto){
        ProductResponseDto responseDto = productService.createProduct(requestDto);
        return  new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping
    public List<ProductResponseDto > getall(){
        return productService.getAllProducts();
    }
}
