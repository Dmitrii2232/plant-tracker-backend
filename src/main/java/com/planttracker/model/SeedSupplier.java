package com.planttracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "seed_suppliers")
public class SeedSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String website;
    private String plantTypes;
    private String description;
    
    
    public SeedSupplier() {}
    
    public SeedSupplier(String name, String website, String plantTypes, String description) {
        this.name = name;
        this.website = website;
        this.plantTypes = plantTypes;
        this.description = description;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }
    
    public String getPlantTypes() { return plantTypes; }
    public void setPlantTypes(String plantTypes) { this.plantTypes = plantTypes; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
