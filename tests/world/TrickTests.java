package tests.world;

import java.lang.Exception;
import java.util.ArrayList;
import com.world.*;
import tests.Assert;

public class TrickTests {
	
	public static boolean verbose = true;
	public static int pass = 0;
	public static int fail = 0;
	
	public static void AllTests() {
		System.out.println("TrickTests started.");
		try {CanMakeForestTrick();} catch (Exception e) {fail++;}
		try {CanMakeFolkTrick();} catch (Exception e) {fail++;}
		try {CanMakeFolkTrickWithWild();} catch (Exception e) {fail++;}
		try {CanMakeWildTrick();} catch (Exception e) {fail++;}
		try {CantMakeTrickWithTwo();} catch (Exception e) {fail++;}
		try {CantMakeTrickWithIdenticalCards();} catch (Exception e) {fail++;}
		
		System.out.println("TrickTests finished: " + pass + " pass(es) & " + fail + " failure(s).");
	}
	
	private static void CanMakeForestTrick() throws Exception {
		Assert.Print("  CanMakeForestTrick");
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(new FateCard(Realm.forest, Resource.treasure));
		cards.add(new FateCard(Realm.forest, Resource.location));
		cards.add(new FateCard(Realm.forest, Resource.nature));
		cards.add(new FateCard(Realm.forest, Resource.folk));
		Trick trick = new Trick(cards);
		
		Assert.AreEqual(trick.GetTrickType(), TrickType.realm, "Incorrect trick type");
		Assert.AreEqual(trick.GetRealm(), Realm.forest, "Incorrect realm");
		pass++;
	}
	
	private static void CanMakeFolkTrick() throws Exception {
		Assert.Print("  CanMakeFolkTrick");
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(new FateCard(Realm.forest, Resource.folk));
		cards.add(new FateCard(Realm.mountain, Resource.folk));
		cards.add(new FateCard(Realm.desert, Resource.folk));
		Trick trick = new Trick(cards);
		
		Assert.AreEqual(trick.GetTrickType(), TrickType.resource, "Incorrect trick type");
		Assert.AreEqual(trick.GetResource(), Resource.folk, "Incorrect realm");
		pass++;
	}
		
	private static void CanMakeFolkTrickWithWild() throws Exception {
		Assert.Print("  CanMakeFolkTrickWithWild");
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(new FateCard(Realm.forest, Resource.wild));
		cards.add(new FateCard(Realm.mountain, Resource.folk));
		cards.add(new FateCard(Realm.desert, Resource.folk));
		Trick trick = new Trick(cards);
		
		Assert.AreEqual(trick.GetTrickType(), TrickType.resource, "Incorrect trick type");
		Assert.AreEqual(trick.GetResource(), Resource.folk, "Incorrect realm");
		pass++;
	}
			
	private static void CanMakeWildTrick() throws Exception {
		Assert.Print("  CanMakeWildTrick");
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(new FateCard(Realm.forest, Resource.wild));
		cards.add(new FateCard(Realm.mountain, Resource.wild));
		cards.add(new FateCard(Realm.desert, Resource.wild));
		cards.add(new FateCard(Realm.coast, Resource.wild));
		cards.add(new FateCard(Realm.city, Resource.wild));
		Trick trick = new Trick(cards);
		
		Assert.AreEqual(trick.GetTrickType(), TrickType.resource, "Incorrect trick type");
		Assert.AreEqual(trick.GetResource(), Resource.wild, "Incorrect realm");
		pass++;
	}
	
	private static void CantMakeTrickWithTwo() throws Exception {
		Assert.Print("  Can'tMakeTrickWithTwo");
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(new FateCard(Realm.forest, Resource.wild));
		cards.add(new FateCard(Realm.mountain, Resource.folk));
		
		boolean exceptionThrown = false;
		try {
			Trick trick = new Trick(cards);
		} catch (java.lang.IllegalArgumentException ex) {
			exceptionThrown = true;
		}
		Assert.IsTrue(exceptionThrown, "Invalid trick accepted as valid");
		pass++;
	}
		
	private static void CantMakeTrickWithIdenticalCards() throws Exception {
		Assert.Print("  Can'tMakeTrickWithIdenticalCards");
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(new FateCard(Realm.forest, Resource.wild));
		cards.add(new FateCard(Realm.mountain, Resource.folk));
		cards.add(new FateCard(Realm.mountain, Resource.folk));
		
		boolean exceptionThrown = false;
		try {
			Trick trick = new Trick(cards);
		} catch (java.lang.IllegalArgumentException ex) {
			exceptionThrown = true;
		}
		Assert.IsTrue(exceptionThrown, "Invalid trick accepted as valid");
		pass++;
	}
	
}