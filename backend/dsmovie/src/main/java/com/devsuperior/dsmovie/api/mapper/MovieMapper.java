package com.devsuperior.dsmovie.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.dsmovie.api.dto.AvaliacaoResponse;
import com.devsuperior.dsmovie.api.dto.MovieResponse;
import com.devsuperior.dsmovie.domain.model.Movie;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MovieMapper {
	
	private ModelMapper modelMapper;
	
	
	public MovieResponse toModel(Movie movie) {
		return modelMapper.map(movie, MovieResponse.class);		
	}
	
	
	public List<MovieResponse> toCollectionModel(List<Movie> movieList){
		return movieList.stream()
						.map(this::toModel)
						.collect(Collectors.toList());
	}
	
	
}
