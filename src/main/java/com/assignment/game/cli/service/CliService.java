package com.assignment.game.cli.service;

import java.util.Scanner;

/**
 * 
 * @author Aditya
 *
 * Service Class to handle game cli operations.
 * 
 */
public final class CliService {
	// Eagerly initializing as this is guaranteed to be used.
	private static CliService instance = new CliService();
	private Scanner sc;

	private CliService(){
		sc = new Scanner(System.in);
	}

	public Scanner getSc() {
		return sc;
	}
	
	public void printToConsole(String text){
		System.out.println(text);
	}

	public String getInputFromConsole(){
		System.out.print("Input :: ");
		return sc.nextLine();
	}

	public static CliService getInstance(){
		return instance;
	}
}
