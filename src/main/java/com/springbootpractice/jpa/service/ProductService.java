package com.springbootpractice.jpa.service;

import com.springbootpractice.jpa.entity.Product;
import com.springbootpractice.jpa.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public List<Product> getProductsByPage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).getContent();
    }

    public Product saveProduct(Product product){
        productRepository.save(product);

        return product;
    }
}
