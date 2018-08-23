package com.assignment.game.player.exception;

public class PlayerHealthExhaustedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerHealthExhaustedException() {
		super();
	}

	public PlayerHealthExhaustedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PlayerHealthExhaustedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlayerHealthExhaustedException(String message) {
		super(message);
	}

	public PlayerHealthExhaustedException(Throwable cause) {
		super(cause);
	}

}
