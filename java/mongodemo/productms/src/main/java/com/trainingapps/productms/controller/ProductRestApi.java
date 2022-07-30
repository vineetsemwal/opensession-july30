package com.trainingapps.productms.controller;

import com.trainingapps.productms.dto.AddProductRequest;
import com.trainingapps.productms.dto.ChangeProductRequest;
import com.trainingapps.productms.dto.ProductDetails;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exceptions.ProductNotFoundException;
import com.trainingapps.productms.service.IProductService;
import com.trainingapps.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductRestApi {

    @Autowired
    private IProductService service;

    // effect url   /products/byid/{id}
    //@RequestMapping(path="/{id}", method=RequestMethod.GET)
    @GetMapping("/byid/{id}")
    public ProductDetails getById(@PathVariable  String id) throws Exception {
        ProductDetails response = service.findProductDetailsById(id);
        return response;
    }


    // @RequestMapping( method=RequestMethod.GET)
    // effective url is /products
    @GetMapping
    public List<ProductDetails> getAllProducts() {
        List<ProductDetails> response = service.findAll();
        return response;
    }

    // @RequestMapping(path="/add", method=RequestMethod.POST)
    // effective url /products/add
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "/add")
    public ProductDetails addProduct(@RequestBody AddProductRequest requestData) {
        ProductDetails response = service.addProduct(requestData);
        return response;
    }

    @PutMapping("/price/change/{id}")
    public ProductDetails changePrice(@RequestBody  ChangeProductRequest requestData, @PathVariable  String id) throws Exception {
        ProductDetails response = service.changePrice(id, requestData);
        return response;
    }

    @DeleteMapping("/remove/byid/{id}")
    public String removeProduct(@PathVariable String id) throws Exception {
        service.deleteById(id);
        return id + " product deleted";
    }


}
