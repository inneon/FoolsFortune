package tests.engine;

import java.util.*;
import com.world.*;
import com.engine.actionProviders.*;
import com.engine.actions.*;
import tests.*;

public class StageActionProviderTests {

	public static boolean verbose = true;
	public static int pass = 0;
	public static int fail = 0;
	private static StageActionProvider sut;
	private static Stage stage;
	
	public static void AllTests() {
		System.out.println("TrickTests started.");
		TestInitialise();
		try {TestInitialise(); EmptyStageAllowsNoActions();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); StageWithOneTrickHasOneAction();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); CanAddACardToAForestTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); CanAddACardToAFolkTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); CanAddAWildToAForestTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); CanAddAWildToAFolkTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); CanAddAFolkToAWildTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); WontAddATreasureToAFolkTrick();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); WontAddACityToAFolkTrickThatContainsFolkCity();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		
		System.out.println("TrickTests finished: " + pass + " pass(es) & " + fail + " failure(s).");
	}
	
	private static void TestInitialise() {
		stage = new Stage();
		sut = new StageActionProvider(stage);
	}
	
	private static void EmptyStageAllowsNoActions() throws Exception {
		Assert.Print("  EmptyStageAllowsNoActions");
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 0, "Incorrect number of actions returned.");
		pass++;
	}	
		
	private static void StageWithOneTrickHasOneAction() throws Exception {
		Assert.Print("  StageWithOneTrickHasOneAction");
		Trick trick = Mother.forestTrick3;
		stage.AddToCache(trick);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 1, "Incorrect number of actions returned.");
		Assert.IsTrue(result.get(0) instanceof DissolveTrick, "Type of gameaction is wrong");
		DissolveTrick dissolveTrickAction = (DissolveTrick)result.get(0);
		Assert.AreEqual(dissolveTrickAction.GetTrick(),trick, "Incorrect trick to dissolve");
		pass++;
	}
	
	private static void CanAddACardToAForestTrick() throws Exception {
		Assert.Print("  CanAddACardToAForestTrick");
		Trick trick = Mother.forestTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.forestTreasure;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 2, "Incorrect number of actions returned.");
		AddToTrick resultAction = null;
		for (GameAction action : result) {
			if (action instanceof AddToTrick) {
				Assert.AreEqual(null, resultAction, "2 candidates AddToTricks have been found.");
				resultAction = (AddToTrick)action;
			}
		}
		Assert.AreNotEqual((AddToTrick)null, resultAction, "No AddToTrick found.");
		Assert.AreEqual(trick, resultAction.GetTrick(), "Adding to the wrong trick.");
		Assert.AreEqual(card, resultAction.GetCard(), "Adding the wrong card to the trick.");
		pass++;
	}	
	
	private static void CanAddACardToAFolkTrick() throws Exception {
		Assert.Print("  CanAddACardToAFolkTrick");
		//One trick
		Trick trick = Mother.folkTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.mountainFolk;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 2, "Incorrect number of actions returned.");
		AddToTrick resultAction = null;
		for (GameAction action : result) {
			if (action instanceof AddToTrick) {
				Assert.AreEqual(null, resultAction, "2 candidates AddToTricks have been found.");
				resultAction = (AddToTrick)action;
			}
		}
		Assert.AreNotEqual((AddToTrick)null, resultAction, "No AddToTrick found.");
		Assert.AreEqual(trick, resultAction.GetTrick(), "Adding to the wrong trick.");
		Assert.AreEqual(card, resultAction.GetCard(), "Adding the wrong card to the trick.");
		pass++;
	}	
	
	private static void CanAddAWildToAForestTrick() throws Exception {
		Assert.Print("  CanAddAWildToAForestTrick");
		//One trick
		Trick trick = Mother.forestTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.forestWild;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 2, "Incorrect number of actions returned.");
		AddToTrick resultAction = null;
		for (GameAction action : result) {
			if (action instanceof AddToTrick) {
				Assert.AreEqual(null, resultAction, "2 candidates AddToTricks have been found.");
				resultAction = (AddToTrick)action;
			}
		}
		Assert.AreNotEqual((AddToTrick)null, resultAction, "No AddToTrick found.");
		Assert.AreEqual(trick, resultAction.GetTrick(), "Adding to the wrong trick.");
		Assert.AreEqual(card, resultAction.GetCard(), "Adding the wrong card to the trick.");
		pass++;
	}
	
	private static void CanAddAWildToAFolkTrick() throws Exception {
		Assert.Print("  CanAddAWildToAFolkTrick");
		//One trick
		Trick trick = Mother.folkTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.mountainWild;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 2, "Incorrect number of actions returned.");
		AddToTrick resultAction = null;
		for (GameAction action : result) {
			if (action instanceof AddToTrick) {
				Assert.AreEqual(null, resultAction, "2 candidates AddToTricks have been found.");
				resultAction = (AddToTrick)action;
			}
		}
		Assert.AreNotEqual((AddToTrick)null, resultAction, "No AddToTrick found.");
		Assert.AreEqual(trick, resultAction.GetTrick(), "Adding to the wrong trick.");
		Assert.AreEqual(card, resultAction.GetCard(), "Adding the wrong card to the trick.");
		pass++;
	}
	
		private static void CanAddAFolkToAWildTrick() throws Exception {
		Assert.Print("  CanAddAFolkToAWildTrick");
		//One trick
		Trick trick = Mother.wildTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.mountainFolk;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 2, "Incorrect number of actions returned.");
		AddToTrick resultAction = null;
		for (GameAction action : result) {
			if (action instanceof AddToTrick) {
				Assert.AreEqual(null, resultAction, "2 candidates AddToTricks have been found.");
				resultAction = (AddToTrick)action;
			}
		}
		Assert.AreNotEqual((AddToTrick)null, resultAction, "No AddToTrick found.");
		Assert.AreEqual(trick, resultAction.GetTrick(), "Adding to the wrong trick.");
		Assert.AreEqual(card, resultAction.GetCard(), "Adding the wrong card to the trick.");
		pass++;
	}
	
	private static void WontAddATreasureToAFolkTrick() throws Exception {
		Assert.Print("  WontAddATreasureToAFolkTrick");
		//One trick
		Trick trick = Mother.folkTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.mountainTreasure;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 1, "Incorrect number of actions returned.");
		pass++;
	}
	
	private static void WontAddACityToAFolkTrickThatContainsFolkCity() throws Exception {
		Assert.Print("  WontAddACityToAFolkTrickThatContainsFolkCity");
		//One trick
		Trick trick = Mother.folkTrick3;
		stage.AddToCache(trick);
		//The card to add
		FateCard card = Mother.cityFolk;
		stage.AddToCamp(card);
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 1, "Incorrect number of actions returned.");
		pass++;
	}
}
