package com.planttracker.repository;

import com.planttracker.model.CareTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CareTaskRepository extends JpaRepository<CareTask, Long> {
    List<CareTask> findByPlantIdOrderByDueDateAsc(Long plantId);
    List<CareTask> findByCompletedFalseAndDueDateLessThanEqual(LocalDate date);
    List<CareTask> findByCompletedFalseOrderByDueDateAsc();
    List<CareTask> findByPlantIdAndCompletedFalse(Long plantId);
}