package com.planttracker.controller;

import com.planttracker.model.Plant;
import com.planttracker.model.GrowthRecord;
import com.planttracker.service.PlantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plants")
@CrossOrigin(origins = "http://localhost:3000")
public class PlantController {
    
    @Autowired
    private PlantService plantService;
    
    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        Optional<Plant> plant = plantService.getPlantById(id);
        return plant.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Plant createPlant(@Valid @RequestBody Plant plant) {
        return plantService.savePlant(plant);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @Valid @RequestBody Plant plantDetails) {
        Optional<Plant> plant = plantService.getPlantById(id);
        if (plant.isPresent()) {
            Plant existingPlant = plant.get();
            existingPlant.setName(plantDetails.getName());
            existingPlant.setSpecies(plantDetails.getSpecies());
            existingPlant.setDescription(plantDetails.getDescription());
            existingPlant.setImageUrl(plantDetails.getImageUrl());
            return ResponseEntity.ok(plantService.savePlant(existingPlant));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{id}/growth-records")
    public GrowthRecord addGrowthRecord(@PathVariable Long id, @Valid @RequestBody GrowthRecord growthRecord) {
        return plantService.addGrowthRecord(id, growthRecord);
    }
    
    @GetMapping("/{id}/growth-records")
    public List<GrowthRecord> getGrowthRecords(@PathVariable Long id) {
        return plantService.getGrowthRecords(id);
    }
}
