package com.devsuperior.dsmovie.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.api.dto.MovieDTO;
import com.devsuperior.dsmovie.api.mapper.MovieMapper;
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
	public Page<MovieDTO> findPaged(Pageable pageable){
		return catalogoMovieService.findPaged(pageable);
	}
	
	@GetMapping("/all")
	public List<MovieDTO> finAll(){
		return movieMapper.toCollectionModel(movieRepository.findAll());
		
	}
	
}
