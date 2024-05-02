package com.hivcaremanager.stockmanagement.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hivcaremanager.stockmanagement.dto.response.ResponseMessage;
import com.hivcaremanager.stockmanagement.model.Compte;
import com.hivcaremanager.stockmanagement.model.FormationSanitaire;
import com.hivcaremanager.stockmanagement.model.Role;
import com.hivcaremanager.stockmanagement.model.Utilisateur;
import com.hivcaremanager.stockmanagement.service.compte.CompteService;
import com.hivcaremanager.stockmanagement.service.role.RoleService;
import com.hivcaremanager.stockmanagement.service.utilisateur.UtilisateurService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/comptes")
public class CompteController {
    
    @Value("${app.roles.admin}")
    private String adminRole;

    @Value("${app.roles.aps}")
    private String apsRole;

    @Value("${app.roles.gs}")
    private String gsRole;

    private final RoleService roleService;
    private final CompteService compteService;
    private final UtilisateurService utilisateurService;

    public CompteController(CompteService compteService,RoleService roleService, UtilisateurService utilisateurService) {

        this.roleService = roleService;
        this.compteService = compteService;
        this.utilisateurService = utilisateurService;
    }   

    @Operation(summary = "create an account with stock manager role", description = "Create an account with a stock manager role")
    @PostMapping(value = "/admins/gs", produces = {"application/json"})
    public ResponseEntity<?> register(
        @RequestParam(name = "login") String login,
        @RequestParam(name = "password") String password,
        @RequestParam(name = "nom") String nom,
        @RequestParam(name = "email") String email,
        @RequestParam(name = "fonction") String fonction,
        @RequestParam(name = "formationSanitaire") UUID formationSanitaire
    ) {

        Compte compte = new Compte();

        compte.setLogin(login);
        compte.setPassword(password);

        compte.setRole(new Role());
        compte.getRole().setId(roleService.getByNom(gsRole).getId());

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setCompte(compte);
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setFonction(fonction);
        utilisateur.setFormationSanitaire(new FormationSanitaire());
        utilisateur.getFormationSanitaire().setId(formationSanitaire);  

        compte.setUtilisateur(utilisateur);

        compte = compteService.add(compte);
        return ResponseEntity.ok().body(new ResponseMessage("Account created successfully"));
    }   
}
