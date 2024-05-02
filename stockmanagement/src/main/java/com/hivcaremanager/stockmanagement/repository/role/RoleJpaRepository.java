package com.hivcaremanager.stockmanagement.repository.role;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.Role;

public interface RoleJpaRepository extends JpaRepository<Role, UUID>{
    
    public boolean existsByNom(String nom);

    public Role findByNom(String name);
}
