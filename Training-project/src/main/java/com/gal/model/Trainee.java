package com.gal.model;

import jakarta.persistence.*;

@Entity
public class Trainee {

    @SequenceGenerator(name = "traineesq", allocationSize = 1, initialValue = 1001, sequenceName = "traineesq")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traineesq")
    long superid;

    @Column(nullable = false)
    String name;

    String institute;
    String email;
    String phone;

    @ManyToOne
    Batch batch;

}
