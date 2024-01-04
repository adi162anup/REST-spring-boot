package com.adi.moviedemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="hero_name")
    private String heroName;

    @Column(name="year")
    private int yearOfRelease;

    public Movie() {}

    public Movie(String movieName, String heroName, int yearOfRelease) {
        this.movieName = movieName;
        this.heroName = heroName;
        this.yearOfRelease = yearOfRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", heroName='" + heroName + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
