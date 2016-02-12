package com.engine.actions;

import com.world.*;

public class AddToTrick extends GameAction{

	private Trick trick;
	private FateCard card;

	public AddToTrick(Trick trick, FateCard card) {
		if (trick == null) throw new java.lang.IllegalArgumentException("trick is null");
		if (card == null) throw new java.lang.IllegalArgumentException("card is null");
		this.trick = trick;
		this.card = card;
	}

	public Trick GetTrick() {
		return trick;
	}
	
	public FateCard GetCard() { 
		return card;
	}
}
