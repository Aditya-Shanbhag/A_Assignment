package com.assignment.game.gameplay.model.obstacle;

public class Level1Fighter implements Obstacle, FightCapableObstacle{
	private static final int LEVEL_1_WARRIOR_HEALTH = 10;

	// Enhance and implement some logic based on gameplay and return score.
	@Override
	public int fight() {
		return LEVEL_1_WARRIOR_HEALTH;
	}
}
