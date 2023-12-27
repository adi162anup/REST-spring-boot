package com.adi.moviedemo.rest;

import com.adi.moviedemo.entity.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Movie getMovieById(@PathVariable int movieId){
        return theMovies.get(movieId);
    }
}
