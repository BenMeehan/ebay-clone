package com.benmeehan111.ebayclone.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    public enum ProductType {
        NORMAL, BID
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ProductId", columnDefinition = "BINARY(16)")
    private UUID productId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "StockQuantity", nullable = false)
    private int stockQuantity;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "SellerId", nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private ProductCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "ProductType", nullable = false)
    private ProductType productType;
}
