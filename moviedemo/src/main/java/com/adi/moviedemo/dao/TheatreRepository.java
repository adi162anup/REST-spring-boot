package com.adi.moviedemo.dao;

import com.adi.moviedemo.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "theatres")
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
}
