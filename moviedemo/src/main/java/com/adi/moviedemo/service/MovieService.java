package com.adi.moviedemo.service;

import com.adi.moviedemo.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMovies();

    Movie getMovieById(int theId);

    Movie save(Movie theMovie);

    void delete(int theId);
}
