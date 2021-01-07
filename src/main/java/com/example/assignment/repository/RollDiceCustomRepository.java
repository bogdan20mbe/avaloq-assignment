package com.example.assignment.repository;

import com.example.assignment.domain.dto.RollDiceDTO;
import com.example.assignment.domain.dto.RollDiceDistributionDTO;

import java.util.List;

public interface RollDiceCustomRepository {
    List<RollDiceDTO> getSimulationsAndRollsByAllCombinations();
    List<RollDiceDistributionDTO> getRollDiceDistribution(int nbDice, int nbSides);
}
