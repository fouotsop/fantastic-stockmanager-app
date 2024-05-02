package com.hivcaremanager.stockmanagement.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hivcaremanager.stockmanagement.model.Antiretroviral;
import com.hivcaremanager.stockmanagement.model.LigneTraitement;
import com.hivcaremanager.stockmanagement.service.antiretroviral.AntiretroviralService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Antiretroviral API", description = "Antiretroviral API endpoints")
@RequestMapping("api/v1/ligne-traitements/{id}/antiretrovirals")
public class AntiretrovialController {
    
    private final AntiretroviralService antiretroviralService;


    public AntiretrovialController(AntiretroviralService antiretroviralService) {
        this.antiretroviralService = antiretroviralService;
    }   

    @Operation(summary = "Add an antiretroviral to a treatment regimen", description = "Add an antiretroviral to a treatment regimen")
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> add(@PathVariable("id") UUID id, @RequestBody @Valid Antiretroviral antiretroviral) {

        antiretroviral.setLigneTraitement(new LigneTraitement());
        antiretroviral.getLigneTraitement().setId(id);

        antiretroviral = antiretroviralService.add(antiretroviral);

        return ResponseEntity.ok().body(antiretroviral);
    }

    @Operation(summary = "Update an antiretroviral in a treatment regimen", description = "Update an antiretroviral in a treatment regimen")
    @PutMapping(value = "/{antiretroviralId}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @PathVariable("antiretroviralId") UUID antiretroviralId, @RequestBody @Valid Antiretroviral antiretroviral) {

        antiretroviral.setLigneTraitement(new LigneTraitement());
        antiretroviral.getLigneTraitement().setId(id);

        antiretroviral = antiretroviralService.update(antiretroviral);

        return ResponseEntity.ok().body(antiretroviral);
    }   

    @Operation(summary = "Change the treatment regimen of an antiretroviral", description = "Change the treatment regimen of an antiretroviral")
    @PutMapping(value = "/{antiretroviralId}/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> changeLigneTraitement(@PathVariable("id") UUID id, @PathVariable("antiretroviralId") UUID antiretroviralId, @RequestParam("ligneTraitementId") UUID ligneTraitementId) {   

        return null;

    }
}

