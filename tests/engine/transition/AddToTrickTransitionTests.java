package tests.engine.transition;

import java.util.*;
import com.world.*;
import com.world.character.CharacterCard;
import com.engine.actions.*;
import com.engine.transition.*;
import tests.*;

public class AddToTrickTransitionTests {

	public static boolean verbose = true;
	public static int pass = 0;
	public static int fail = 0;
	private static AddToTrickTransition sut;
	private static Stage stage;
	private static GameState gameState;
	
	public static void AllTests() {
		System.out.println("AddToTrickTransitionTests started.");
		TestInitialise();
		try {TestInitialise(); MovesACardToATrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); MovesTheCorrectCard();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		
		System.out.println("AddToTrickTransitionTests finished: " + pass + " pass(es) & " + fail + " failure(s).");
	}
	
	private static void TestInitialise() {
		stage = new Stage();
		gameState = new GameState(stage, new Stage(), new FateCardCollection(), new FateCardCollection(), new FateCardCollection(), new ArrayList<CharacterCard>());
		sut = new AddToTrickTransition();
	}
	
	private static void MovesACardToATrick() throws Exception {
		Assert.Print("  MovesACardToATrick");
		
		ArrayList<FateCard> initialCards = new ArrayList<FateCard>();
		initialCards.add(Mother.mountainFolk);
		initialCards.add(Mother.mountainNature);
		initialCards.add(Mother.mountainLocation);
		Trick trick = new Trick (initialCards);
		stage.AddToCache(trick);
		FateCard toAdd = Mother.mountainTreasure;
		stage.AddToCamp(toAdd);
		AddToTrick action = new AddToTrick(trick, toAdd);
		
		sut.Apply(action, gameState);
		
		Assert.AreEqual(0, stage.GetCamp().size(), "The card has not been removed from the camp");
		Assert.AreEqual(4, trick.GetCards().size(), "The card has not been added to the trick");		
		
		pass++;
	}
	
		private static void MovesTheCorrectCard() throws Exception {
		Assert.Print("  MovesTheCorrectCard");
		
		ArrayList<FateCard> initialCards = new ArrayList<FateCard>();
		initialCards.add(Mother.mountainFolk);
		initialCards.add(Mother.mountainNature);
		initialCards.add(Mother.mountainLocation);
		Trick trick = new Trick (initialCards);
		stage.AddToCache(trick);
		FateCard toAdd = Mother.mountainTreasure;
		stage.AddToCamp(toAdd);
		FateCard otherCard = Mother.cityTreasure;
		stage.AddToCamp(otherCard);
		AddToTrick action = new AddToTrick(trick, toAdd);
		
		sut.Apply(action, gameState);
		
		Assert.AreEqual(1, stage.GetCamp().size(), "The card has not been removed from the camp");
		Assert.AreEqual(otherCard, stage.GetCamp().toArray()[0], "The wrong card has been taken from the camp");		
		
		pass++;
	}
	
}