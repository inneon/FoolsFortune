package com.engine.actionProviders;

import com.engine.actions.*;
import com.world.*;
import com.world.character.*;
import java.util.*;

public class CrewActionProvider extends ActionProvider {
	
	private GameState gameState;
	
	public CrewActionProvider(GameState gameState) {
		if (gameState == null) throw new java.lang.IllegalArgumentException("gameState is null");
		
		this.gameState = gameState;
	}
	
	public List<GameAction> GetAvailableActions() {
		Set<GameAction> result = new HashSet<GameAction>();
		
		for (PaidCharacter character : gameState.GetStage().GetCrew()) {
			if (character.GetStatus() == PaidCharacterStatus.ready) {
				for (FateCard fee : character.GetFees()) {
					for (FateCard toFetch : gameState.GetFair().GetCards()) {
						if (toFetch.GetRealm() == fee.GetRealm() || toFetch.GetResource() == fee.GetResource()) {
							result.add(new FetchAction(character.GetCharacterCard(), toFetch));
						}
					}
				}
			}
		}
		
		return new ArrayList<GameAction>(result);
	}
	
}