package com.adi.moviedemo.dao;

import com.adi.moviedemo.entity.Movie;

import java.util.List;

public interface MovieDAO {

    List<Movie> findAll();
}
