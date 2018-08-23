package com.assignment.game.state.model;

import java.io.Serializable;

import com.assignment.game.gameplay.model.GameMap;
import com.assignment.game.player.model.Player;
import com.assignment.game.score.model.Score;

/**
 * 
 * @author Aditya
 *
 *         Class to maintain player character, progress.
 * 
 *         Save and Resume game.
 *
 */
public class State implements Serializable {
	private static final long serialVersionUID = 1L;
	private Player player;
	private Score score;
	private GameMap gameMap;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
}
