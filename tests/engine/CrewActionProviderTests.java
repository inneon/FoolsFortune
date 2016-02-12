package tests.engine;

import java.util.*;
import com.world.*;
import com.world.character.*;
import com.engine.actionProviders.*;
import com.engine.actions.*;
import tests.*;

public class CrewActionProviderTests {

	public static boolean verbose = true;
	public static int pass = 0;
	public static int fail = 0;
	private static CrewActionProvider sut;
	private static Stage stage;
	private static FateCardCollection fair;
	
	public static void AllTests() {
		System.out.println("CrewActionProviderTests started.");
		TestInitialise();
		try {TestInitialise(); EmptyFairGivesNoActions();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); EngagedCharacterCannotFetch();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); CharacterCanFetchCardAllignedToHisFee();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		try {TestInitialise(); TwoCharactersCanFetchMutualCard();} catch (Exception e) {Assert.PrintError(e.getMessage()); fail++;}
		
		System.out.println("CrewActionProviderTests finished: " + pass + " pass(es) & " + fail + " failure(s).");
	}
	
	private static void TestInitialise() {
		fair = new FateCardCollection();
		stage = new Stage();
		GameState gameState = new GameState(stage, new Stage(), fair, new FateCardCollection(), new FateCardCollection(), new ArrayList<CharacterCard>());
		sut = new CrewActionProvider(gameState);
	}
	
	private static void EmptyFairGivesNoActions() throws Exception {
		Assert.Print("  EmptyFairGivesNoActions");
		SavvyCharacterCard characterCard = new SavvyCharacterCard(Realm.forest);
		PaidCharacter character = new PaidCharacter(characterCard, Mother.cityFolk, Mother.cityLocation);
		character.SetStatus(PaidCharacterStatus.ready);
		stage.AddToCrew(character);
		
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 0, "Incorrect number of actions returned.");
		pass++;
	}
	
	private static void EngagedCharacterCannotFetch() throws Exception {
		Assert.Print("  EngagedCharacterCannotFetch");;
		SavvyCharacterCard characterCard = new SavvyCharacterCard(Realm.forest);
		PaidCharacter character = new PaidCharacter(characterCard, Mother.cityFolk, Mother.cityLocation);
		stage.AddToCrew(character);
		fair.Add(Mother.cityTreasure);
		
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(result.size(), 0, "Incorrect number of actions returned.");
		pass++;
	}
	
	private static void CharacterCanFetchCardAllignedToHisFee() throws Exception {
		Assert.Print("  CharacterCanFetchCardAllignedToHisFee");
		SavvyCharacterCard characterCard = new SavvyCharacterCard(Realm.forest);
		PaidCharacter relevantCharacter = new PaidCharacter(characterCard, Mother.cityFolk, Mother.cityLocation);
		relevantCharacter.SetStatus(PaidCharacterStatus.ready);
		stage.AddToCrew(relevantCharacter);
		PaidCharacter irrelevantCharacter = new PaidCharacter(new SavvyCharacterCard(Realm.mountain), Mother.mountainFolk, Mother.mountainFolk);
		irrelevantCharacter.SetStatus(PaidCharacterStatus.ready);
		stage.AddToCrew(irrelevantCharacter);
		fair.Add(Mother.cityTreasure);
		
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(1, result.size(), "wrong number of actions returned");
		Assert.IsTrue(result.get(0) instanceof FetchAction, "Type of gameaction is wrong");
		FetchAction action = (FetchAction) result.get(0);
		Assert.AreEqual(relevantCharacter.GetCharacterCard(), action.GetCharacter(), "The wrong character attempter to fetch");
		Assert.AreEqual(Mother.cityTreasure, action.GetCard(), "The character attempter to fetch the wrong card");
		
		pass++;
	}
	
	private static void TwoCharactersCanFetchMutualCard() throws Exception {
		Assert.Print("  TwoCharactersCanFetchMutualCard");
		
		SavvyCharacterCard savvyCharacterCard = new SavvyCharacterCard(Realm.forest);
		PaidCharacter savvyCharacter = new PaidCharacter(savvyCharacterCard, Mother.cityFolk, Mother.cityLocation);
		savvyCharacter.SetStatus(PaidCharacterStatus.ready);
		stage.AddToCrew(savvyCharacter);
		SkilledCharacterCard skilledCharacterCard = new SkilledCharacterCard(Realm.forest, Resource.folk);
		PaidCharacter skilledCharacter = new PaidCharacter(skilledCharacterCard, Mother.mountainSupernatural, Mother.forestTreasure);
		skilledCharacter.SetStatus(PaidCharacterStatus.ready);
		stage.AddToCrew(skilledCharacter);
		fair.Add(Mother.cityTreasure);
		fair.Add(Mother.coastNature);
		
		List<GameAction> result = sut.GetAvailableActions();
		
		Assert.AreEqual(2, result.size(), "wrong number of actions returned");
		
		Assert.IsTrue(result.get(0) instanceof FetchAction, "Type of gameAction is wrong (1)");
		FetchAction first = (FetchAction) result.get(0);
		Assert.AreEqual(Mother.cityTreasure, first.GetCard(), "The character attempter to fetch the wrong card");
		boolean matchCharacter = false;
		if (first.GetCharacter() == savvyCharacterCard) {
			matchCharacter = true;
			savvyCharacterCard = null;
		}
		if (first.GetCharacter() == skilledCharacterCard) {
			matchCharacter = true;
			skilledCharacterCard = null;
		}
		Assert.IsTrue(matchCharacter, "A character did not fetch the card (1)");
		
		Assert.IsTrue(result.get(1) instanceof FetchAction, "Type of gameAction is wrong (2)");
		FetchAction second = (FetchAction) result.get(1);
		Assert.AreEqual(Mother.cityTreasure, second.GetCard(), "The character attempter to fetch the wrong card");
		matchCharacter = false;
		if (second.GetCharacter() == savvyCharacterCard) {
			matchCharacter = true;
			savvyCharacterCard = null;
		}
		if (second.GetCharacter() == skilledCharacterCard) {
			matchCharacter = true;
			skilledCharacterCard = null;
		}
		Assert.IsTrue(matchCharacter, "A character did not fetch the card (2)");
		
		pass++;
	}
}