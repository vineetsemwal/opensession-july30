package com.trainingapps.productms.service;

import com.trainingapps.productms.dao.IProductRepository;
import com.trainingapps.productms.dto.AddProductRequest;
import com.trainingapps.productms.dto.ChangeProductRequest;
import com.trainingapps.productms.dto.ProductDetails;
import com.trainingapps.productms.entity.Product;
import com.trainingapps.productms.exceptions.ProductNotFoundException;
import com.trainingapps.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Autowired
    private ProductUtil util;

    private Random random = new Random();


    public String generateId() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomNum = random.nextInt(99);
            builder.append(randomNum);
        }
        String id = builder.toString();
        return id;
    }

    @Override
    public Product findById(String id) throws ProductNotFoundException {
        Optional<Product> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new ProductNotFoundException("product not found for id=" + id);
        }
        Product product= optional.get();
        return product;
    }

    @Override
    public ProductDetails findProductDetailsById(String id) throws ProductNotFoundException {
        Product product= findById(id);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Override
    public ProductDetails changePrice(String id, ChangeProductRequest requestData) throws ProductNotFoundException {
        Product product = findById(id);
        product.setPrice(requestData.getNewPrice());
        product=repository.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Override
    public ProductDetails addProduct(AddProductRequest requestData) {
        Product product = new Product(requestData.getName(), requestData.getPrice());
        String id=generateId();
        product.setId(id);
        product= repository.save(product);
        ProductDetails desired=util.toProductDetails(product);
        return desired;
    }

    @Override
    public List<ProductDetails> findAll() {
        List<Product> products = repository.findAll();
        List<ProductDetails>desired=util.toListProductDetails(products);
        return desired;
    }

    @Override
    public void deleteById(String productId) throws ProductNotFoundException{
        repository.deleteById(productId);
    }

}
