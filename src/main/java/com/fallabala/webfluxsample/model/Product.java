package com.fallabala.webfluxsample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product
{
    @Id
    @NotBlank(message = "SKU value cannot be empty")
    private String sku;
    @NotBlank(message = "Name value cannot be empty")
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank(message = "Brand value cannot be empty")
    @Size(min = 3, max = 50)
    private String brand;
    private String size;
    @NotBlank(message = "Price value cannot be empty")
    @Size(min = 1, max = 99999999)
    private String price;
    @NotBlank(message = "Principal Image value cannot be empty")
    private String principalImage;
    private String otherImage;
}
