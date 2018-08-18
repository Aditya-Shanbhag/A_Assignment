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
	private StateService stateSetvice;
	private State gameState;

	public GameService() {
		this.cliService = new CliService();
		this.stateSetvice  = new StateService();
	}

	public CliService getCliService() {
		return cliService;
	}

	public void setCliService(CliService cliService) {
		this.cliService = cliService;
	}

	public StateService getStateSetvice() {
		return stateSetvice;
	}

	public void setStateSetvice(StateService stateSetvice) {
		this.stateSetvice = stateSetvice;
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public void start(){
		// TODO - Implement Logic to start game.
	}

	public void stop(){
		// TODO - Implement Logic to save game state and stop.
		if(gameState != null){
			stateSetvice.saveState(gameState);
		}
	}
}
