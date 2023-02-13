package com.springbootpractice.jpa.controller;

import com.springbootpractice.jpa.entity.Sale;
import com.springbootpractice.jpa.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
@Slf4j
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody @Validated Sale sale) {
        log.debug("Post /sales, Parameters:{}", sale.toString());
        return ResponseEntity.ok(saleService.saveOrder(sale));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleDetail(@PathVariable("id") Long id) {

        log.debug("Get /sales, Parameters:{}", id);
        return ResponseEntity.ok(saleService.getSaleDetail(id));
    }
}
