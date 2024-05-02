package com.hivcaremanager.stockmanagement.service.role;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Role;

@Service
public interface RoleService {

    public Role getByNom(String name);

}
