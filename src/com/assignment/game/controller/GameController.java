package com.assignment.game.controller;

import com.assignment.game.service.GameService;

/**
 * 
 * @author Aditya
 *
 * {@link GameController} class which drives the game.
 * 
 */

public class GameController {
	GameService gameService;

	public GameController() {
		gameService = new GameService();
	}

	public void startGame(){
		gameService.start();
	}
}
