package com.assignment.game;

import com.assignment.game.gameplay.model.GameMap;

public class Main {
	public static void main(String[] args) {
		//		new GameController().startGame();
		new GameMap(10, 10).drawGameMap();
	}
}
