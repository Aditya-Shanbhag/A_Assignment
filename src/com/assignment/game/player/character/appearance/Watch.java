package com.assignment.game.player.character.appearance;

import java.io.Serializable;

public class Watch extends Accessory implements Serializable{
	private static final long serialVersionUID = 1L;

	@Override
	public void displayCharacterItem() {
		System.out.println("Watch");
	}

}
