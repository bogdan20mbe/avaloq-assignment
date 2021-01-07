package com.example.assignment.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(value = {MockitoExtension.class})
public class DiceServiceImplTest {

    @Spy
    DiceServiceImpl diceService;

    @Test
    public void test_sum_of_rolled_numbers() {
        Map<Integer, Integer> result = diceService.sumOfRolledNumbers(3, 6, 1000);
        result.entrySet().forEach(entry -> {
            assertTrue(entry.getKey() >= 3 && entry.getKey() <= 18);
            assertTrue(entry.getValue() >= 1 && entry.getValue() <= 1000);
        });
        assertEquals(1000, result.values().stream().reduce(0, Integer::sum));
    }

    //TODO add tests for the rest of the methods
}
