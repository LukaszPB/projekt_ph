package com.example.projekt_ph.service;

import com.example.projekt_ph.model.FailureDTO;
import com.example.projekt_ph.repo.FailureRepo;
import com.example.projekt_ph.model.Failure;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.function.FailableObjDoubleConsumer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FailureService {
    private FailureRepo failureRepo;
    public List<Failure> getAll() {
        return failureRepo.findAll();
    }
    public Failure getFailure(long id){
        return failureRepo.getReferenceById(id);
    }

    public void addFailure(FailureDTO failureDTO)
    {
        failureRepo.save(buildFailure(failureDTO));
    }

    @Transactional
    public void editFailure(long id,FailureDTO failureDTO){
        Failure existingFailure = failureRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Failure with id " + id + " not found"));

        existingFailure.setName(failureDTO.getName());
        existingFailure.setDate(failureDTO.getDate());
        existingFailure.setPotentialCost(failureDTO.getPotentialCost());
        existingFailure.setPotentialDate(failureDTO.getPotentialDate());
        existingFailure.setStatus(failureDTO.getStatus());
        existingFailure.setRepairDescription(failureDTO.getRepairDescription());
        existingFailure.setFailureType(failureDTO.getFailureType());

        failureRepo.save(existingFailure);

    }

    public Failure buildFailure(FailureDTO failureDTO){
        return Failure.builder()
                .name(failureDTO.getName())
                .date(failureDTO.getDate())
                .potentialCost(failureDTO.getPotentialCost())
                .potentialDate(failureDTO.getPotentialDate())
                .status(failureDTO.getStatus())
                .repairDescription(failureDTO.getRepairDescription())
                .failureType(failureDTO.getFailureType())
                .build();
    }

    public void deleteFailureById(long id){
        failureRepo.deleteById(id);
    }
}
