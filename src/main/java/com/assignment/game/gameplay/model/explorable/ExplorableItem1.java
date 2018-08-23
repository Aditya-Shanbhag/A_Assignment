package com.assignment.game.gameplay.model.explorable;

public class ExplorableItem1 implements Explorable{
	private static final int EXPLORE_POINTS = 10;

	// Enhance and implement some logic based on gameplay and return score.
	@Override
	public int explore() {
		return EXPLORE_POINTS;
	}

}
