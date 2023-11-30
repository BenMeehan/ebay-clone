package com.benmeehan111.ebayclone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benmeehan111.ebayclone.Models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
