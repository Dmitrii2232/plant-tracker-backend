package com.planttracker.controller;

import com.planttracker.model.CareTask;
import com.planttracker.service.CareTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plants/{plantId}/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class CareTaskController {
    
    @Autowired
    private CareTaskService careTaskService;
    
    @GetMapping
    public List<CareTask> getPlantTasks(@PathVariable Long plantId) {
        return careTaskService.getTasksByPlant(plantId);
    }
    
    @PostMapping
    public CareTask createTask(@PathVariable Long plantId, @RequestBody CareTask task) {
        return careTaskService.createTask(plantId, task);
    }
    
    @PutMapping("/{taskId}/status")
    public CareTask updateTaskStatus(@PathVariable Long taskId, @RequestBody Map<String, Boolean> status) {
        return careTaskService.updateTaskStatus(taskId, status.get("completed"));
    }
    
    @PutMapping("/{taskId}")
    public ResponseEntity<CareTask> updateTask(@PathVariable Long taskId, @RequestBody CareTask taskDetails) {
        try {
            CareTask updatedTask = careTaskService.updateTask(taskId, taskDetails);
            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        careTaskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/overdue")
    public List<CareTask> getOverdueTasks() {
        return careTaskService.getOverdueTasks();
    }
    
    @GetMapping("/upcoming")
    public List<CareTask> getUpcomingTasks() {
        return careTaskService.getUpcomingTasks();
    }
}