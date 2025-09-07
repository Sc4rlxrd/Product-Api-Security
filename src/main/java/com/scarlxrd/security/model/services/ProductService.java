package com.scarlxrd.security.model.services;

import com.scarlxrd.security.model.dto.ProductRequestDto;
import com.scarlxrd.security.model.dto.ProductResponseDto;
import com.scarlxrd.security.model.entities.Product;
import com.scarlxrd.security.model.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto){
        Product newProduct = new Product(requestDto);
        productRepository.save(newProduct);
        return new ProductResponseDto(newProduct);
    }
    @Transactional
    public List<ProductResponseDto> getAllProducts(){
        return  productRepository.findAll().stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }


}
