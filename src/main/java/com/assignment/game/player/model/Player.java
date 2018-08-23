package com.assignment.game.player.model;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int MAX_HEALTH = 100;

	private Avatar Avatar;
	private int health;

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
