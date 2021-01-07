package com.example.assignment.repository;

import com.example.assignment.domain.RollDiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollDiceDetailsRepository extends JpaRepository<RollDiceDetails, Long> {
}
