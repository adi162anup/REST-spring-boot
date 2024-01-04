package com.adi.moviedemo.rest;

import com.adi.moviedemo.dao.MovieDAO;
import com.adi.moviedemo.entity.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieRestController {

    private MovieDAO movieDAO;

    public MovieRestController(MovieDAO theMovieDAO){
        movieDAO = theMovieDAO;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieDAO.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) throws Exception {

        if((movieId<1) || (movieId > movieDAO.getMovies().size())){
            throw new MovieNotFoundException("Movie ID not found - " + movieId);
        }

        return movieDAO.getMovies().get(movieId-1);
    }




}
