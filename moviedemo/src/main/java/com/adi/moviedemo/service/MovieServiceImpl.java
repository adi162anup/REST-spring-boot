package com.adi.moviedemo.service;

import com.adi.moviedemo.entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieDAO movieDAO;

    @Autowired
    public MovieServiceImpl(MovieDAO theMovieDAO){
        movieDAO = theMovieDAO;
    }

    @Override
    public List<Movie> getMovies() {
        return movieDAO.getMovies();
    }

    @Override
    public Movie getMovieById(int theId) {
        return movieDAO.getMovieById(theId);
    }

    @Transactional
    @Override
    public Movie save(Movie theMovie) {
        return movieDAO.save(theMovie);
    }

    @Transactional
    @Override
    public void delete(int theId) {
        movieDAO.delete(theId);
    }
}
