package com.devsuperior.dsmovie.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.dsmovie.api.dto.MovieDTO;
import com.devsuperior.dsmovie.domain.model.Movie;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MovieMapper {
	
	private ModelMapper modelMapper;
	
	
	public MovieDTO toModel(Movie movie) {
		return modelMapper.map(movie, MovieDTO.class);		
	}
	
	public Movie toMovieDTO(MovieDTO movieDTO ) {
		return modelMapper.map(movieDTO, Movie.class);
	}
	
	public List<MovieDTO> toCollectionModel(List<Movie> movieList){
		return movieList.stream()
						.map(this::toModel)
						.collect(Collectors.toList());
	}
	
	
}
