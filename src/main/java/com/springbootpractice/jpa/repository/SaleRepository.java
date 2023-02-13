package com.springbootpractice.jpa.repository;

import com.springbootpractice.jpa.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
