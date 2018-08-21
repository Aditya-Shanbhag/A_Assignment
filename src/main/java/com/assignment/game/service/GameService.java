package com.assignment.game.service;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.state.model.State;
import com.assignment.game.state.service.StateService;

/**
 * 
 * @author Aditya
 *
 * {@link GameService} class which drives the game.
 * 
 */
public class GameService {
	private CliService cliService;
	private StateService stateService;
	private State gameState;

	public GameService() {
		cliService = CliService.getInstance();
		this.stateService  = new StateService();
	}

	public CliService getCliService() {
		return cliService;
	}

	public StateService getStateSetvice() {
		return stateService;
	}

	public void setStateSetvice(StateService stateSetvice) {
		this.stateService = stateSetvice;
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public void start(){
		gameState = stateService.resumeState();
		if(gameState == null){
			gameState = stateService.initializeNewState();
		}
		
		
	}

	public void stop(){
		if(gameState != null){
			stateService.saveState(gameState);
		}
	}
}
