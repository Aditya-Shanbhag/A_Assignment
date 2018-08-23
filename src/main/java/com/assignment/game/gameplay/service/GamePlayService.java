package com.assignment.game.gameplay.service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.gameplay.model.GameMap;
import com.assignment.game.gameplay.model.explorable.Explorable;
import com.assignment.game.gameplay.model.explorable.ExplorableItem1;
import com.assignment.game.gameplay.model.explorable.ExplorableItem2;
import com.assignment.game.gameplay.model.obstacle.FightCapableObstacle;
import com.assignment.game.gameplay.model.obstacle.Level1Fighter;
import com.assignment.game.gameplay.model.obstacle.Level2Fighter;
import com.assignment.game.player.exception.PlayerHealthExhaustedException;
import com.assignment.game.player.model.Player;
import com.assignment.game.player.service.PlayerService;
import com.assignment.game.score.service.ScoreService;
import com.assignment.game.service.Service;
import com.assignment.game.service.ServiceFactory;
import com.assignment.game.util.Util;

public class GamePlayService implements Service {
	private final String serviceName = ServiceFactory.GAMEPLAY_SERVICE;
	private GameMap gameMap;

	private final CliService cliService;
	private final ScoreService scoreService;
	private final PlayerService playerService;

	public GamePlayService() {
		cliService = (CliService) ServiceFactory.getService(ServiceFactory.CLI_SERVICE);
		scoreService = (ScoreService) ServiceFactory.getService(ServiceFactory.SCORE_SERVICE);
		playerService = (PlayerService) ServiceFactory.getService(ServiceFactory.PLAYER_SERVICE);
	}

	public String getServiceName() {
		return serviceName;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public GameMap initializeNewMap() {
		gameMap = new GameMap();
		return gameMap;
	}

	public void startGamePlay() throws PlayerHealthExhaustedException {
		cliService.printToConsole("Let the game begin.. :) \n");
		String userInput  = null;
		while(!"exit".equalsIgnoreCase(userInput)){
			cliService.printToConsole("Game Mini Map");
			gameMap.drawGameMap();

			this.printGamePlayCommandsHelp();

			userInput = cliService.getInputFromConsole();
			this.parseAndProcessUserInput(userInput);
		}
	}

	public void parseAndProcessUserInput(String userInput) throws PlayerHealthExhaustedException{
		if("Q".equalsIgnoreCase(userInput)){
			return;
		}
		Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
		Matcher matcher = pattern.matcher(userInput.trim());

		if(!Util.isNullOrEmpty(userInput) && matcher.matches()){
			int x = Integer.parseInt(matcher.group(1));
			int y = Integer.parseInt(matcher.group(2));
			this.movePlayerToLocation(x-1, y-1);
		}else{
			cliService.printToConsole("\nInvalid Input");
		}
	}

	private void movePlayerToLocation(int x, int y) throws PlayerHealthExhaustedException {
		if(x >= 0 && x < gameMap.getHeight() && y >= 0 && y < gameMap.getWidth()){
			processVisitedCoordinate(x,y);
			gameMap.setVisited(x, y);
		}else{
			cliService.printToConsole("Invalid Input");
		}
	}
	// Enhance give user option whether to fight or backout.
	private void processVisitedCoordinate(int x, int y) throws PlayerHealthExhaustedException{
		if(gameMap.getLocation(x, y)){
			cliService.printToConsole("Co-Ordinate is already explored.\n");
		}else{
			if(x%2 == 0 && y%2 ==0){ // Process Handle Fight
				FightCapableObstacle obstacle  = this.getRandomFightCapable();
				simulateFight(obstacle, playerService.getPlayer());
			}else{// Handle Explored Item
				Explorable explorable = this.getRandomExplorable();
				scoreService.addScore(explorable.explore());
				playerService.addPlayerHealth(10);
			}
		}
	}

	private void simulateFight(FightCapableObstacle obstacle,  Player player) throws PlayerHealthExhaustedException{
		cliService.printToConsole("Simulating fight...");
		try {
			Thread.sleep(3l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		playerService.addPlayerHealth(- new Random().nextInt(obstacle.fight()));
		scoreService.addScore(20);
		cliService.printToConsole("Yay You won. However you lost significant health.");
	}

	private Explorable getRandomExplorable(){
		return new Random().nextInt(1) == 0 ? new ExplorableItem1() : new ExplorableItem2();
	}

	private FightCapableObstacle getRandomFightCapable(){
		return new Random().nextInt(1) == 0 ? new Level1Fighter() : new Level2Fighter();
	}

	public void displayGameMap() {
		gameMap.drawGameMap();
	}

	public void printGamePlayCommandsHelp(){
		cliService.printToConsole("\nFollowing are possible commands.");
		cliService.printToConsole("\tEnter co-ordinates in following format :: 1,7.");
		cliService.printToConsole("\tExit - To return back to main menu.");
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
		GamePlayService other = (GamePlayService) obj;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
}
