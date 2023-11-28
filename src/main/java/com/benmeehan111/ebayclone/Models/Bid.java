package com.benmeehan111.ebayclone.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Bid")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "BidId", columnDefinition = "BINARY(16)")
    private UUID bidId;

    @ManyToOne
    @JoinColumn(name = "BidderId", nullable = false)
    private User bidder;

    @ManyToOne
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "BidAmount", nullable = false)
    private BigDecimal bidAmount;

    @Column(name = "Status", nullable = false)
    private String status;
}
