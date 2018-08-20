package com.assignment.game.player.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.assignment.game.player.avatar.appearance.Accessory;
import com.assignment.game.player.avatar.appearance.ClothingItem;

/**
 * 
 * @author Aditya
 *
 *         {@link Avatar} class to represent player avatar.
 */
public class Avatar implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum Gender {
		MALE, FEMALE
	}

	private List<ClothingItem> clothingItemList;
	private List<Accessory> accessoryList;
	private Gender gender;

	public Avatar(AvatarBuilder builder) {
		this.gender = builder.gender;
		this.clothingItemList = builder.clothingItemList;
		this.accessoryList = builder.accessoryList;
	}

	public List<ClothingItem> getClothingItemList() {
		return clothingItemList;
	}

	public void setClothingItemList(List<ClothingItem> clothingItemList) {
		this.clothingItemList = clothingItemList;
	}

	public List<Accessory> getAccessoryList() {
		return accessoryList;
	}

	public void setAccessoryList(List<Accessory> accessoryList) {
		this.accessoryList = accessoryList;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void displayCharacter() {
		if (clothingItemList != null && !clothingItemList.isEmpty()) {
			clothingItemList.stream().forEach(item -> item.displayCharacterItem());
		}

		if (accessoryList != null && !accessoryList.isEmpty()) {
			accessoryList.stream().forEach(item -> item.displayCharacterItem());
		}
	}

	/**
	 * 
	 * @author Aditya
	 *
	 *         Avatar builder class
	 */
	public static class AvatarBuilder {
		private List<ClothingItem> clothingItemList = new ArrayList<>(5);
		private List<Accessory> accessoryList = new ArrayList<>(5);
		private Gender gender;

		public AvatarBuilder() {
			super();
		}

		public List<ClothingItem> getClothingItemList() {
			return clothingItemList;
		}

		public void setClothingItemList(List<ClothingItem> clothingItemList) {
			this.clothingItemList = clothingItemList;
		}

		public List<Accessory> getAccessoryList() {
			return accessoryList;
		}

		public void setAccessoryList(List<Accessory> accessoryList) {
			this.accessoryList = accessoryList;
		}

		public Gender getGender() {
			return gender;
		}

		public AvatarBuilder setGender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public AvatarBuilder addAccessory(Accessory accessory) {
			this.accessoryList.add(accessory);
			return this;
		}

		public AvatarBuilder addClothingItem(ClothingItem clothingItem) {
			this.clothingItemList.add(clothingItem);
			return this;
		}

		public Avatar buildAvatar() {
			return new Avatar(this);
		}
	}
}
