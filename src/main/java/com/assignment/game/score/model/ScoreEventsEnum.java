package com.assignment.game.score.model;

public enum ScoreEventsEnum {
	discoverValuable (20),
	winFight (50);
	
	private int points;
	
	ScoreEventsEnum(int points){
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
}
