package com.gal.model;

import jakarta.persistence.*;

import java.sql.Date;

public class TopicTeaching {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long teachingid;
    @ManyToOne
    Trainer trainer;

    @ManyToOne
    Batch batch;

    Date stDate;
    Date endDate;
    String topics;


}
