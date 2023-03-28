package com.ndeta.restapi.service;

import com.ndeta.restapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    void  deleteProduct(Long productId);

}
