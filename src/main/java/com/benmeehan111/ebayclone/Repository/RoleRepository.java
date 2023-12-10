package com.benmeehan111.ebayclone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benmeehan111.ebayclone.Models.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
