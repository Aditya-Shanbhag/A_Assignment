package com.assignment.game.player.model;

import java.io.Serializable;
import java.util.List;

import com.assignment.game.player.character.appearance.Accessory;
import com.assignment.game.player.character.appearance.ClothingItem;

/**
 * 
 * @author Aditya
 *
 * {@link Avatar} class to represent player avatar.
 */
public class Avatar implements Serializable{
	private static final long serialVersionUID = 1L;

	public enum CharacterGender {
		Male,
		FEMALE
	}

	private List<ClothingItem> clothingItemList;
	private List<Accessory> accessoryList;
	private CharacterGender gender;
	
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
	public CharacterGender getGender() {
		return gender;
	}
	public void setGender(CharacterGender gender) {
		this.gender = gender;
	}
	
	public void displayCharacter(){
		if(clothingItemList != null && !clothingItemList.isEmpty()){
			clothingItemList.stream().forEach(item -> item.displayCharacterItem());
		}
		
		if(accessoryList != null && !accessoryList.isEmpty()){
			accessoryList.stream().forEach(item -> item.displayCharacterItem());
		}
	}
}
