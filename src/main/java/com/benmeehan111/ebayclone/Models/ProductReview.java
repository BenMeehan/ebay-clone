package com.benmeehan111.ebayclone.Models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ProductReview")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ReviewId", columnDefinition = "BINARY(16)")
    private UUID reviewId;

    @ManyToOne
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "Rating", nullable = false)
    private int rating;

    @Column(name = "ReviewText")
    private String reviewText;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;
}
