package tests.world.character;

import java.lang.Exception;
import java.util.ArrayList;
import com.world.*;
import com.world.character.*;
import tests.Assert;

public class SavvyCharacterCardTests {
	
	public static int pass = 0;
	public static int fail = 0;
	
	public static void AllTests() {
		System.out.println("SavvyCharacterCardTests started.");
		try {CanCreateSavvyRealmCharacter();} catch (Exception e) {fail++;}
		try {CanCreateSavvyResourceCharacter();} catch (Exception e) {fail++;}
		
		System.out.println("SavvyCharacterCardTests finished: " + pass + " pass(es) & " + fail + " failure(s).");
	}
	
	private static void CanCreateSavvyRealmCharacter() throws Exception {
		Assert.Print("  CanCreateSavvyRealmCharacter");
		SavvyCharacterCard card = new SavvyCharacterCard(Realm.city);
		
		Assert.AreEqual(card.GetSavvyType(), TrickType.realm, "Incorrect savvy type");
		Assert.AreEqual(card.GetRealm(), Realm.city, "Incorrect realm");
		boolean throwsException = false;		
		try {
			card.GetResource();
		} catch (java.lang.UnsupportedOperationException e) {
			throwsException = true;
		}
		Assert.IsTrue(throwsException, "Getting the resource should be unsupported");
		
		pass++;
	}
		
	private static void CanCreateSavvyResourceCharacter() throws Exception {
		Assert.Print("  CanCreateSavvyResourceCharacter");
		SavvyCharacterCard card = new SavvyCharacterCard(Resource.folk);
		
		Assert.AreEqual(card.GetSavvyType(), TrickType.resource, "Incorrect savvy type");
		Assert.AreEqual(card.GetResource(), Resource.folk, "Incorrect resource");
		boolean throwsException = false;		
		try {
			card.GetRealm();
		} catch (java.lang.UnsupportedOperationException e) {
			throwsException = true;
		}
		Assert.IsTrue(throwsException, "Getting the realm should be unsupported");
		
		pass++;
	}
}