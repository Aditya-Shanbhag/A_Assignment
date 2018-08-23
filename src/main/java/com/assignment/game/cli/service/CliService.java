package com.assignment.game.cli.service;

import java.util.Scanner;

import com.assignment.game.service.Service;
import com.assignment.game.service.ServiceFactory;

/**
 * 
 * @author Aditya
 *
 *         Service Class to handle game cli operations.
 * 
 */
public class CliService implements Service {
	private final String serviceName = ServiceFactory.CLI_SERVICE;

	// Eagerly initializing as this is guaranteed to be used.
	private final Scanner sc;

	public CliService() {
		sc = new Scanner(System.in);
	}

	public String getServiceName() {
		return serviceName;
	}

	public Scanner getSc() {
		return sc;
	}

	public void printToConsole(String text) {
		System.out.println(text);
	}
	
	public String getInputFromConsole() {
		System.out.print("Input :: ");
		return sc.nextLine();
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
		CliService other = (CliService) obj;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
}
