package com.sda.comparison2.repository;

import com.sda.comparison2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {


}
