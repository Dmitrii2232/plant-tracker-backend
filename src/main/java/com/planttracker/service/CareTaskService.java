package com.planttracker.service;

import com.planttracker.model.CareTask;
import com.planttracker.model.Plant;
import com.planttracker.repository.CareTaskRepository;
import com.planttracker.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CareTaskService {
    
    @Autowired
    private CareTaskRepository careTaskRepository;
    
    @Autowired
    private PlantRepository plantRepository;
    
    public List<CareTask> getTasksByPlant(Long plantId) {
        return careTaskRepository.findByPlantIdOrderByDueDateAsc(plantId);
    }
    
    public List<CareTask> getOverdueTasks() {
        return careTaskRepository.findByCompletedFalseAndDueDateLessThanEqual(LocalDate.now());
    }
    
    public List<CareTask> getUpcomingTasks() {
        return careTaskRepository.findByCompletedFalseOrderByDueDateAsc();
    }
    
    public CareTask createTask(Long plantId, CareTask task) {
        Plant plant = plantRepository.findById(plantId)
            .orElseThrow(() -> new RuntimeException("Растение не найдено"));
        task.setPlant(plant);
        return careTaskRepository.save(task);
    }
    
    public CareTask updateTaskStatus(Long taskId, boolean completed) {
        CareTask task = careTaskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Задача не найдена"));
        task.setCompleted(completed);
        return careTaskRepository.save(task);
    }
    
    public void deleteTask(Long taskId) {
        careTaskRepository.deleteById(taskId);
    }
    
    public CareTask updateTask(Long taskId, CareTask taskDetails) {
        CareTask task = careTaskRepository.findById(taskId)
            .orElseThrow(() -> new RuntimeException("Задача не найдена"));
        
        task.setTaskType(taskDetails.getTaskType());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setPriority(taskDetails.getPriority());
        
        return careTaskRepository.save(task);
    }
}