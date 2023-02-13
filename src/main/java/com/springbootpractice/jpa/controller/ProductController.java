package com.springbootpractice.jpa.controller;

import com.springbootpractice.jpa.entity.Product;
import com.springbootpractice.jpa.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Stage 1
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        log.debug("Get All Products");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable Long id){
        log.debug("Get /product, ID:{}", id);
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<Product>> getProductsByPage(@PathVariable Integer page, @PathVariable Integer size){
        log.debug("Get /productsByPage, page:{}, size:{}", page, size);
        return ResponseEntity.ok(productService.getProductsByPage(page, size));
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody @Validated Product product){
        log.debug("Post /products, Parameter:{}", product.toString());
        return ResponseEntity.ok(productService.saveProduct(product));

    }
}
