package com.planttracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plants")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String species;
    private LocalDate plantingDate;
    private String description;
    private String imageUrl;
    
    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GrowthRecord> growthRecords = new ArrayList<>();
    
    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CareTask> careTasks = new ArrayList<>();
    
    public Plant() {}
    
    public Plant(String name, String species, LocalDate plantingDate, String description) {
        this.name = name;
        this.species = species;
        this.plantingDate = plantingDate;
        this.description = description;
    }
    
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }
    public LocalDate getPlantingDate() { return plantingDate; }
    public void setPlantingDate(LocalDate plantingDate) { this.plantingDate = plantingDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public List<GrowthRecord> getGrowthRecords() { return growthRecords; }
    public void setGrowthRecords(List<GrowthRecord> growthRecords) { this.growthRecords = growthRecords; }
    public List<CareTask> getCareTasks() { return careTasks; }
    public void setCareTasks(List<CareTask> careTasks) { this.careTasks = careTasks; }
}
