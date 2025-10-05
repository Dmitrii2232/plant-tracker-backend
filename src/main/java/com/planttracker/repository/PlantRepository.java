package com.planttracker.repository;

import com.planttracker.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByNameContainingIgnoreCase(String name);
    List<Plant> findBySpeciesContainingIgnoreCase(String species);
}