package com.trainingapps.productms.util;

import com.trainingapps.productms.dto.ProductDetails;
import com.trainingapps.productms.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductUtil {

    public ProductDetails toProductDetails(Product product){
        ProductDetails desired = new ProductDetails();
        desired.setId(product.getId());
        desired.setName(product.getName());
        desired.setPrice(product.getPrice());
        return desired;
    }

    public List<ProductDetails>toListProductDetails(Collection<Product> products){
        List<ProductDetails>desired=new ArrayList<>();
        for(Product product:products){
            ProductDetails details=toProductDetails(product);
            desired.add(details);
        }
        return desired;

    }
}
