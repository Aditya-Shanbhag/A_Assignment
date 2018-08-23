package com.assignment.game.gameplay.model.obstacle;

public class Level2Fighter implements Obstacle, FightCapableObstacle{
	private static final int LEVEL_2_WARRIOR_HEALTH = 20;

	@Override
	public int fight() {
		return LEVEL_2_WARRIOR_HEALTH;
	}
}
