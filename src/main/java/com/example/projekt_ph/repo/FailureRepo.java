package com.example.projekt_ph.repo;

import com.example.projekt_ph.model.Failure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailureRepo extends JpaRepository<Failure, Long> {
}
