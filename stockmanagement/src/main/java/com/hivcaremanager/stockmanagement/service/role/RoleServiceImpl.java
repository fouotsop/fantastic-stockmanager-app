package com.hivcaremanager.stockmanagement.service.role;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Role;
import com.hivcaremanager.stockmanagement.repository.role.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByNom(String name) {
        return roleRepository.findByNom(name); 
    }
    
    
}
