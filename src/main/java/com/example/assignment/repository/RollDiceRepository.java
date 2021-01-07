package com.example.assignment.repository;

import com.example.assignment.domain.RollDice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RollDiceRepository extends JpaRepository<RollDice, Long> {
}
