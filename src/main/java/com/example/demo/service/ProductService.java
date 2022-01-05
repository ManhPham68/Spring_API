package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProducts();
    ProductDto addProduct(ProductDto dto);
    ProductEntity getOneProduct(int id);
   // ProductDto sellProduct(int id, ProductDto dto);
    ProductEntity sellProduct(int product , int quantity);
}
