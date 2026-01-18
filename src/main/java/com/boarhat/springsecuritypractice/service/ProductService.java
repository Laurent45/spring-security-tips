package com.boarhat.springsecuritypractice.service;

import com.boarhat.springsecuritypractice.entity.Product;
import com.boarhat.springsecuritypractice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
