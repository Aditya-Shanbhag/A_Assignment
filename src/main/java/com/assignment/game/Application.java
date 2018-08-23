package com.assignment.game;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.gameplay.service.GamePlayService;
import com.assignment.game.player.exception.PlayerHealthExhaustedException;
import com.assignment.game.player.service.PlayerService;
import com.assignment.game.score.service.ScoreService;
import com.assignment.game.service.ServiceFactory;
import com.assignment.game.state.service.StateService;
import com.assignment.game.util.Util;

/**
 * 
 * @author Aditya
 *
 *         {@link Application} class which drives the game.
 * 
 */
public class Application {
	private static final String COMMAND_START = "start";
	private static final String COMMAND_SAVE = "save";
	private static final String COMMAND_EXIT = "exit";

	private CliService cliService;
	private StateService stateService;
	private PlayerService playerService;
	private ScoreService scoreService;
	private GamePlayService gamePlayService;

	public Application() {

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

	public StateService getStateService() {
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public GamePlayService getGamePlayService() {
		return gamePlayService;
	}

	public void setGamePlayService(GamePlayService gamePlayService) {
		this.gamePlayService = gamePlayService;
	}

	public void setCliService(CliService cliService) {
		this.cliService = cliService;
	}

	public void start(){
		// Initialize All Services
		cliService = (CliService) ServiceFactory.getService(ServiceFactory.CLI_SERVICE);
		stateService = (StateService) ServiceFactory.getService(ServiceFactory.STATE_SERVICE);
		playerService = (PlayerService) ServiceFactory.getService(ServiceFactory.PLAYER_SERVICE);
		scoreService = (ScoreService) ServiceFactory.getService(ServiceFactory.SCORE_SERVICE);
		gamePlayService = (GamePlayService) ServiceFactory.getService(ServiceFactory.GAMEPLAY_SERVICE);

		// Initialize Game State
		stateService.initialieState();

		String userInput = null;
		while(!COMMAND_EXIT.equalsIgnoreCase(userInput) ){
			this.printGamePlayCommandsHelp();
			userInput = cliService.getInputFromConsole();
			this.parseAndProcessUserInput(userInput);
		}

		cliService.printToConsole("\nThanks for playing, hope to see you soon.");
	}

	//TODO -- Add and enhance to allow user to modify avatar.
	public void parseAndProcessUserInput(String userInput){
		if(Util.isNullOrEmpty(userInput)){
			cliService.printToConsole("Invalid Input.");
		}else{
			switch (userInput.toLowerCase()) {
			case COMMAND_START:
				try {
					gamePlayService.startGamePlay();
				} catch (PlayerHealthExhaustedException e) {
					this.handlePlayerHealthExhaustion();
				}
				break;
			case COMMAND_SAVE:
				stateService.saveState();
				break;
			case COMMAND_EXIT:
				//TODO -- Add in confirmation popup.
				break;

			default:
				cliService.printToConsole("Invalid Input.");
				break;
			}
		}
	}

	private void handlePlayerHealthExhaustion() {
		cliService.printToConsole("\nSorry you were killed in last round, lets start again..");
		stateService.resetScore();
		stateService.resetPlayerHealth();
	}

	public void printGamePlayCommandsHelp(){
		System.out.println("\nFollowing are possible commands.");
		cliService.printToConsole("\tStart - To start gameplay.");
		cliService.printToConsole("\tSave - To Save current progress.");
		cliService.printToConsole("\tExit - Exit Game.");
		cliService.printToConsole("");
	}

	public void stop(){
		stateService.saveState();
		System.exit(0);
	}
}
