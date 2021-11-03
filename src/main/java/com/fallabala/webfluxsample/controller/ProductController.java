package com.fallabala.webfluxsample.controller;

import com.fallabala.webfluxsample.model.Product;
import com.fallabala.webfluxsample.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@AllArgsConstructor
public class ProductController
{
    private ProductService productService;

    //todo:exceptional handling , status code
    @PostMapping(value = "/api/product/")
    public Mono<Product> addProduct( @Validated @RequestBody Product product )
    {
        log.info( "request received to add user to db" );
        return productService.save( product );
    }

    @GetMapping(value = "/api/product/")
    public Flux<Product> getAllProducts()
    {
        log.info( "request received to get all user from db" );
        return productService.findAll();
    }

    @GetMapping(value = "/api/product/{sku}")
    public Mono<Product> getProductBySku( @PathVariable("sku") String sku )
    {
        log.info( "request received to get user by sku:::{}", sku );
        return productService.findBySku( sku );
    }

    @PutMapping(value = "/api/product/")
    public Mono<Product> updateProduct( @RequestBody Product product )
    {
        log.info( "request received to update user" );
        return productService.updateProduct( product );
    }

    @DeleteMapping(value = "/api/product/{sku}")
    public Mono<Void> deleteProduct( @PathVariable("sku") String sku )
    {
        log.info( "request received to delete user with sku:::{}", sku );
        return productService.deleteProduct( sku );
    }
}
