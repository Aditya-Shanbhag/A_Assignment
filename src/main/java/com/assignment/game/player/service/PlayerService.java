package com.assignment.game.player.service;

import com.assignment.game.cli.service.CliService;
import com.assignment.game.player.avatar.appearance.Accessory;
import com.assignment.game.player.avatar.appearance.BlackAviatorGoggles;
import com.assignment.game.player.avatar.appearance.ClothingItem;
import com.assignment.game.player.avatar.appearance.MensBlueJeans;
import com.assignment.game.player.avatar.appearance.MensCargoPant;
import com.assignment.game.player.avatar.appearance.MensGreyTShirt;
import com.assignment.game.player.avatar.appearance.MensWhiteShirt;
import com.assignment.game.player.avatar.appearance.Watch;
import com.assignment.game.player.avatar.appearance.WomensBlackPants;
import com.assignment.game.player.avatar.appearance.WomensPinkTShirt;
import com.assignment.game.player.avatar.appearance.WomensWhiteJeans;
import com.assignment.game.player.avatar.appearance.WomensWhiteTop;
import com.assignment.game.player.model.Avatar;
import com.assignment.game.player.model.Avatar.AvatarBuilder;
import com.assignment.game.player.model.Avatar.Gender;
import com.assignment.game.player.model.Player;
import com.assignment.game.score.model.Score;
import com.assignment.game.util.GameConstants;

public class PlayerService {
	private CliService cliService;

	public PlayerService(){
		cliService = CliService.getInstance();
	}

	public Player initializeNewPlayer() {
		Player player = new Player();
		player.setScore(new Score());
		player.setHealth(GameConstants.playerInitialHealth);
		player.setAvatar(this.initializePlayerAvatar());
		return player;
	}

	public CliService getCliService() {
		return cliService;
	}

	private Avatar initializePlayerAvatar(){
		AvatarBuilder avatarBuilder = new AvatarBuilder();

		cliService.printToConsole("Lets create an avatar for you");
		this.populatePlayerGender(avatarBuilder);
		
		cliService.printToConsole("Lets choose some clothing for avatar.");
		this.populatePlayerClothing(avatarBuilder);
		
		cliService.printToConsole("Lets choose some accessory for avatar.");
		this.populatePlayerAccessory(avatarBuilder);

		return avatarBuilder.buildAvatar();
	}

	/**
	 * Propmts user for Gender and parses and returns a {@link Gender}
	 * 
	 * @return
	 */
	private void populatePlayerGender(AvatarBuilder avatarBuilder){
		while(avatarBuilder.getGender() == null){
			cliService.printToConsole("Select Gender\n 1 for Male \t 2 for Female");
			String userInput = cliService.getInputFromConsole();
			if("1".equalsIgnoreCase(userInput)){
				avatarBuilder.setGender(Gender.MALE); 
			}else if("2".equalsIgnoreCase(userInput)){
				avatarBuilder.setGender(Gender.FEMALE);
			}else{
				cliService.printToConsole("Invalid selection, please try again");
			}
		}
	}

	private void populatePlayerClothing(AvatarBuilder avatarBuilder) {
		//TODO - Handle this better. Probably by having a property in clothing item and then filtering.
		StringBuilder builder = new StringBuilder();
		builder.append("Select\t");
		if(Gender.MALE.equals(avatarBuilder.getGender())){
			builder.append("1 for Grey T-Shirt.\t");
			builder.append("2 for White Shirt.\t");
			builder.append("3 for Cargo Pants.\t");
			builder.append("4 for Blue Jeans.\t");
		}else if (Gender.FEMALE.equals(avatarBuilder.getGender())){
			builder.append("1 for Pink T-Shirt.\t");
			builder.append("2 for White Top.\t");
			builder.append("3 for Black Pants.\t");
			builder.append("4 for White Jeans.\t");
		}
		String selectText = builder.toString();
		String addMoreItems = GameConstants.YES;
		while(GameConstants.YES.equalsIgnoreCase(addMoreItems)){
			ClothingItem item = null;
			while(item == null){
				cliService.printToConsole(selectText);
				String userInput = cliService.getInputFromConsole();
				item = this.parseAndGetClothingItem(avatarBuilder.getGender(), userInput);
				if(item == null){
					cliService.printToConsole("Invalid input please try again.");
				}
			}
			avatarBuilder.addClothingItem(item);
			cliService.printToConsole("Want to add more items?\n Yes \t No");
			addMoreItems = cliService.getInputFromConsole();
		}
	}

	private ClothingItem parseAndGetClothingItem(Gender gender, String userInput){
		ClothingItem item = null;
		if(Gender.MALE.equals(gender)){
			switch (userInput) {
			case "1":
				item = new MensGreyTShirt();
				break;
			case "2":
				item = new MensWhiteShirt();
				break;
			case "3":
				item = new MensCargoPant();
				break;
			case "4":
				item = new MensBlueJeans();
				break;
			}
		}else if (Gender.FEMALE.equals(gender)){
			switch (userInput) {
			case "1":
				item = new WomensPinkTShirt();
				break;
			case "2":
				item = new WomensWhiteTop();
				break;
			case "3":
				item = new WomensBlackPants();
				break;
			case "4":
				item = new WomensWhiteJeans();
				break;
			}
		}
		return item;
	}

	private void populatePlayerAccessory(AvatarBuilder avatarBuilder) {
		//TODO - Handle this better. Probably by having a property in clothing item and then filtering.
		StringBuilder builder = new StringBuilder();
		builder.append("Select\t");
		builder.append("1 for Aviator Googles.\t");
		builder.append("2 for Watch.\t");

		String selectText = builder.toString();
		String addMoreItems = GameConstants.YES;

		while(GameConstants.YES.equalsIgnoreCase(addMoreItems)){
			Accessory accessory = null;
			while(accessory == null){
				cliService.printToConsole(selectText);
				String userInput = cliService.getInputFromConsole();
				accessory = this.parseAndGetAccessory(avatarBuilder.getGender(), userInput);
				if(accessory == null){
					cliService.printToConsole("Invalid input please try again.");
				}
			}
			avatarBuilder.addAccessory(accessory);
			cliService.printToConsole("Want to add more items?\n Yes \t No");
			addMoreItems = cliService.getInputFromConsole();
		}
	}

	private Accessory parseAndGetAccessory(Gender gender, String userInput) {
		Accessory accessory = null;
		switch (userInput) {
		case "1":
			accessory = new BlackAviatorGoggles();
			break;
		case "2":
			accessory = new Watch();
			break;
		}
		return accessory;
	}
}
