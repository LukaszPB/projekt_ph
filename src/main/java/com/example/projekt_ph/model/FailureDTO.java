package com.example.projekt_ph.model;

import com.example.projekt_ph.enums.FailureType;
import com.example.projekt_ph.enums.Status;
import com.example.projekt_ph.validator.EditValidationGroup;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FailureDTO {

    private long id;
    @NotNull(message = "FailureType cannot be null")
    private FailureType failureType;
    @NotEmpty(message = "Name can't be empty")
    @Size(min=1, max=250, message = "Name length must be between 1 and 250 characters")
    private String name;
    @NotNull(message = "Date cannot be null")
    @Past(message = "Date must be from the past")
    private Date date;
    @Positive(groups = EditValidationGroup.class, message = "PotentialCost must be positive")
    private double potentialCost;
    @NotNull(groups = EditValidationGroup.class, message = "PotentialDate cannot be null")
    @Future(groups = EditValidationGroup.class, message = "PotentialDate must be from the future")
    private Date potentialDate;
    @NotNull(groups = EditValidationGroup.class, message = "Status cannot be null")
    private Status status;
    @NotEmpty(groups = EditValidationGroup.class, message = "Name can't be empty")
    @Size(groups = EditValidationGroup.class, min=1, max=750, message = "RepairDescription length must be between 1 and 250 characters")
    private String repairDescription;
}
