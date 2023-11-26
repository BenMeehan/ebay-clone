package com.benmeehan111.ebayclone.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "CartId", columnDefinition = "BINARY(16)")
    private UUID cartId;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
