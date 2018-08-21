package com.assignment.game.state.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.player.service.PlayerService;
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
public class StateService {
	private CliService cliService;
	private PlayerService playerService;

	public StateService() {
		cliService = CliService.getInstance();
		playerService = new PlayerService();
	}

	public void saveState(State state) {
		String filename = GameConstants.savedGameDir + "Save1";
		try (FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file);) {
			// Method for serialization of object
			out.writeObject(state);

			cliService.printToConsole("Game saved successfully");
		}

		catch (IOException ex) {
			cliService.printToConsole("Error while saving game " + ex.getMessage());
		}
	}

	public State resumeState() {
		State state = null;
		String filename = GameConstants.savedGameDir + "Save1";
		File gameFile = new File(filename);
		if(gameFile.exists()){
			try (FileInputStream file = new FileInputStream(filename); ObjectInputStream in = new ObjectInputStream(file);) {
				state = (State) in.readObject();
			}catch (IOException | ClassNotFoundException ex) {
				cliService.printToConsole("Error while resuming game " + ex.getMessage());
			}
		}
		return state;
	}

	//	public boolean isSavedGameAvailable() {
	//		String filename = GameConstants.savedGameDir + "Save1";
	//		return new File(filename).exists();
	//	}

	/**
	 * Initializes and returns a game state.
	 * 
	 * @return
	 */
	public State initializeNewState() {
		State state = new State();
		state.setPlayer(playerService.initializeNewPlayer());
		this.saveState(state);
		return state;
	}
}
