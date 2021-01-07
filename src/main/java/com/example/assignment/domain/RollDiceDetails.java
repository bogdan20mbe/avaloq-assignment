package com.example.assignment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "roll_dice_details")
public class RollDiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RollDiceDetailsSeqGenerator")
    @SequenceGenerator(name = "RollDiceDetailsSeqGenerator", sequenceName = "roll_dice_details_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roll_dice_id")
    @JsonIgnore
    RollDice rollDice;

    @Column(name = "rolls_sum")
    private int rollsSum;

    @Column(name = "rolls_sum_count")
    private int rollsSumCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RollDice getRollDice() {
        return rollDice;
    }

    public void setRollDice(RollDice rollDice) {
        this.rollDice = rollDice;
    }

    public int getRollsSum() {
        return rollsSum;
    }

    public void setRollsSum(int rollsSum) {
        this.rollsSum = rollsSum;
    }

    public int getRollsSumCount() {
        return rollsSumCount;
    }

    public void setRollsSumCount(int rollsSumCount) {
        this.rollsSumCount = rollsSumCount;
    }
}
