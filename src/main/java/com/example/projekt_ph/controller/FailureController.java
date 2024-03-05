package com.example.projekt_ph.controller;

import com.example.projekt_ph.service.FailureService;
import com.example.projekt_ph.model.Failure;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FailureController {
    private final FailureService failureService;
    @GetMapping("/Failures")
    public List<Failure> get() {
        return failureService.getAll();
    }
    @PostMapping("/Failure")
    public void add(Failure failure) {
        failureService.addFailure(failure);
    }
    @DeleteMapping("/Failure/{id}")
    public void delete(@PathVariable Long id) {
        Failure failure = failureService.getFailure(id);
    }
    @PutMapping("/Failure/{id}")
    public void put() {

    }
}
