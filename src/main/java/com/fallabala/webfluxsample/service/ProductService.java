package com.fallabala.webfluxsample.service;

import com.fallabala.webfluxsample.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService
{
    Mono<Product> save( Product product );

    Flux<Product> findAll();

    Mono<Product> findBySku( String sku );

    Mono<Product> updateProduct( Product product );

    Mono<Void> deleteProduct(String sku);
}
