package com.example.assignment.service.impl;

import com.example.assignment.domain.Dice;
import com.example.assignment.domain.RollDice;
import com.example.assignment.domain.RollDiceDetails;
import com.example.assignment.domain.dto.RollDiceDTO;
import com.example.assignment.domain.dto.RollDiceDistributionDTO;
import com.example.assignment.repository.RollDiceCustomRepository;
import com.example.assignment.repository.RollDiceRepository;
import com.example.assignment.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiceServiceImpl implements DiceService {

    @Autowired
    RollDiceRepository rollDiceRepository;

    @Autowired
    RollDiceCustomRepository rollDiceCustomRepository;

    @Override
    public Map<Integer, Integer> sumOfRolledNumbers(int nbOfDice, int nbOfSides, int nbOfRolls) {
        Map<Integer, Integer> mapOfRolledNumbers = new HashMap<>();
        List<Dice> diceList = new ArrayList<>();
        for (int i=1; i<=nbOfDice; i++) {
            Dice dice = new Dice(nbOfSides);
            diceList.add(dice);
        }

        for (int i=1; i<=nbOfRolls; i++) {
            int sum = 0;
            for (Dice dice : diceList) {
                sum += dice.roll();
            }
            if (mapOfRolledNumbers.computeIfPresent(sum, (key, val) -> val + 1) == null) {
                mapOfRolledNumbers.put(sum, 1);
            }
        }
        return mapOfRolledNumbers;
    }

    @Override
    public RollDice saveSumOfRolledNumbers(int nbOfDice, int nbOfSides, int nbOfRolls, Map<Integer, Integer> rolledNumbers) {
        RollDice rollDice = new RollDice();
        rollDice.setNbDice(nbOfDice);
        rollDice.setNbRolls(nbOfRolls);
        rollDice.setNbSides(nbOfSides);
        rolledNumbers.entrySet().forEach(entry -> {
            RollDiceDetails rollDiceDetails = new RollDiceDetails();
            rollDiceDetails.setRollsSum(entry.getKey());
            rollDiceDetails.setRollsSumCount(entry.getValue());
            rollDiceDetails.setRollDice(rollDice);
            rollDice.addRollDiceDetails(rollDiceDetails);
        });

        return rollDiceRepository.save(rollDice);
    }

    @Override
    public List<RollDiceDTO> getSimulationsAndRollsByAllCombinations() {
        return rollDiceCustomRepository.getSimulationsAndRollsByAllCombinations();
    }

    @Override
    public Map<Integer, Double> getRelativeDistribution(int nbDice, int nbSides) {
        Map<Integer, Double> result = new HashMap<>();
        List<RollDiceDistributionDTO> rollDiceDistributionDTOS = rollDiceCustomRepository.getRollDiceDistribution(nbDice, nbSides);
        long totalRolls = rollDiceDistributionDTOS.stream().map(RollDiceDistributionDTO::getRollsSumCount).reduce(0L, Long::sum);

        rollDiceDistributionDTOS.forEach(dto -> {
            result.put(dto.getRollsSum(), ((double)dto.getRollsSumCount()/totalRolls) * 100);
        });
        return result;
    }
}
