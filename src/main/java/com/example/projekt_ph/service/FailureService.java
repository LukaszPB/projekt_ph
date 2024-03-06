package com.example.projekt_ph.service;

import com.example.projekt_ph.repo.FailureRepo;
import com.example.projekt_ph.model.Failure;
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
    public Failure getFailure(long id){
        return failureRepo.getReferenceById(id);
    }
    public void addFailure(Failure failure)
    {
        failureRepo.save(failure);
    }

    public void deleteFailureById(long id){
        failureRepo.deleteById(id);
    }
}
