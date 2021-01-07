package com.example.assignment.repository.impl;

import com.example.assignment.domain.dto.RollDiceDTO;
import com.example.assignment.domain.dto.RollDiceDistributionDTO;
import com.example.assignment.repository.RollDiceCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RollDiceCustomRepositoryImpl implements RollDiceCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RollDiceDTO> getSimulationsAndRollsByAllCombinations() {
        String hql = "select new com.example.assignment.domain.dto.RollDiceDTO(rd.nbDice, rd.nbSides, count(rd.id), sum(rd.nbRolls)) " +
        "from RollDice rd group by rd.nbDice, rd.nbSides" ;
        Query query = entityManager.createQuery(hql, RollDiceDTO.class);
        return query.getResultList();
    }

    @Override
    public List<RollDiceDistributionDTO> getRollDiceDistribution(int nbDice, int nbSides) {
        String hql = "select new com.example.assignment.domain.dto.RollDiceDistributionDTO(rdd.rollsSum, sum(rdd.rollsSumCount)) " +
                "from RollDice rd left join rd.rollDiceDetails rdd where rd.nbDice = :nbDice and rd.nbSides = :nbSides " +
                "group by rdd.rollsSum order by rdd.rollsSum";
        Query query = entityManager.createQuery(hql, RollDiceDistributionDTO.class);
        query.setParameter("nbDice", nbDice);
        query.setParameter("nbSides", nbSides);
        return query.getResultList();
    }
}
