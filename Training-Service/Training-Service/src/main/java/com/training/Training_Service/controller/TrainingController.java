package com.training.Training_Service.controller;

import com.training.Training_Service.entity.Training;
import com.training.Training_Service.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService service;

    //Create or Update Training
    @PostMapping
    public Training createTraining(@RequestBody Training training){
        return service.createOrUpdateTraining(training);
    }

    //Get All Trainings
    @GetMapping
    public List<Training> getAllTrainings(){
        return service.getAllTrainings();
    }

    // Get Training by ID
    @GetMapping("/{id}")
    public Optional<Training> getTrainingById(@PathVariable int id){
        return service.getTrainingById(id);
    }

    // Delete Training by ID
    @DeleteMapping("/{id}")
    public String deleteTraining(@PathVariable int id){
        service.deleteTraining(id);
        return "Training with ID " + id + " has been deleted.";
    }

}
