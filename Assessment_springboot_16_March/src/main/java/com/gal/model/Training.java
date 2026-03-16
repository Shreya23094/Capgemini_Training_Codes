package com.gal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Entity
@Table(name = "training")
@Getter
@Setter
public class Training {

    @Id
    @SequenceGenerator(
            name = "training_seq_gen",
            sequenceName = "training_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "training_seq_gen"
    )
    private Long trainingId;

    private String topic;
    private LocalDate startDate;
    private LocalDate endDate;
    private String trainerName;
    private String venue;
}
