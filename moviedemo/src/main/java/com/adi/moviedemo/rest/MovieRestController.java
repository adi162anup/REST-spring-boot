package com.adi.moviedemo.rest;

import com.adi.moviedemo.entity.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieRestController {

    private List<Movie> theMovies;

    @PostConstruct
    public void LoadData() {
        theMovies = new ArrayList<>();
        theMovies.add(new Movie("The Shawshank Redemption","Tim Robbins",1994));
        theMovies.add(new Movie("The Godfather","Marlon Brando",1972));
        theMovies.add(new Movie("The Dark Knight","Christian Bale",2008));
        theMovies.add(new Movie("Schindler's List","Liam Neeson",1993));
        theMovies.add(new Movie("Pulp Fiction","John Travolta",1994));
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return theMovies;
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable int movieId) throws Exception {

        if((movieId<0) || (movieId > theMovies.size())){
            throw new MovieNotFoundException("Movie ID not found - " + movieId);
        }


        return theMovies.get(movieId);
    }

    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(MovieNotFoundException exc){

        MovieErrorResponse err = new MovieErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MovieErrorResponse> handleException(Exception exc){

        MovieErrorResponse err = new MovieErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(exc.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }
}
