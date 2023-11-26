package com.benmeehan111.ebayclone.Models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ProductReview")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ReviewId", columnDefinition = "BINARY(16)")
    private Long reviewId;

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
