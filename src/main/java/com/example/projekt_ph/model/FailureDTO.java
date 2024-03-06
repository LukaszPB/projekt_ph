package com.example.projekt_ph.model;

import com.example.projekt_ph.enums.FailureType;
import com.example.projekt_ph.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FailureDTO {

    private long id;
    private FailureType failureType;
    private String name;
    private Date date;
    private double potentialCost;
    private Date potentialDate;
    private Status status;
    private String repairDescription;

}
