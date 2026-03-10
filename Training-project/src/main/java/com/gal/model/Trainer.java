package com.gal.model;

import jakarta.persistence.*;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long trainerid;
    @Column(unique = true)
    long capgtrainerid;
    @Column(nullable = false)
    String name;
    String company;
    String specialization;
}
