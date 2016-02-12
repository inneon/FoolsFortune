package com.engine.transition;

import com.world.*;
import com.engine.actions.*;

public class DissolveTrickTransition extends Transition<DissolveTrick> {
	
	public void Apply(DissolveTrick action, GameState gameState) {
		Stage stage = gameState.GetStage();
		
		stage.RemoveFromCache(action.GetTrick());
		
		for (FateCard card : action.GetTrick().GetCards()) {
			stage.AddToCamp(card);
		}
	}
}