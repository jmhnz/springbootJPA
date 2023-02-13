package com.springbootpractice.jpa.repository;

import com.springbootpractice.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
