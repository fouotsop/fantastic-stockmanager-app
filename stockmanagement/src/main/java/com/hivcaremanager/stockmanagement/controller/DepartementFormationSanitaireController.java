package com.hivcaremanager.stockmanagement.controller;

import java.util.List;
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

import com.hivcaremanager.stockmanagement.model.Departement;
import com.hivcaremanager.stockmanagement.model.FormationSanitaire;
import com.hivcaremanager.stockmanagement.service.formationsanitaire.FormationSanitaireService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;



@Tag(name = "Health facilities API", description = "Health facilities for a particular department API")
@RestController
@RequestMapping(value = "/api/v1/departements/{id}/formation-sanitaires")
@Validated
public class DepartementFormationSanitaireController {

    private final FormationSanitaireService formationSanitaireService;


    public DepartementFormationSanitaireController(FormationSanitaireService formationSanitaireService) {
        this.formationSanitaireService = formationSanitaireService;
    }   

    @Operation(summary = "Add a health facility to a department", description = "Add a health facility to a department")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "health facility added")
        }
    )
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> add (@PathVariable(name = "id") UUID id,@RequestBody @Valid FormationSanitaire formationSanitaire) {
        
        formationSanitaire.setDepartement(new Departement());
        formationSanitaire.getDepartement().setId(id);

        formationSanitaire = formationSanitaireService.save(formationSanitaire);

        return ResponseEntity.ok(formationSanitaire);
    }

    @PutMapping("/{formationSanitaireId}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @PathVariable("formationSanitaireId") UUID formationSanitaireId, @RequestBody @Valid FormationSanitaire formationSanitaire) {
        
        formationSanitaire.setDepartement(new Departement());
        formationSanitaire.getDepartement().setId(id);
        formationSanitaire.setId(formationSanitaireId);

        formationSanitaire = formationSanitaireService.update(formationSanitaire);
        return ResponseEntity.ok(formationSanitaire);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll(@PathVariable("id") UUID id) {
        List<FormationSanitaire> results = formationSanitaireService.findByDepartementId(id);
        return ResponseEntity.ok().body(results);
    }
    


}
