package com.planttracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plant_facts")
public class PlantFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String plantType;
    private String fact;
    private String category; // выращивание, интересные факты, советы
    
    // Конструкторы, геттеры и сеттеры
    public PlantFact() {}
    
    public PlantFact(String plantType, String fact, String category) {
        this.plantType = plantType;
        this.fact = fact;
        this.category = category;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPlantType() { return plantType; }
    public void setPlantType(String plantType) { this.plantType = plantType; }
    
    public String getFact() { return fact; }
    public void setFact(String fact) { this.fact = fact; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}