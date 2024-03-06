package com.example.projekt_ph.service;

import com.example.projekt_ph.model.Failure;
import com.example.projekt_ph.model.FailureDTO;
import com.example.projekt_ph.repo.FailureRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FailureService {
    private FailureRepo failureRepo;
    public List<Failure> getAll() {
        return failureRepo.findAll();
    }
    public Failure getFailure(long id) throws EntityNotFoundException{
        return failureRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Failure with id " + id + " not found"));
    }
    @Transactional
    public void addFailure(FailureDTO failureDTO) {
        failureRepo.save(buildFailure(failureDTO));
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
    @Transactional
    public void editFailure(long id,FailureDTO failureDTO) throws EntityNotFoundException{
        Failure existingFailure = getFailure(id);

        existingFailure.setPotentialCost(failureDTO.getPotentialCost());
        existingFailure.setPotentialDate(failureDTO.getPotentialDate());
        existingFailure.setStatus(failureDTO.getStatus());
        existingFailure.setRepairDescription(failureDTO.getRepairDescription());

        failureRepo.save(existingFailure);
    }
    @Transactional
    public void deleteFailureById(long id) throws EntityNotFoundException{
        Failure existingFailure = getFailure(id);
        failureRepo.delete(existingFailure);
    }
}
