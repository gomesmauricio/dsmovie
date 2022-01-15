package com.devsuperior.dsmovie.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.domain.model.Score;
import com.devsuperior.dsmovie.domain.model.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
