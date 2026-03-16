package com.gal.dao;
import com.gal.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTrainingDao extends JpaRepository<Training, Long> {

    @Query("SELECT t FROM Training t WHERE t.endDate >= CURRENT_DATE")
    List<Training> findCurrentAndUpcomingTrainings();

    @Query("SELECT t FROM Training t WHERE LOWER(t.topic) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "AND t.endDate >= CURRENT_DATE")
    List<Training> findCurrentAndUpcomingTrainingsWithSpecifiedTopic(String name);

    @Query("SELECT t FROM Training t WHERE LOWER(t.topic) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "AND t.startDate > CURRENT_DATE")
    List<Training> findUpcomingTrainingsWithSpecifiedTopic(String name);

}
