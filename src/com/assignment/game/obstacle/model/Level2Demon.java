package com.assignment.game.obstacle.model;

import java.util.Random;

import com.assignment.game.player.model.Player;

public class Level2Demon implements Obstacle, FightCapableObstacle{
	private static final int LEVEL_2_WARRIOR_HEALTH = 20;
	
	@Override
	public boolean fight(Player player) {
		System.out.println("Battle with Level 2 Demon...");
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
