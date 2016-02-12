package com.engine.transition;

import com.world.*;
import com.engine.actions.*;

public class AddToTrickTransition extends Transition<AddToTrick> {
	
	public void Apply(AddToTrick action, GameState gameState) {
		gameState.GetStage().GetCamp().remove(action.GetCard());
		action.GetTrick().Add(action.GetCard());
	}
}