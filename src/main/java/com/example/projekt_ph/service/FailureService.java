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
}
