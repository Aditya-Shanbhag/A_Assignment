package com.assignment.game.player.model;

import java.io.Serializable;

import com.assignment.game.score.model.Score;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	private Avatar Avatar;
	private Score score;
	private int health;

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

	public Avatar getAvatar() {
		return Avatar;
	}

	public void setAvatar(Avatar avatar) {
		Avatar = avatar;
	}
}
