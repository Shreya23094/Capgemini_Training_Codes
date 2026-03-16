package com.gal.services;

import com.gal.dao.JpaTrainingDao;
import com.gal.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingServiceImpl implements TrainingService{

    @Autowired
    JpaTrainingDao jpaTrainingDao;

    @Override
    public List<Training> findCurrentAndUpcomingTrainings() {
        return jpaTrainingDao.findCurrentAndUpcomingTrainings();
    }

    @Override
    public List<Training> findCurrentAndUpcomingTrainingsWithSpecifiedTopic(String name) {
        return jpaTrainingDao.findCurrentAndUpcomingTrainingsWithSpecifiedTopic(name);
    }

    @Override
    public List<Training> findUpcomingTrainingsWithSpecifiedTopic(String name) {
        return jpaTrainingDao.findUpcomingTrainingsWithSpecifiedTopic(name);
    }
}
