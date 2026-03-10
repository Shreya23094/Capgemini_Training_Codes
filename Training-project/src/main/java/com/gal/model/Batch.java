package com.gal.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Batch {

    @TableGenerator(name = "batchidgenerator", allocationSize = 1, initialValue = 101, table = "allidgenerator", valueColumnName = "nextbatchid")
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "batchidgenerator")
    long bid;
    String name;
    Date startDate;
    Date endDate;
    String content;
    String venue;

    @ManyToMany
    @JoinTable(name = "topicTeaching",
    joinColumns = { @JoinColumn(name="bid")},
    inverseJoinColumns = { @JoinColumn(name = "trainerid")})
    List<Trainer> trainers = new ArrayList<>();

//    @OneToMany(mappedBy = "batch")
//    @JoinTable(name = "topicteaching")
//    List<TopicTeaching> topicsTaugh = new ArrayList<>();
}
