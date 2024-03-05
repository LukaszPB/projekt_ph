package com.example.projekt_ph.controller;

import com.example.projekt_ph.service.FailureService;
import com.example.projekt_ph.model.Failure;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FailureController {
    private final FailureService failureService;
    @GetMapping("")
    public List<Failure> get() {
        return failureService.getAll();
    }
}
