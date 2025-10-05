package com.planttracker.controller;

import com.planttracker.model.SeedSupplier;
import com.planttracker.service.SeedSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000")
public class SeedSupplierController {
    
    @Autowired
    private SeedSupplierService seedSupplierService;
    
    @GetMapping
    public List<SeedSupplier> getAllSuppliers() {
        return seedSupplierService.getAllSuppliers();
    }
    
    @GetMapping("/plant-type/{plantType}")
    public List<SeedSupplier> getSuppliersByPlantType(@PathVariable String plantType) {
        return seedSupplierService.getSuppliersByPlantType(plantType);
    }
}