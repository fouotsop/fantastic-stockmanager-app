package com.hivcaremanager.stockmanagement.repository.role;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.Role;

@Repository
public interface RoleRepository {

    public Role add(Role role);

    public boolean existsByNom(String nom);

    public Role findByNom(String name);

}
