package com.assignment.game.service;

import java.util.HashMap;
import java.util.Map;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.gameplay.service.GamePlayService;
import com.assignment.game.player.service.PlayerService;
import com.assignment.game.score.service.ScoreService;
import com.assignment.game.state.service.StateService;
import com.assignment.game.util.Util;

public class ServiceFactory {
	public final static Map<String,Service> serviceMap = new HashMap<String,Service>();
	public final static String CLI_SERVICE = "cliservice";
	public final static String STATE_SERVICE = "stateservice";
	public final static String PLAYER_SERVICE = "playerservice";
	public final static String SCORE_SERVICE = "scoreservice";
	public final static String GAMEPLAY_SERVICE = "gameplayservice";

	public synchronized static Object getService(String serviceName){
		if(!serviceMap.containsKey(serviceName)){
			serviceMap.put(serviceName, getServiceInstance(serviceName));
		}
		return serviceMap.get(serviceName);
	}


	private static Service getServiceInstance(String serviceName){
		if(!Util.isNullOrEmpty(serviceName)){
			switch (serviceName.toLowerCase()) {
			case STATE_SERVICE:
				return new StateService();

			case PLAYER_SERVICE:
				return new PlayerService();
				
			case GAMEPLAY_SERVICE:
				return new GamePlayService();

			case CLI_SERVICE:
				return new CliService();

			case SCORE_SERVICE:
				return new ScoreService();

			default:
				break;
			}
		}
		return null;
	}
}
