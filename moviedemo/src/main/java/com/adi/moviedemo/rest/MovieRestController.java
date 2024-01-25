package com.adi.moviedemo.rest;

import com.adi.moviedemo.entity.Movie;
import com.adi.moviedemo.service.MovieService;
import org.springframework.web.bind.annotation.*;

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
        return movieService.findAll();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) throws Exception {

        Movie theMovie = movieService.findById(movieId);

        if(theMovie == null){
            throw new MovieNotFoundException("Movie ID not found - " + movieId);
        }

        return theMovie;
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie theMovie){

        theMovie.setId(0);

        Movie dbMovie = movieService.save(theMovie);

        return dbMovie;
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie theMovie) {

        Movie dbMovie = movieService.save(theMovie);

        return dbMovie;
    }

    @DeleteMapping("/movies/{movieId}")
    public String deleteMovie(@PathVariable int movieId) throws Exception {

        Movie theMovie = movieService.findById(movieId);

        if(theMovie == null){
            throw new MovieNotFoundException("Movie ID not found - " + movieId);
        }

        movieService.deleteById(movieId);

        return "Movie ID " + movieId + " deleted";

    }




}
