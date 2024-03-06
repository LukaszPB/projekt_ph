package com.example.projekt_ph.controller;

import com.example.projekt_ph.enums.FailureType;
import com.example.projekt_ph.enums.Status;
import com.example.projekt_ph.model.FailureDTO;
import com.example.projekt_ph.service.FailureService;
import com.example.projekt_ph.model.Failure;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FailureController {
    private final FailureService failureService;
    @GetMapping("/Failures")
    public List<Failure> get() {
        return failureService.getAll();
    }
    @PostMapping("/Failure")
    public void add(@RequestBody FailureDTO failureDTO) {
        failureService.addFailure(failureDTO);
    }
    @DeleteMapping("/Failure/{id}")
    public void delete(@PathVariable("id") long id) {
        failureService.deleteFailureById(id);
    }
    @PutMapping("/Failure/{id}")
    public Failure put(@PathVariable("id") long id, @RequestBody FailureDTO failureDTO) {
        return null;
    }
}
