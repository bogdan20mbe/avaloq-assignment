package com.example.assignment.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roll_dice")
public class RollDice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RollDiceSeqGenerator")
    @SequenceGenerator(name = "RollDiceSeqGenerator", sequenceName = "roll_dice_id_seq", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "rollDice")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Set<RollDiceDetails> rollDiceDetails = new HashSet<>();

    @Column(name = "nb_dice")
    private int nbDice;

    @Column(name = "nb_rolls")
    private int nbRolls;

    @Column(name = "nb_sides")
    private int nbSides;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbDice() {
        return nbDice;
    }

    public void setNbDice(int nbDice) {
        this.nbDice = nbDice;
    }

    public int getNbRolls() {
        return nbRolls;
    }

    public void setNbRolls(int nbRolls) {
        this.nbRolls = nbRolls;
    }

    public int getNbSides() {
        return nbSides;
    }

    public void setNbSides(int nbSides) {
        this.nbSides = nbSides;
    }

    public RollDice addRollDiceDetails(RollDiceDetails rollDiceDetails) {
        this.rollDiceDetails.add(rollDiceDetails);
        rollDiceDetails.setRollDice(this);
        return this;
    }

    public RollDice removeRollDiceDetails(RollDiceDetails rollDiceDetails) {
        this.rollDiceDetails.remove(rollDiceDetails);
        rollDiceDetails.setRollDice(null);
        return this;
    }
}
