package com.planttracker.service;

import com.planttracker.model.Plant;
import com.planttracker.model.GrowthRecord;
import com.planttracker.repository.PlantRepository;
import com.planttracker.repository.GrowthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    
    @Autowired
    private PlantRepository plantRepository;
    
    @Autowired
    private GrowthRecordRepository growthRecordRepository;
    
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }
    
    public Optional<Plant> getPlantById(Long id) {
        return plantRepository.findById(id);
    }
    
    public Plant savePlant(Plant plant) {
        return plantRepository.save(plant);
    }
    
    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
    
    public GrowthRecord addGrowthRecord(Long plantId, GrowthRecord growthRecord) {
        Plant plant = plantRepository.findById(plantId)
            .orElseThrow(() -> new RuntimeException("Растение не найдено"));
        growthRecord.setPlant(plant);
        return growthRecordRepository.save(growthRecord);
    }
    
    public List<GrowthRecord> getGrowthRecords(Long plantId) {
        return growthRecordRepository.findByPlantIdOrderByRecordDateDesc(plantId);
    }
}