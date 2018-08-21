package com.assignment.game.gameplay.model.obstacle;

import java.util.Random;

import com.assignment.game.player.model.Player;

public class Level1Fighter implements Obstacle, FightCapableObstacle{
	private static final int LEVEL_1_WARRIOR_HEALTH = 10;
	
	@Override
	public boolean fight(Player player) {
		try {
			Thread.sleep(3l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random random = new Random();
		return player.getHealth() - random.nextInt(LEVEL_1_WARRIOR_HEALTH) > 0;
	}
}
