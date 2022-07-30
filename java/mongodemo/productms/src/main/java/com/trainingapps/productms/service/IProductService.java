package com.trainingapps.productms.service;

import com.trainingapps.productms.dto.AddProductRequest;
import com.trainingapps.productms.dto.ChangeProductRequest;
import com.trainingapps.productms.dto.ProductDetails;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exceptions.ProductNotFoundException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
public interface IProductService {
    Product findById(@NotBlank String id) throws ProductNotFoundException;

    ProductDetails findProductDetailsById(@NotBlank String id) throws ProductNotFoundException;

    ProductDetails changePrice(@NotBlank String id, @Valid ChangeProductRequest requestData) throws ProductNotFoundException;

    ProductDetails addProduct(@Valid AddProductRequest requestData);

    List<ProductDetails> findAll();

    void deleteById(@NotBlank String productId) throws ProductNotFoundException;
}
