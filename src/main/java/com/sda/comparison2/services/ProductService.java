package com.sda.comparison2.services;

import com.sda.comparison2.entity.Product;
import com.sda.comparison2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){

        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByName(String productName) {
        return productRepository.findByNameContaining(productName);
    }
}
