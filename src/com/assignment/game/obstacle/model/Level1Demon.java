package com.assignment.game.obstacle.model;

import java.util.Random;

import com.assignment.game.player.model.Player;

public class Level1Demon implements Obstacle, FightCapableObstacle{
	private static final int LEVEL_1_WARRIOR_HEALTH = 10;
	
	@Override
	public boolean fight(Player player) {
		System.out.println("Battle with Level 1 Demon...");
		try {
			Thread.sleep(3l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Random random = new Random();
		return player.getHealth() - random.nextInt(LEVEL_1_WARRIOR_HEALTH) > 0;
	}
}
