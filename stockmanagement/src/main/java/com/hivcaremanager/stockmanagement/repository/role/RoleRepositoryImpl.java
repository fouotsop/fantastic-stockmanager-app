package com.hivcaremanager.stockmanagement.repository.role;

import org.springframework.stereotype.Repository;

import com.hivcaremanager.stockmanagement.model.Role;

@Repository
public class RoleRepositoryImpl implements RoleRepository{

    private final RoleJpaRepository roleJpaRepository;

    public RoleRepositoryImpl(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }   

    @Override
    public Role add(Role role) {
        return this.roleJpaRepository.save(role);
    }

    @Override
    public boolean existsByNom(String nom) {
        return this.roleJpaRepository.existsByNom(nom);
    }

    @Override
    public Role findByNom(String name) {
        return this.roleJpaRepository.findByNom(name);
    }
    
}
