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
import com.assignment.game.player.exception.PlayerHealthExhaustedException;
import com.assignment.game.player.model.Avatar;
import com.assignment.game.player.model.Avatar.AvatarBuilder;
import com.assignment.game.player.model.Avatar.Gender;
import com.assignment.game.player.model.Player;
import com.assignment.game.service.Service;
import com.assignment.game.service.ServiceFactory;
import com.assignment.game.util.GameConstants;

public class PlayerService implements Service {
	private final String serviceName = ServiceFactory.PLAYER_SERVICE;
	private Player player;

	private final CliService cliService;

	public PlayerService() {
		cliService = (CliService) ServiceFactory.getService(ServiceFactory.CLI_SERVICE);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getServiceName() {
		return serviceName;
	}

	public CliService getCliService() {
		return cliService;
	}

	public Player initializeNewPlayer() {
		Player player = new Player();
		player.setHealth(GameConstants.playerInitialHealth);
		player.setAvatar(this.initializePlayerAvatar());

		cliService.printToConsole("\nAvatar Created. You are all set to explore.");
		player.getAvatar().displayCharacter();
		return this.player = player;
	}

	private Avatar initializePlayerAvatar() {
		AvatarBuilder avatarBuilder = new AvatarBuilder();

		cliService.printToConsole("\nLets create an avatar for you to get started.");
		this.populatePlayerGender(avatarBuilder);

		cliService.printToConsole("\nLets choose some clothing for avatar.");
		this.populatePlayerClothing(avatarBuilder);

		cliService.printToConsole("\nLets choose some accessory for avatar.");
		this.populatePlayerAccessory(avatarBuilder);

		return avatarBuilder.buildAvatar();
	}

	/**
	 * Propmts user for Gender and parses and returns a {@link Gender}
	 * 
	 * @return
	 */
	private void populatePlayerGender(AvatarBuilder avatarBuilder) {
		while (avatarBuilder.getGender() == null) {
			cliService.printToConsole("\nSelect Gender\n 1 for Male \t 2 for Female");
			String userInput = cliService.getInputFromConsole();
			if ("1".equalsIgnoreCase(userInput)) {
				avatarBuilder.setGender(Gender.MALE);
			} else if ("2".equalsIgnoreCase(userInput)) {
				avatarBuilder.setGender(Gender.FEMALE);
			} else {
				cliService.printToConsole("\nInvalid selection, please try again");
			}
		}
	}

	private void populatePlayerClothing(AvatarBuilder avatarBuilder) {
		// TODO - Handle this better. Probably by having a property in clothing
		// item and then filtering.
		StringBuilder builder = new StringBuilder();
		builder.append("Select\t");
		if (Gender.MALE.equals(avatarBuilder.getGender())) {
			builder.append("1 for Grey T-Shirt.\t");
			builder.append("2 for White Shirt.\t");
			builder.append("3 for Cargo Pants.\t");
			builder.append("4 for Blue Jeans.\t");
		} else if (Gender.FEMALE.equals(avatarBuilder.getGender())) {
			builder.append("1 for Pink T-Shirt.\t");
			builder.append("2 for White Top.\t");
			builder.append("3 for Black Pants.\t");
			builder.append("4 for White Jeans.\t");
		}
		String selectText = builder.toString();
		String addMoreItems = GameConstants.YES;
		while (GameConstants.YES.equalsIgnoreCase(addMoreItems)) {
			ClothingItem item = null;
			while (item == null) {
				cliService.printToConsole(selectText);
				String userInput = cliService.getInputFromConsole();
				item = this.parseAndGetClothingItem(avatarBuilder.getGender(), userInput);
				if (item == null) {
					cliService.printToConsole("\nInvalid input please try again.");
				}
			}
			avatarBuilder.addClothingItem(item);
			cliService.printToConsole("\nWant to add more items?\n Yes \t No");
			addMoreItems = cliService.getInputFromConsole();
		}
	}

	private ClothingItem parseAndGetClothingItem(Gender gender, String userInput) {
		ClothingItem item = null;
		if (Gender.MALE.equals(gender)) {
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
		} else if (Gender.FEMALE.equals(gender)) {
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
		// TODO - Handle this better. Probably by having a property in clothing
		// item and then filtering.
		StringBuilder builder = new StringBuilder();
		builder.append("Select\t");
		builder.append("1 for Aviator Googles.\t");
		builder.append("2 for Watch.\t");

		String selectText = builder.toString();
		String addMoreItems = GameConstants.YES;

		while (GameConstants.YES.equalsIgnoreCase(addMoreItems)) {
			Accessory accessory = null;
			while (accessory == null) {
				cliService.printToConsole(selectText);
				String userInput = cliService.getInputFromConsole();
				accessory = this.parseAndGetAccessory(avatarBuilder.getGender(), userInput);
				if (accessory == null) {
					cliService.printToConsole("\nInvalid input please try again.");
				}
			}
			avatarBuilder.addAccessory(accessory);
			cliService.printToConsole("\nWant to add more items?\n Yes \t No");
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

	public void addPlayerHealth(int health) throws PlayerHealthExhaustedException{
		int finalHealth = player.getHealth() + health;
		if(finalHealth > Player.MAX_HEALTH){
			finalHealth = Player.MAX_HEALTH;
		}
		if(finalHealth <= 0){
			throw new PlayerHealthExhaustedException();
		}
		player.setHealth(finalHealth);
	}

	public Player resetPlayerHealth() {
		this.player.setHealth(100);
		return player;
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
		PlayerService other = (PlayerService) obj;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		return true;
	}
}
