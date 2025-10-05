package com.planttracker.service;

import com.planttracker.model.PlantFact;
import com.planttracker.repository.PlantFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PlantFactService {
    
    @Autowired
    private PlantFactRepository plantFactRepository;
    
    public List<PlantFact> getAllFacts() {
        return plantFactRepository.findAll();
    }
    
    public List<PlantFact> getFactsByPlantType(String plantType) {
        return plantFactRepository.findByPlantTypeContainingIgnoreCase(plantType);
    }
    
    public List<PlantFact> getFactsByCategory(String category) {
        return plantFactRepository.findByCategory(category);
    }
    
    public PlantFact getRandomFact() {
        List<PlantFact> allFacts = getAllFacts();
        if (allFacts.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return allFacts.get(random.nextInt(allFacts.size()));
    }
}