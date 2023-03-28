package com.ndeta.restapi.service;

import com.ndeta.restapi.exception.ResourceNotFoundException;
import com.ndeta.restapi.model.Product;
import com.ndeta.restapi.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        //fetch from database
        Optional<Product> productDb=this.productRepository
                .findById(product.getId());
        //Check if product is present
        if(productDb.isPresent()){
            Product productUpdate=productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productRepository.save(productUpdate);
            return productUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id :" + product.getId());
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        //fetch from database
        Optional<Product> productDb=this.productRepository
                .findById(productId);
        //Check if product id is present
        if (productDb.isPresent()){
            return productDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id :" + productDb);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        //fetch from database
        Optional<Product> productDb=this.productRepository
                .findById(productId);
        if(productDb.isPresent()){
            this.productRepository.delete(productDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id :" + productDb);
        }
    }
}
