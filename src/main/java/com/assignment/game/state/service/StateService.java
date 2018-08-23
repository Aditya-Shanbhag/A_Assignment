package com.assignment.game.state.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.gameplay.service.GamePlayService;
import com.assignment.game.player.service.PlayerService;
import com.assignment.game.score.service.ScoreService;
import com.assignment.game.service.Service;
import com.assignment.game.service.ServiceFactory;
import com.assignment.game.state.model.State;
import com.assignment.game.util.GameConstants;

/**
 * 
 * @author Aditya
 * 
 *         Service class to operate on {@link State} and perform operations for
 *         save resume.
 */

// TODO
// - Save currently writes to one file.
// - Enhance to save based on timestamp to enable multiple saves.
public class StateService implements Service {
	private final String serviceName = ServiceFactory.STATE_SERVICE;
	private State state;

	private final CliService cliService;
	private final PlayerService playerService;
	private final GamePlayService gamePlayService;
	private final ScoreService scoreService;

	public StateService() {
		cliService = (CliService) ServiceFactory.getService(ServiceFactory.CLI_SERVICE);
		playerService = (PlayerService) ServiceFactory.getService(ServiceFactory.PLAYER_SERVICE);
		gamePlayService = (GamePlayService) ServiceFactory.getService(ServiceFactory.GAMEPLAY_SERVICE);
		scoreService = (ScoreService) ServiceFactory.getService(ServiceFactory.SCORE_SERVICE);
	}

	public State getState() {
		return state;
	}

	public String getServiceName() {
		return serviceName;
	}

	public GamePlayService getGamePlayService() {
		return gamePlayService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	public void initialieState(){
		if(this.isSavedGameAvailable()){
			state = this.resumeState();
		}else{
			state = this.initializeNewState();
			this.saveState();
		}
	}

	public void saveState() {
		String filename = GameConstants.savedGameDir + "Save1";
		try (FileOutputStream file = new FileOutputStream(filename); ObjectOutputStream out = new ObjectOutputStream(file);) {
			out.writeObject(state);
			cliService.printToConsole("Game saved successfully");
		}catch (IOException ex) {
			cliService.printToConsole("Error while saving game " + ex.getMessage());
		}
	}

	public State resumeState() {
		State state = null;
		String filename = GameConstants.savedGameDir + "Save1";
		File gameFile = new File(filename);
		if (gameFile.exists()) {
			try (FileInputStream file = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(file);) {
				state = (State) in.readObject();
			} catch (IOException | ClassNotFoundException ex) {
				cliService.printToConsole("Error while resuming game " + ex.getMessage());
			}
		}
		
		playerService.setPlayer(state.getPlayer());
		gamePlayService.setGameMap(state.getGameMap());
		scoreService.setScore(state.getScore());
		return state;
	}

	public boolean isSavedGameAvailable() {
		String filename = GameConstants.savedGameDir + "Save1";
		return new File(filename).exists();
	}

	/**
	 * Initializes and returns a game state.
	 * 
	 * @return
	 */
	public State initializeNewState() {
		State state = new State();
		state.setPlayer(playerService.initializeNewPlayer());
		state.setGameMap(gamePlayService.initializeNewMap());
		state.setScore(scoreService.initializeScore());
		return state;
	}
	
	public void resetScore(){
		state.setScore(scoreService.initializeScore());
	}
	
	public void resetPlayerHealth(){
		state.setPlayer(playerService.resetPlayerHealth());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateService other = (StateService) obj;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
}
