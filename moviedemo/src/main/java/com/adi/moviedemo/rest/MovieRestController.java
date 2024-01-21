package com.adi.moviedemo.rest;

import com.adi.moviedemo.dao.MovieDAO;
import com.adi.moviedemo.entity.Movie;
import com.adi.moviedemo.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService theMovieService){
        movieService = theMovieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) throws Exception {

        if((movieId<1) || (movieId > movieService.getMovies().size())){
            throw new MovieNotFoundException("Movie ID not found - " + movieId);
        }

        return movieService.getMovieById(movieId);
    }




}
