package com.sda.comparison2.repository;

import com.sda.comparison2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    /**
     * Method automatically implemented by spring data jpa
     * It will search by product name property
     * @param productName
     * @return
     */
    List<Product> findByNameContaining(String productName);

}
