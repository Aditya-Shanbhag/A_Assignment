package com.assignment.game.gameplay.model.explorable;

public class ExplorableItem1 implements Explorable{
	private static final int EXPLORE_POINTS = 10;

	@Override
	public int explore() {
		return EXPLORE_POINTS;
	}
	
}
