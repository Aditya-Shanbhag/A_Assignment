package com.assignment.game.score.service;

import com.assignment.game.score.model.Score;
import com.assignment.game.service.Service;
import com.assignment.game.service.ServiceFactory;

/**
 * 
 * @author Aditya
 *
 * {@link ScoreService} class to handle user scores related operations.
 * 
 */
public class ScoreService implements Service {
	private final String serviceName =  ServiceFactory.SCORE_SERVICE;
	private Score score;

	public String getServiceName() {
		return serviceName;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public void addScore(int score){
		this.processScore(score);
	}

	private void processScore(int scoreToAdd){
		score.setExperience(score.getExperience() + scoreToAdd);
		if(score.getExperience() >= 100){
			score.setExperience(score.getExperience() - 100);
			score.setLevel(score.getLevel() + 1);
		}
	}

	public Score initializeScore() {
		score = new Score();
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScoreService other = (ScoreService) obj;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
}
