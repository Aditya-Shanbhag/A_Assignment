package com.assignment.game.player.model;

import java.io.Serializable;

import com.assignment.game.score.model.Score;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;

	private Character character;
	private Score score;
	private int health;

	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
