package com.devsuperior.dsmovie.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoResponse {
	
	private Long movieId;
	private String email;
	private Double score;

}
