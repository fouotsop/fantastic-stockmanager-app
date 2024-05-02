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

import com.hivcaremanager.stockmanagement.model.Departement;
import com.hivcaremanager.stockmanagement.service.departement.DepartementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Validated
@RestController
@RequestMapping(value = "/api/v1/departements")
@Tag(name = "Department API", description = "Department API")
public class DepartementController {
    
    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {

        this.departementService = departementService;
    }


    @Operation(summary = "Create a new department", description = "Create a new department")
    @ApiResponses(
        value = {@ApiResponse(responseCode = "201", description = "department added"),
        @ApiResponse(responseCode = "400", description = "bad request")}
    )
    @PostMapping(name = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> createDepartement(@RequestBody @Valid Departement departement) {

        departement = departementService.save(departement);

        return ResponseEntity.ok(departement);

    }

    @Operation(summary = "Get all departments", description = "fetch all departments from the database")
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "list of departments")
        }
    )
    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(departementService.findAll());
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody Departement departement) {
        departement.setId(id);
        departement = departementService.save(departement);
        return ResponseEntity.ok(departement);
    }

}
