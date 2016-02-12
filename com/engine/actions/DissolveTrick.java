package com.engine.actions;

import com.world.*;

public class DissolveTrick extends GameAction {
	private Trick trick;

	public DissolveTrick(Trick trick) {
		if (trick == null) throw new java.lang.IllegalArgumentException("trick is null");
		this.trick = trick;
	}
	
	public Trick GetTrick() {
		return trick;
	}
}
