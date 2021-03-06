package com.devsuperior.dsmovie.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.api.dto.MovieResponse;
import com.devsuperior.dsmovie.api.mapper.MovieMapper;
import com.devsuperior.dsmovie.domain.model.Movie;
import com.devsuperior.dsmovie.domain.repositories.MovieRepository;
import com.devsuperior.dsmovie.domain.service.CatalogoMovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private MovieMapper movieMapper;
	private MovieRepository movieRepository;
	private CatalogoMovieService catalogoMovieService;
	
	@GetMapping
	public Page<MovieResponse> finAll(@PageableDefault(size = 10) Pageable pageable){
		Page<Movie> moviesPage = movieRepository.findAll(pageable);
		
		List<MovieResponse> moviesDTOs = movieMapper
				.toCollectionModel(moviesPage.getContent());
		
		Page<MovieResponse> moviesDTOPage = new PageImpl<>(moviesDTOs, pageable, moviesPage.getTotalElements());
		
		return moviesDTOPage;
		
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<MovieResponse> findById(@PathVariable Long movieId) {
		return movieRepository.findById(movieId)
				.map(movie -> ResponseEntity.ok(movieMapper.toModel(movie)))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
