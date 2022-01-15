package com.devsuperior.dsmovie.domain.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.api.dto.AvaliacaoResponse;
import com.devsuperior.dsmovie.api.dto.MovieResponse;
import com.devsuperior.dsmovie.api.mapper.MovieMapper;
import com.devsuperior.dsmovie.domain.model.Movie;
import com.devsuperior.dsmovie.domain.model.Score;
import com.devsuperior.dsmovie.domain.model.User;
import com.devsuperior.dsmovie.domain.repositories.MovieRepository;
import com.devsuperior.dsmovie.domain.repositories.ScoreRepository;
import com.devsuperior.dsmovie.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EnviarAvaliacaoService {
	
	private MovieMapper movieMapper;
	
	private MovieRepository movieRepository;
	
	private UserRepository userRepository;
	
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieResponse saveScore(AvaliacaoResponse avaliacaoResponse) {
		
		User user = userRepository.findByEmail(avaliacaoResponse.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(avaliacaoResponse.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(avaliacaoResponse.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(avaliacaoResponse.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		} 
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return movieMapper.toModel(movie);
	}
	

}
