package com.benmeehan111.ebayclone.Repository;

import com.benmeehan111.ebayclone.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
