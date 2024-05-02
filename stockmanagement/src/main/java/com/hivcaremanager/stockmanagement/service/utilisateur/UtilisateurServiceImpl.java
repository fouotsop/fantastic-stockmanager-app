package com.hivcaremanager.stockmanagement.service.utilisateur;

import org.springframework.stereotype.Service;

import com.hivcaremanager.stockmanagement.model.Utilisateur;
import com.hivcaremanager.stockmanagement.repository.utilisateur.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl (UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur add(Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public Utilisateur findByEmail(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public Utilisateur update(Utilisateur utilisateur) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean existsByEmail(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByUsername'");
    }
    
}
