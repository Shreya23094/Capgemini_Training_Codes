package com.gal.services;

import com.gal.model.Training;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingService {

    List<Training> findCurrentAndUpcomingTrainings();

    List<Training> findCurrentAndUpcomingTrainingsWithSpecifiedTopic(String name);

    List<Training> findUpcomingTrainingsWithSpecifiedTopic(String name);
}
