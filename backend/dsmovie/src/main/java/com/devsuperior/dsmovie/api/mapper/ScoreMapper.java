package com.devsuperior.dsmovie.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.devsuperior.dsmovie.api.dto.ScoreDTO;
import com.devsuperior.dsmovie.domain.model.Score;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ScoreMapper {
	
	private ModelMapper modelMapper;
	
	public ScoreDTO toScoreModel(Score score) {
		return modelMapper.map(score, ScoreDTO.class);		
	}
	
	
	public Score toScoreDTO(ScoreDTO scoreDTO) {
		return modelMapper.map(scoreDTO, Score.class );		
	}
	
	public List<ScoreDTO> toCollectionModel(List<Score> scoreList){
		return scoreList.stream()
						.map(this::toScoreModel)
						.collect(Collectors.toList());
	}

}
