package com.hivcaremanager.stockmanagement.repository.antiretroviral;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hivcaremanager.stockmanagement.model.Antiretroviral;

public interface AntiretroviralJpaRepository extends JpaRepository<Antiretroviral, UUID>{
   
    boolean existsByNomAndLigneTraitementId(String nom, UUID ligneTraitementId);   

    List<Antiretroviral> findByLigneTraitementId(UUID ligneTraitementId);
}
