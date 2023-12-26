package com.adi.moviedemo.entity;

public class Movie {
    private String movieName;
    private String heroName;
    private int yearOfRelease;

    public Movie() {}

    public Movie(String movieName, String heroName, int yearOfRelease) {
        this.movieName = movieName;
        this.heroName = heroName;
        this.yearOfRelease = yearOfRelease;
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
}
