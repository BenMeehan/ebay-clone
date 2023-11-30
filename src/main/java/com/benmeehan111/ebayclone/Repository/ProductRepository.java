package com.benmeehan111.ebayclone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.benmeehan111.ebayclone.Models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p.productId, p.productName, p.price, pc.categoryId, pc.categoryName, p.productImages " +
       "FROM Product p " +
       "JOIN p.category pc " +
       "WHERE p.productType = ?1")
    List<Object[]> findProductInfoByProductType(Product.ProductType productType);
}
