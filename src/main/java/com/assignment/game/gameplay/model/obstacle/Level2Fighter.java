package com.assignment.game.gameplay.model.obstacle;

import java.util.Random;

import com.assignment.game.player.model.Player;

public class Level2Fighter implements Obstacle, FightCapableObstacle{
	private static final int LEVEL_2_WARRIOR_HEALTH = 20;
	
	@Override
	public boolean fight(Player player) {
		try {
			Thread.sleep(3l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Currently randomizing a number, to simulate a fight.
		Random random = new Random();
		return player.getHealth() - random.nextInt(LEVEL_2_WARRIOR_HEALTH) > 0;
	}
}
