package com.devsuperior.dsmovie.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.dsmovie.api.dto.AvaliacaoResponse;
import com.devsuperior.dsmovie.domain.model.Score;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ScoreMapper {
	
	private ModelMapper modelMapper;
	
	public AvaliacaoResponse toScoreModel(Score score) {
		return modelMapper.map(score, AvaliacaoResponse.class);		
	}
	
	
	public Score toScoreDTO(AvaliacaoResponse scoreDTO) {
		return modelMapper.map(scoreDTO, Score.class );		
	}
	
	public List<AvaliacaoResponse> toCollectionModel(List<Score> scoreList){
		return scoreList.stream()
						.map(this::toScoreModel)
						.collect(Collectors.toList());
	}

}
