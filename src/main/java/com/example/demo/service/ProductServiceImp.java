package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.responsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductReponsitory productReponsitory;
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductEntity> getAllProducts() {
        return productReponsitory.findAll();
    }

    @Override
    public ProductDto addProduct(ProductDto dto) {
        ProductEntity entity = productMapper.convertToEntity(dto);
        ProductEntity productEntity = productReponsitory.save(entity);
        ProductDto productDto = productMapper.convertToDto(productEntity);
        return productDto;
    }

    @Override
    public ProductEntity getOneProduct(int id) {
        return productReponsitory.getById(id);
    }

//    @Override
//    public ProductDto sellProduct(int id, ProductDto dto) {
//        ProductEntity entity = productMapper.convertToEntity(dto);
//        entity=productReponsitory.getById(id);
//        if(entity!=null){
//            entity.setName(dto.getName());
//            entity.setPrice(dto.getPrice());
//            entity.setQuantity(dto.getQuantity());
//        }
//        ProductEntity productEntity = productReponsitory.save(entity);
//        ProductDto productDto = productMapper.convertToDto(productEntity);
//        return productDto;
//    }
    @Override
    public ProductEntity sellProduct(int productid, int quantity) {
        ProductEntity p = productReponsitory.findById(productid).get();
        p.setQuantity(p.getQuantity() - quantity);
        productReponsitory.save(p);
        return p;
    }
}
