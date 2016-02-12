package com.world;

import java.util.*;

import com.world.character.*;

public class GameState {
	private Stage stage;
	private Stage opponentStage;
	private FateCardCollection fair;
	private ArrayList<CharacterCard> road;
	private FateCardCollection hand;
	private FateCardCollection opponentHand;
	
	public GameState(Stage stage, Stage opponentStage, FateCardCollection fair, 
			FateCardCollection hand, FateCardCollection opponentHand, ArrayList<CharacterCard> road) {
		if (stage == null) throw new java.lang.IllegalArgumentException("stage is null");
		if (opponentStage == null) throw new java.lang.IllegalArgumentException("opponentStage is null");
		if (fair == null) throw new java.lang.IllegalArgumentException("fair is null");
		if (road == null) throw new java.lang.IllegalArgumentException("road is null");
		if (hand == null) throw new java.lang.IllegalArgumentException("hand is null");
		if (opponentHand == null) throw new java.lang.IllegalArgumentException("opponentHand is null");
		
		this.stage = stage;
		this.opponentStage = opponentStage;
		this.fair = fair;
		this.road = road;
		this.hand = hand;
		this.opponentHand = opponentHand;
	}
	
	public Stage GetStage() {
		return stage;
	}
	
	public Stage GetOpponentStage() {
		return opponentStage;
	}
	
	public FateCardCollection GetFair() {
		return fair;
	}
	
	public ArrayList<CharacterCard> GetRoad() {
		return road;
	}
	
	public FateCardCollection GetHand() {
		return hand;
	}
	
	public FateCardCollection GetOpponentHand() {
		return opponentHand;
	}
}
