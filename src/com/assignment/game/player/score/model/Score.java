package com.assignment.game.player.score.model;

import java.io.Serializable;

/**
 * 
 * @author Aditya
 * 
 * Score class to maintain user progress through game.
 * 
 */
public class Score implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int experience;
	private int level;

	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
