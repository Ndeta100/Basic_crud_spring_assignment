package com.ndeta.restapi.controller;

import com.ndeta.restapi.model.Product;
import com.ndeta.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ap1/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return  ResponseEntity.ok().body(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getAllProductById(@PathVariable Long id){
        return  ResponseEntity.ok().body(productService.getProductById(id));
    }
    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, Product product){
        product.setId(id);
        return  ResponseEntity.ok().body(productService.updateProduct(product));
    }
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }

}
