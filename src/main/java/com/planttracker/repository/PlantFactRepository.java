package com.planttracker.repository;

import com.planttracker.model.PlantFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantFactRepository extends JpaRepository<PlantFact, Long> {
    List<PlantFact> findByPlantTypeContainingIgnoreCase(String plantType);
    List<PlantFact> findByCategory(String category);
}