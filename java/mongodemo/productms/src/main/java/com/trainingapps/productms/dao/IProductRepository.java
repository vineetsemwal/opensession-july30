package com.trainingapps.productms.dao;

import com.trainingapps.productms.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product,String> {
}
