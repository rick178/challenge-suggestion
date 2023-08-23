package com.challenge.suggestioncities.dao;

import com.challenge.suggestioncities.models.Cities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SuggestionsDaoImp implements SuggestionDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cities> getCities(String q, Long latitude, Long longitude) {
        String pattern = q.trim() + "%";
        String query = "From Cities WHERE name LIKE :pattern";
        System.out.println("Citie: " + q);
        List<Cities> listCities = entityManager.createQuery(query)
                .setParameter("pattern", pattern)
                .getResultList();
        return listCities;
    }
}
