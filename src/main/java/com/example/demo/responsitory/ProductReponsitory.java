package com.example.demo.responsitory;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ProductReponsitory extends JpaRepository<ProductEntity, Integer> {
}
