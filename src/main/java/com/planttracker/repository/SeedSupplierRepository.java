package com.planttracker.repository;

import com.planttracker.model.SeedSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeedSupplierRepository extends JpaRepository<SeedSupplier, Long> {
    List<SeedSupplier> findByPlantTypesContainingIgnoreCase(String plantType);
}