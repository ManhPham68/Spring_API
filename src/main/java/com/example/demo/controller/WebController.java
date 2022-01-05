package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WebController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;
    @GetMapping("api/product")
    public ResponseEntity getAllProducts(){
        BaseResponse res = new BaseResponse();
        res.data=productService.getAllProducts();
        return ResponseEntity.ok(res);
    }
    @PostMapping("/api/product")
    private ResponseEntity addProduct(@RequestBody ProductDto productDto){
        BaseResponse res = new BaseResponse();
        res.data=productService.addProduct(productDto);
        return ResponseEntity.ok(res);
    }
//    @PutMapping("/api/product")
//    public ResponseEntity sellProduct(@RequestParam("id") int id, @RequestBody ProductDto productDto){
//        BaseResponse res = new BaseResponse();
//        res.data=productService.sellProduct(id,productDto);
//        return ResponseEntity.ok(res);
//    }
    @PutMapping("/api/product")
    private ResponseEntity updateProduct(@RequestParam Map<String, String> allParam) {
        int product_id = Integer.parseInt(allParam.get("productId"));
        int quantity = Integer.parseInt(allParam.get("quantity"));
        return ResponseEntity.ok(productService.sellProduct(product_id,quantity));
    }
}
