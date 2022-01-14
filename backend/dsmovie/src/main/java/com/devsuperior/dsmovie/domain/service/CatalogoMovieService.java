package com.devsuperior.dsmovie.domain.service;

import org.springframework.stereotype.Service;

import com.devsuperior.dsmovie.api.mapper.MovieMapper;
import com.devsuperior.dsmovie.domain.repositories.MovieRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoMovieService {
	
	private MovieRepository movieRepository;
	private MovieMapper movieMapper;
	
	
}
