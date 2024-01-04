package com.adi.moviedemo.dao;

import com.adi.moviedemo.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDAOJpaImpl implements MovieDAO{

    private EntityManager entityManager;

    @Autowired
    public MovieDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Movie> findAll() {

        TypedQuery<Movie> theQuery = entityManager.createQuery("from Movie", Movie.class);

        List<Movie> result = theQuery.getResultList();

        return result;
    }
}
