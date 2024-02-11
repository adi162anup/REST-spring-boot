package com.adi.moviedemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private int theatreId;

    @Column(name = "top_movie_name")
    private String topMovieName;

    @Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "location")
    private String location;

    public Theatre() {}

    public Theatre(String topMovieName, String theatreName, String location) {
        this.topMovieName = topMovieName;
        this.theatreName = theatreName;
        this.location = location;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTopMovieName() {
        return topMovieName;
    }

    public void setTopMovieName(String topMovieName) {
        this.topMovieName = topMovieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", topMovieName='" + topMovieName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
