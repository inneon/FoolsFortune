package com.engine.transition;

import com.world.*;

public abstract class Transition<TAction extends com.engine.actions.GameAction> {
	public abstract void Apply(TAction action, GameState gameState);
}