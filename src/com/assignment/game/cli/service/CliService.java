package com.assignment.game.cli.service;

import java.util.Scanner;

/**
 * 
 * @author Aditya
 *
 * Service Class to handle game cli operations.
 * 
 */
public class CliService {
	private Scanner sc;
	
	public CliService(){
		sc = new Scanner(System.in);
	}
	
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public void printToConsole(String text){
		System.out.print(text);
	}
	
	public String getInputFromConsole(String text){
		return sc.nextLine();
	}
}
