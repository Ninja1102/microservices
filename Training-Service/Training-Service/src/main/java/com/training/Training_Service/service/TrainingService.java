package com.training.Training_Service.service;

import com.training.Training_Service.entity.Training;

import com.training.Training_Service.repository.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepo repo;

    //Create or Update
    public Training createOrUpdateTraining(Training training) {
        return repo.save(training);
    }

    //Get All Trainings
    public List<Training> getAllTrainings(){
        return repo.findAll();
    }

    //Get Training by ID
    public Optional<Training> getTrainingById(int id){
        return repo.findById(id);
    }

    //Delete Training by ID
    public void deleteTraining(int id){
        repo.deleteById(id);
    }
}
