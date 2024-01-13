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
    public List<Movie> getMovies() {

        TypedQuery<Movie> theQuery = entityManager.createQuery("from Movie", Movie.class);

        List<Movie> result = theQuery.getResultList();

        return result;
    }

    @Override
    public Movie getMovieById(int theId) {

        Movie theMovie = entityManager.find(Movie.class,theId);

        return theMovie;
    }

    @Override
    public Movie save(Movie theMovie) {

        Movie dbMovie = entityManager.merge(theMovie);

        return dbMovie;
    }

    @Override
    public void delete(int theId) {

        Movie theMovie = entityManager.find(Movie.class,theId);

        entityManager.remove(theMovie);
    }
}
