package com.example.assignment.service;

import com.example.assignment.domain.RollDice;
import com.example.assignment.domain.dto.RollDiceDTO;

import java.util.List;
import java.util.Map;

public interface DiceService {
    Map<Integer, Integer> sumOfRolledNumbers(int nbOfDice, int nbOfSides, int nbOfRolls);
    RollDice saveSumOfRolledNumbers(int nbOfDice, int nbOfSides, int nbOfRolls, Map<Integer, Integer> rolledNumbers);
    List<RollDiceDTO> getSimulationsAndRollsByAllCombinations();
    Map<Integer, Double> getRelativeDistribution(int nbDice, int nbSides);
}
