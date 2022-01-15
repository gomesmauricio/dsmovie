package com.devsuperior.dsmovie.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.api.dto.MovieResponse;
import com.devsuperior.dsmovie.api.dto.AvaliacaoResponse;
import com.devsuperior.dsmovie.api.mapper.MovieMapper;
import com.devsuperior.dsmovie.api.mapper.ScoreMapper;
import com.devsuperior.dsmovie.domain.repositories.MovieRepository;
import com.devsuperior.dsmovie.domain.service.CatalogoMovieService;
import com.devsuperior.dsmovie.domain.service.EnviarAvaliacaoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	
	private EnviarAvaliacaoService avaliacaoService;
	
	
	@PutMapping
	public ResponseEntity<MovieResponse> saveScore(@RequestBody AvaliacaoResponse scoreDto) {
		MovieResponse movieResponse = avaliacaoService.saveScore(scoreDto);
		return ResponseEntity.ok(movieResponse);
	}
	
}
