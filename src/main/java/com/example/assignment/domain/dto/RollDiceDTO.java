package com.example.assignment.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class RollDiceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int nbDice;
    private int nbSides;
    private long totalSimulations;
    private long totalRolls;

    public RollDiceDTO() {
    }

    public RollDiceDTO(int nbDice, int nbSides, long totalSimulations, long totalRolls) {
        this.nbDice = nbDice;
        this.nbSides = nbSides;
        this.totalSimulations = totalSimulations;
        this.totalRolls = totalRolls;
    }

    public int getNbDice() {
        return nbDice;
    }

    public void setNbDice(int nbDice) {
        this.nbDice = nbDice;
    }

    public int getNbSides() {
        return nbSides;
    }

    public void setNbSides(int nbSides) {
        this.nbSides = nbSides;
    }

    public long getTotalSimulations() {
        return totalSimulations;
    }

    public void setTotalSimulations(long totalSimulations) {
        this.totalSimulations = totalSimulations;
    }

    public long getTotalRolls() {
        return totalRolls;
    }

    public void setTotalRolls(long totalRolls) {
        this.totalRolls = totalRolls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RollDiceDTO that = (RollDiceDTO) o;
        return nbDice == that.nbDice && nbSides == that.nbSides && totalSimulations == that.totalSimulations && totalRolls == that.totalRolls;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbDice, nbSides, totalSimulations, totalRolls);
    }
}
