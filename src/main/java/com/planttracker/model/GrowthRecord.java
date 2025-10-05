package com.planttracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "growth_records")
public class GrowthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plant_id")
    private Plant plant;
    
    @NotNull
    private Double height; // высота в см
    
    private Integer leafCount;
    private String notes;
    private String imageUrl;
    
    @NotNull
    private LocalDateTime recordDate;
    
    // Конструкторы, геттеры и сеттеры
    public GrowthRecord() {}
    
    public GrowthRecord(Plant plant, Double height, Integer leafCount, String notes, LocalDateTime recordDate) {
        this.plant = plant;
        this.height = height;
        this.leafCount = leafCount;
        this.notes = notes;
        this.recordDate = recordDate;
    }
    
    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Plant getPlant() { return plant; }
    public void setPlant(Plant plant) { this.plant = plant; }
    
    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    
    public Integer getLeafCount() { return leafCount; }
    public void setLeafCount(Integer leafCount) { this.leafCount = leafCount; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public LocalDateTime getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDateTime recordDate) { this.recordDate = recordDate; }
}