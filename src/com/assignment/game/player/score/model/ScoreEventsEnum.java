package com.assignment.game.player.score.model;

public enum ScoreEventsEnum {
	exploreItem (20),
	winFight (50);
	
	private int points;
	
	ScoreEventsEnum(int points){
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
}
