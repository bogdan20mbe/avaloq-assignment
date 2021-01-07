package com.example.assignment.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class RollDiceDistributionDTO implements Serializable {
    private static final long serialVersionUID = 2L;

    private int rollsSum;
    private long rollsSumCount;

    public RollDiceDistributionDTO() {
    }

    public RollDiceDistributionDTO(int rollsSum, long rollsSumCount) {
        this.rollsSum = rollsSum;
        this.rollsSumCount = rollsSumCount;
    }

    public int getRollsSum() {
        return rollsSum;
    }

    public void setRollsSum(int rollsSum) {
        this.rollsSum = rollsSum;
    }

    public long getRollsSumCount() {
        return rollsSumCount;
    }

    public void setRollsSumCount(long rollsSumCount) {
        this.rollsSumCount = rollsSumCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollDiceDistributionDTO that = (RollDiceDistributionDTO) o;
        return rollsSum == that.rollsSum && rollsSumCount == that.rollsSumCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollsSum, rollsSumCount);
    }
}
