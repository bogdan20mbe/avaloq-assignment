package com.example.assignment.domain;

import java.util.Objects;
import java.util.Random;

public class Dice {
    private int sides;
    private Random random = new Random();

    public Dice() {
    }

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return sides == dice.sides;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }
}
