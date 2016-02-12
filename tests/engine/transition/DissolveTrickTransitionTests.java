package tests.engine.transition;

import java.util.*;
import com.world.*;
import com.world.character.CharacterCard;
import com.engine.actions.*;
import com.engine.transition.*;
import tests.*;

public class DissolveTrickTransitionTests {

	public static boolean verbose = true;
	public static int pass = 0;
	public static int fail = 0;
	private static DissolveTrickTransition sut;
	private static Stage stage;
	private static GameState gameState;
	
	public static void AllTests() {
		System.out.println("DissolveTrickTransitionTests started.");
		TestInitialise();
		try {TestInitialise(); MovesOnlyTrickFromTheCache();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); MovesTheRightTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		
		System.out.println("DissolveTrickTransitionTests finished: " + pass + " pass(es) & " + fail + " failure(s).");
	}
	
	private static void TestInitialise() {
		stage = new Stage();
		gameState = new GameState(stage, new Stage(), new FateCardCollection(), new FateCardCollection(), new FateCardCollection(), new ArrayList<CharacterCard>());
		sut = new DissolveTrickTransition();
	}
	
	private static void MovesOnlyTrickFromTheCache() throws Exception {
		Assert.Print("  MovesOnlyTrickFromTheCache");
		
		ArrayList<FateCard> initialCards = new ArrayList<FateCard>();
		initialCards.add(Mother.mountainFolk);
		initialCards.add(Mother.mountainNature);
		initialCards.add(Mother.mountainLocation);
		Trick trick = new Trick (initialCards);
		stage.AddToCache(trick);
		DissolveTrick action = new DissolveTrick(trick);

		sut.Apply(action, gameState);
		
		Assert.AreEqual(0, stage.GetCache().size(), "The trick has not been removed.");
		Assert.AreEqual(3, stage.GetCamp().size(), "The cards have not been added to the camp");
		
		boolean cardsMatch = true;
		for (FateCard card : stage.GetCamp()) {
			cardsMatch &= (card == Mother.mountainFolk
				|| card == Mother.mountainNature
				|| card == Mother.mountainLocation);
		}
		Assert.IsTrue(cardsMatch, "Not all the cards that were supposed to be in the camp made it there");
		
		pass++;
	}
	
		
	private static void MovesTheRightTrick() throws Exception {
		Assert.Print("  MovesTheRightTrick");
		
		ArrayList<FateCard> initialCards = new ArrayList<FateCard>();
		initialCards.add(Mother.mountainFolk);
		initialCards.add(Mother.mountainNature);
		initialCards.add(Mother.mountainLocation);
		Trick trickToMove = new Trick (initialCards);
		stage.AddToCache(trickToMove);
		DissolveTrick action = new DissolveTrick(trickToMove);

		initialCards = new ArrayList<FateCard>();
		initialCards.add(Mother.mountainFolk);
		initialCards.add(Mother.mountainNature);
		initialCards.add(Mother.mountainLocation);
		Trick otherTrick = new Trick (initialCards);
		stage.AddToCache(otherTrick);
		
		sut.Apply(action, gameState);
		
		Assert.AreEqual(1, stage.GetCache().size(), "The trick has not been removed.");
		Assert.AreEqual(otherTrick, stage.GetCache().toArray()[0], "The wrong trick has been removed");
		
		Assert.AreEqual(3, stage.GetCamp().size(), "The cards have not been added to the camp");
		boolean cardsMatch = true;
		for (FateCard card : stage.GetCamp()) {
			cardsMatch &= (card == Mother.mountainFolk
				|| card == Mother.mountainNature
				|| card == Mother.mountainLocation);
		}
		Assert.IsTrue(cardsMatch, "Not all the cards that were supposed to be in the camp made it there");
		
		pass++;
	}
}