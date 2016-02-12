package com.engine.actions;

import com.world.*;
import com.world.character.*;

public class FetchAction extends GameAction{
	private CharacterCard character;
	private FateCard card;
	
	public FetchAction(CharacterCard character, FateCard card) {
		if (character == null) throw new java.lang.IllegalArgumentException("character is null");
		if (card == null) throw new java.lang.IllegalArgumentException("card is null");
		
		this.character = character;
		this.card = card;
	}
	
	public CharacterCard GetCharacter() {
		return character;
	}
	
	public FateCard GetCard() {
		return card;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other instanceof FetchAction;
		if (result) {
			FetchAction otherFetchAction = (FetchAction) other;
			result = character == otherFetchAction.character
				&& card == otherFetchAction.card;
		}
		
		return result;
	}
	
	@Override 
	public int hashCode() {
		int result = getClass().getName().hashCode();
		result = 37 * result + character.hashCode();
		result = 37 * result + card.hashCode();
		return result;
	}
}