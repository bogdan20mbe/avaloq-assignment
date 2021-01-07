package com.example.assignment.web.rest;

import com.example.assignment.domain.dto.RollDiceDTO;
import com.example.assignment.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AssignmentResource {

    @Autowired
    DiceService diceService;

    @GetMapping("/static-dice")
    public Map<Integer, Integer> rollStaticDice() {
        Map<Integer, Integer> result = diceService.sumOfRolledNumbers(3, 6, 100);
        diceService.saveSumOfRolledNumbers(3, 6, 100, result);
        return result;
    }

    @GetMapping("/dice")
    public Map<Integer, Integer> rollDice(@RequestParam int nbOfDice, @RequestParam int nbOfSides, @RequestParam int nbOfRolls) {
        if (nbOfDice < 1 || nbOfRolls < 1 || nbOfSides < 4) {
            throw new IllegalArgumentException("Input params are not valid!");
        }
        Map<Integer, Integer> result = diceService.sumOfRolledNumbers(nbOfDice, nbOfSides, nbOfRolls);
        diceService.saveSumOfRolledNumbers(nbOfDice, nbOfSides, nbOfRolls, result);
        return result;
    }

    @GetMapping("/roll-dice/simulations-and-rolls")
    public List<RollDiceDTO> getSimulationsAndRollsByAllCombinations() {
        return diceService.getSimulationsAndRollsByAllCombinations();
    }

    @GetMapping("/roll-dice/relative-distributions")
    public Map<Integer, Double> getRelativeDistribution(@RequestParam int nbOfDice, @RequestParam int nbOfSides) {
        return diceService.getRelativeDistribution(nbOfDice, nbOfSides);
    }

}
