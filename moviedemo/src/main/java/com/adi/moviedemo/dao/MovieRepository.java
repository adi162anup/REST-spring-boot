package com.adi.moviedemo.dao;

import com.adi.moviedemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestResource(path="classics")
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
