package com.devsuperior.dsmovie.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.domain.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
