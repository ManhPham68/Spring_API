package com.example.demo.mapper;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    ProductDto convertToDto(ProductEntity productEntity);
    ProductEntity convertToEntity(ProductDto productDto);
}
