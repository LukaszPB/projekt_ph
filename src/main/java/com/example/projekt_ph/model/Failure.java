package com.example.projekt_ph.model;

import com.example.projekt_ph.enums.FailureType;
import com.example.projekt_ph.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Failure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private FailureType failureType;
    private String name;
    private Date date;
    private double potentialCost;
    private Date potentialDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String repairDescription;
}
