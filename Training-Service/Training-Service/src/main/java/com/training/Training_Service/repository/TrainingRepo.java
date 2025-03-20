package com.training.Training_Service.repository;

import com.training.Training_Service.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepo extends JpaRepository<Training,Integer>  {

}
