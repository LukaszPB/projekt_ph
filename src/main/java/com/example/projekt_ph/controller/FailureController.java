package com.example.projekt_ph.controller;

import com.example.projekt_ph.model.Failure;
import com.example.projekt_ph.model.FailureDTO;
import com.example.projekt_ph.service.FailureService;
import com.example.projekt_ph.validator.EditValidationGroup;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<String> add(@RequestBody @Valid FailureDTO failureDTO, BindingResult result) {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body("Nieprawidłowe dane: " + result.getAllErrors());
        }
        failureService.addFailure(failureDTO);
        return ResponseEntity.ok().body("{\"message\": \"Sukces\"}");
    }
    @DeleteMapping("/Failure/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        try {
            failureService.deleteFailureById(id);
            return ResponseEntity.ok().body("{\"message\": \"Sukces\"}");
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Nieprawidłowe dane: " + e.getMessage());
        }
    }
    @PutMapping("/Failure/{id}")
    public ResponseEntity<String> put(
            @PathVariable("id") long id,
            @RequestBody @Validated({EditValidationGroup.class}) FailureDTO failureDTO,
            BindingResult result)
    {
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body("Nieprawidłowe dane: " + result.getAllErrors());
        }
        try {
            failureService.editFailure(id,failureDTO);
            return ResponseEntity.ok().body("{\"message\": \"Sukces\"}");
        }
        catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Nieprawidłowe dane: " + e.getMessage());
        }
    }
}
