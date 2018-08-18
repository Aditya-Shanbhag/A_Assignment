package com.assignment.game.player.model;

import java.io.Serializable;

import com.assignment.game.player.score.model.Score;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Character character;
	private Score score;
	
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
}