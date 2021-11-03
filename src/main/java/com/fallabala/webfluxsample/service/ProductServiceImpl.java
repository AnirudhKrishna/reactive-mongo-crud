package com.fallabala.webfluxsample.service;

import com.fallabala.webfluxsample.model.Product;
import com.fallabala.webfluxsample.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl
        implements ProductService
{
    private ProductRepository productRepository;

    @Override
    public Mono<Product> save( Product product )
    {
        return productRepository.save( product );
    }

    @Override
    public Flux<Product> findAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findBySku( String sku )
    {
        return productRepository.findById( sku );
    }

    @Override
    public Mono<Product> updateProduct( Product product )
    {
        return productRepository.save( product );
    }

    @Override
    public Mono<Void> deleteProduct( String sku )
    {
        return productRepository.deleteById( sku );
    }
}
