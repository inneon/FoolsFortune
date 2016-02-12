package com.engine.actionProviders;

import com.engine.actions.*;
import com.world.*;
import java.util.*;

public class StageActionProvider extends ActionProvider {
	
	private Stage stage;
	
	public StageActionProvider(Stage stage) {
		if (stage == null) throw new java.lang.IllegalArgumentException("stage is null");
		
		this.stage = stage;
	}
	
	public List<GameAction> GetAvailableActions() {
		List<GameAction> result = new ArrayList<GameAction>();
		for (Trick trick : stage.GetCache()) {
			result.add(new DissolveTrick(trick));
			
			for (FateCard card : stage.GetCamp()) {
				if (trick.CanAddCard(card)) {
					result.add(new AddToTrick(trick, card));
				}
			}
		}
		return result;
	}
	
		
}
