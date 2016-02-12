package com.world;

import java.util.*;

public class FateCardCollection extends Printable {
	protected ArrayList<FateCard> cards;

	public FateCardCollection() {
		cards = new ArrayList<FateCard>();
	}
	
	public String Printable (int depth) {
		String result = GetPadding(depth) + "{ ";
		for (FateCard card : cards) {
			result = result + card.Printable(0) + " ";
		}
		result = result + GetPadding(depth) + "}";
		return result;
	}
	
	public void Add(FateCard card) {
		if (card == null) throw new java.lang.IllegalArgumentException("card is null");
		
		cards.add(card);
	}
	
	public void Remove(FateCard card) {
		if (card == null) throw new java.lang.IllegalArgumentException("card is null");
		
		if (!cards.remove(card)) {
			throw new java.lang.IllegalArgumentException("Attempted to remove card " + card.Printable(0) + " from a trick which was not found");
		}
	}
	
	public Collection<FateCard> GetCards() {
		return cards;
	}
}
