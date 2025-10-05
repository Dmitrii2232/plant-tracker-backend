package com.planttracker.service;

import com.planttracker.model.SeedSupplier;
import com.planttracker.repository.SeedSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedSupplierService {
    
    @Autowired
    private SeedSupplierRepository seedSupplierRepository;
    
    public List<SeedSupplier> getAllSuppliers() {
        return seedSupplierRepository.findAll();
    }
    
    public List<SeedSupplier> getSuppliersByPlantType(String plantType) {
        return seedSupplierRepository.findByPlantTypesContainingIgnoreCase(plantType);
    }
}