package com.fallabala.webfluxsample.controller;

import com.fallabala.webfluxsample.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ProductControllerTest
{
    @Autowired
    private WebTestClient webClient;

    @BeforeEach
    void setUp()
    {
        Product product = getProduct();
        this.webClient.post().uri( "/api/product/" ).contentType( MediaType.APPLICATION_JSON )
                .body( Mono.just( product ), Product.class ).exchange().expectBody( Product.class )
                .isEqualTo( product );
    }

    private Product getProduct()
    {
        return Product.builder()
                .sku( "FAL-8406270" )
                .name( "500 Zapatilla Urbana Mujer" )
                .brand( "NEW BALANCE" )
                .size( "37" )
                .price( "42990.00" )
                .principalImage( "https://abc.com/123" )
                .build();
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void addProduct()
    {
        Product product = getProduct();
        this.webClient.post().uri( "/api/product/" ).contentType( MediaType.APPLICATION_JSON )
                .body( Mono.just( product ), Product.class ).exchange().expectBody( Product.class )
                .isEqualTo( product );
    }

    @Test
    void getAllProducts()
    {
        this.webClient.get().uri( "/api/product/" ).accept( MediaType.APPLICATION_JSON )
                .exchange().expectStatus().isOk();
    }

    @Test
    void getProductBySku()
    {
        this.webClient.get().uri( "/api/product/FAL-8406270" ).accept( MediaType.APPLICATION_JSON )
                .exchange().expectStatus().isOk();
    }

    @Test
    void updateProduct()
    {
        Product updatedProduct = Product.builder()
                .sku( "FAL-8406270" )
                .name( "updated name" )
                .brand( "NEW BALANCE" )
                .size( "37" )
                .price( "42990.00" )
                .principalImage( "https://abc.com/123" )
                .build();
        this.webClient.put().uri( "/api/product/" ).contentType( MediaType.APPLICATION_JSON )
                .body( Mono.just( updatedProduct ), Product.class ).exchange()
                .expectBody( Product.class )
                .isEqualTo( updatedProduct );
    }

    @Test
    void deleteProduct()
    {
        this.webClient.delete().uri( "/api/product/FAL-8406270" )
                .accept( MediaType.APPLICATION_JSON )
                .exchange().expectStatus().isOk();
    }
}