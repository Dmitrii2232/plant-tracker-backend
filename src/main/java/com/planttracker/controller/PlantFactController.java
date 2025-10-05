package com.planttracker.controller;

import com.planttracker.model.PlantFact;
import com.planttracker.service.PlantFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facts")
@CrossOrigin(origins = "http://localhost:3000")
public class PlantFactController {
    
    @Autowired
    private PlantFactService plantFactService;
    
    @GetMapping
    public List<PlantFact> getAllFacts() {
        return plantFactService.getAllFacts();
    }
    
    @GetMapping("/random")
    public PlantFact getRandomFact() {
        return plantFactService.getRandomFact();
    }
    
    @GetMapping("/plant-type/{plantType}")
    public List<PlantFact> getFactsByPlantType(@PathVariable String plantType) {
        return plantFactService.getFactsByPlantType(plantType);
    }
    
    @GetMapping("/category/{category}")
    public List<PlantFact> getFactsByCategory(@PathVariable String category) {
        return plantFactService.getFactsByCategory(category);
    }
}