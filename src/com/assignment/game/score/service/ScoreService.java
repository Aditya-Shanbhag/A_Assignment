package com.assignment.game.score.service;

import com.assignment.game.score.model.Score;
import com.assignment.game.score.model.ScoreEventsEnum;

/**
 * 
 * @author Aditya
 *
 * {@link ScoreService} class to handle user scores related operations.
 * 
 */
public class ScoreService {
	public void processScore(Score score, ScoreEventsEnum event){
		score.setExperience(score.getExperience() + event.getPoints());
		if(score.getExperience() >= 100){
			score.setExperience(score.getExperience() - 100);
			score.setLevel(score.getLevel() + 1);
		}
	}
}
