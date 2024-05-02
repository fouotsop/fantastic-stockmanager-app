package com.hivcaremanager.stockmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hivcaremanager.stockmanagement.model.Role;
import com.hivcaremanager.stockmanagement.repository.role.RoleRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class StockmanagementApplication {

	@Autowired
	private RoleRepository roleRepository;

	@Value("${app.roles.admin}")
	private String adminRole;
	@Value("${app.roles.aps}")
	private String apsRole;
	@Value("${app.roles.gs}")
	private String gsRole;

	
	public static void main(String[] args) {
		SpringApplication.run(StockmanagementApplication.class, args);

	}

	@PostConstruct
	public void init() {
		String[] roles = {adminRole, apsRole, gsRole};
		for (String role : roles) {
			if (!roleRepository.existsByNom(role)) {
				Role roleEntity = new Role();
				roleEntity.setNom(role);
				roleRepository.add(roleEntity);
			}
		}
	}
}
