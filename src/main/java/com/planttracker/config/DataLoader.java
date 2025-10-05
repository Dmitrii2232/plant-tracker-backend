package com.planttracker.config;

import com.planttracker.model.Plant;
import com.planttracker.model.PlantFact;
import com.planttracker.model.SeedSupplier;
import com.planttracker.repository.PlantFactRepository;
import com.planttracker.repository.PlantRepository;
import com.planttracker.repository.SeedSupplierRepository;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private PlantFactRepository plantFactRepository;
    
    @Autowired
    private SeedSupplierRepository seedSupplierRepository;
    
    @Autowired
    private PlantRepository plantRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Загрузка фактов о растениях
        plantFactRepository.saveAll(Arrays.asList(
            new PlantFact("Томаты", "Томаты нуждаются в минимум 6-8 часах солнечного света в день", "советы"),
            new PlantFact("Томаты", "Поливайте томаты у корня, избегая попадания воды на листья", "советы"),
            new PlantFact("Томаты", "Пасынкование помогает увеличить урожайность", "советы"),
            new PlantFact("Огурцы", "Огурцы любят влажную почву и регулярный полив", "советы"),
            new PlantFact("Огурцы", "Оптимальная температура для роста огурцов: 25-30°C", "советы"),
            new PlantFact("Розы", "Розы требуют регулярной обрезки для лучшего цветения", "советы"),
            new PlantFact("Общие", "Растения поглощают углекислый газ и выделяют кислород", "факты"),
            new PlantFact("Общие", "Некоторые растения могут очищать воздух от токсинов", "факты"),
            new PlantFact("Общие", "Растения могут общаться через химические сигналы", "интересные факты")
        ));
        
        // Загрузка поставщиков семян
        seedSupplierRepository.saveAll(Arrays.asList(
            new SeedSupplier("Семена Онлайн", "https://semena-online.ru", 
                "Томаты, Огурцы, Перцы, Баклажаны", "Широкий выбор семян овощных культур"),
            new SeedSupplier("Агрофирма Поиск", "https://semena.poisk.com", 
                "Все виды растений", "Ведущий производитель семян в России"),
            new SeedSupplier("Гавриш", "https://gavrish.ru", 
                "Овощные культуры, Цветы", "Семена премиум-класса"),
            new SeedSupplier("Русский Огород", "https://rusogorod.ru", 
                "Редкие сорта, Экзотические растения", "Уникальная коллекция семян")
        ));

        // Тестовые растения
        plantRepository.saveAll(Arrays.asList(
            new Plant("Помидорчик", "Томат Черри", LocalDate.now().minusDays(30), "Первый опыт выращивания томатов"),
            new Plant("Базилик душистый", "Базилик", LocalDate.now().minusDays(15), "Выращиваю на кухонном подоконнике"),
            new Plant("Алоэ Вера", "Алоэ", LocalDate.now().minusMonths(6), "Лечебное растение")
        ));
    }
}