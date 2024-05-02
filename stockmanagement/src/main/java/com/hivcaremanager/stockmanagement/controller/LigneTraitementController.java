package com.hivcaremanager.stockmanagement.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hivcaremanager.stockmanagement.dto.response.ResponseMessage;
import com.hivcaremanager.stockmanagement.model.LigneTraitement;
import com.hivcaremanager.stockmanagement.service.lignetraitement.LigneTraitementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "HIV Treatment regimen api", description = "HIV treatment regimen API endpoints")
@RestController
@RequestMapping(value = "/api/v1/lignes-traitements")
@Validated
public class LigneTraitementController {



    private final LigneTraitementService ligneTraitementService;

    public LigneTraitementController(LigneTraitementService ligneTraitementService) {
        this.ligneTraitementService = ligneTraitementService;
    }


    @Operation(summary = "Add an HIV treatment regimen", description = "Add an HIV treatment regimen")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "HIV treatment regimen added succesffully")
        }
    )
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<ResponseMessage> add (@RequestBody @Valid LigneTraitement ligneTraitement) {
        
        ligneTraitement = ligneTraitementService.add(ligneTraitement);

        return ResponseEntity.ok(new ResponseMessage("HIV treatment regimen added successfully"));

    }
    
    @Operation(summary = "Update an HIV treatment regimen", description = "Update an HIV treatment regimen")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Hiv treatment regimen modified successfully")
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody @Valid LigneTraitement ligneTraitement) {
        
        ligneTraitement.setId(id);
        ligneTraitement = ligneTraitementService.add(ligneTraitement);

        return ResponseEntity.ok().body(ligneTraitement);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(ligneTraitementService.findAll());
    }
    




}
