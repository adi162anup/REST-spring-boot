package com.adi.moviedemo.dao;

import com.adi.moviedemo.entity.Movie;

import java.util.List;

public interface MovieDAO {

    List<Movie> getMovies();

    Movie getMovieById(int theId);

    Movie save(Movie theMovie);

    void delete(int theId);
}
