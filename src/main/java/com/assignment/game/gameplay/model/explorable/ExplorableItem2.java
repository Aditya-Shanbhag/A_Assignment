package com.assignment.game.gameplay.model.explorable;

public class ExplorableItem2 implements Explorable{
	private static final int EXPLORE_POINTS = 20;

	@Override
	public int explore() {
		return EXPLORE_POINTS;
	}
	
}
