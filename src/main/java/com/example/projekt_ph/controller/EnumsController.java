package com.example.projekt_ph.controller;

import com.example.projekt_ph.enums.FailureType;
import com.example.projekt_ph.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnumsController {
    @GetMapping("/FailureTypes")
    public FailureType[] getFailureTypes() {
        return FailureType.values();
    }
    @GetMapping("/Statuses")
    public Status[] getStatuses() {
        return Status.values();
    }
}
