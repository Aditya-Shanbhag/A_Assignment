package com.assignment.game.state.model;

import java.io.Serializable;

import com.assignment.game.player.model.Player;

/**
 * 
 * @author Aditya
 *
 * Class to maintain player character, progress.
 * 
 * Save and Resume game.
 *
 */
public class State implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Player player;
}