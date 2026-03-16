package com.gal.controller;


import com.gal.model.Training;
import com.gal.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    TrainingService trainingService;


    @GetMapping("/trainings")
    public ResponseEntity<List<Training>> findCurrentAndUpcomingTrainings()
    {
        return ResponseEntity.ok(trainingService.findCurrentAndUpcomingTrainings());
    }

    @GetMapping("/training")
    public ResponseEntity<List<Training>> findCurrentAndUpcomingTrainingsWithSpecifiedTopic(@RequestParam("name") String name)
    {
        return ResponseEntity.ok(trainingService.findCurrentAndUpcomingTrainingsWithSpecifiedTopic(name));
    }

    @GetMapping("/trainings/upcoming")
    public ResponseEntity<List<Training>> findUpcomingTrainingsWithSpecifiedTopic(@RequestParam("name") String name)
    {
        return ResponseEntity.ok(trainingService.findUpcomingTrainingsWithSpecifiedTopic(name));
    }
}
