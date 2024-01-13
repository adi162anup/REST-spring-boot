package com.adi.moviedemo.service;

import com.adi.moviedemo.dao.MovieDAO;
import com.adi.moviedemo.entity.Movie;
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
}
