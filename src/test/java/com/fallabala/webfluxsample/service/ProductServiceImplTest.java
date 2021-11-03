package com.fallabala.webfluxsample.service;

import com.fallabala.webfluxsample.model.Product;
import com.fallabala.webfluxsample.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest
{
    @Mock
    private ProductRepository  productRepository;
    @InjectMocks
    private ProductServiceImpl productService;

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

    @Test
    void save()
    {
        Product product = getProduct();
        when( productRepository.save( product ) ).thenReturn( Mono.just( product ) );
        StepVerifier.create( this.productService.save( product ) )
                .consumeNextWith( ( response ) -> {
                    assertThat( response.getName() ).isEqualTo( "500 Zapatilla Urbana Mujer" );
                } )
                .verifyComplete();
    }

    @Test
    void findAll()
    {
        Product product = getProduct();
        when( productRepository.findAll() ).thenReturn( Flux.just( product ) );
        StepVerifier.create( this.productService.findAll() )
                .consumeNextWith( ( response ) -> {
                    assertThat( response.getName() ).isEqualTo( "500 Zapatilla Urbana Mujer" );
                } )
                .verifyComplete();
    }

    @Test
    void findBySku()
    {
        Product product = getProduct();
        when( productRepository.findById( "FAL-8406270" ) ).thenReturn( Mono.just( product ) );
        StepVerifier.create( this.productService.findBySku( "FAL-8406270" ) )
                .consumeNextWith( ( response ) -> {
                    assertThat( response.getSku() ).isEqualTo( "FAL-8406270" );
                } )
                .verifyComplete();
    }

    @Test
    void updateProduct()
    {
        Product product = getProduct();
        product.setName( "updated Name" );
        when( productRepository.save( product ) ).thenReturn( Mono.just( product ) );
        StepVerifier.create( this.productService.updateProduct( product ) )
                .consumeNextWith( ( response ) -> {
                    assertThat( response.getName() ).isEqualTo( "updated Name" );
                } )
                .verifyComplete();
    }

    @Test
    void deleteProduct()
    {
        Product product = getProduct();
        when( productRepository.deleteById( "FAL-8406270" ) ).thenReturn( Mono.empty() );
        StepVerifier.create( this.productService.deleteProduct( "FAL-8406270" ) )
                .verifyComplete();
    }
}