package com.adi.moviedemo.service;

import com.adi.moviedemo.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie findById(int theId);

    Movie save(Movie theMovie);

    void deleteById(int theId);
}
