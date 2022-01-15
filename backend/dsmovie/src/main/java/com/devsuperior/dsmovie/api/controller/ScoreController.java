package com.devsuperior.dsmovie.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.api.dto.MovieDTO;
import com.devsuperior.dsmovie.api.dto.ScoreDTO;
import com.devsuperior.dsmovie.api.mapper.MovieMapper;
import com.devsuperior.dsmovie.api.mapper.ScoreMapper;
import com.devsuperior.dsmovie.domain.repositories.MovieRepository;
import com.devsuperior.dsmovie.domain.service.CatalogoMovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/scores")
public class ScoreController {
	
	private ScoreMapper scoreMapper;
	private MovieRepository movieRepository;
	private CatalogoMovieService catalogoMovieService;
	
	
	@PutMapping
	public ResponseEntity<MovieDTO> saveScore(ScoreDTO scoreDto) {
		return null;
	}
	
}
