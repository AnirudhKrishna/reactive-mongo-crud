package com.fallabala.webfluxsample.repository;

import com.fallabala.webfluxsample.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository
        extends ReactiveCrudRepository<Product, String>
{
}
