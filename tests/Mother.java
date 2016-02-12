package tests;

import java.util.*;
import com.world.*;

public class Mother {

	public static FateCard cityFolk = new FateCard(Realm.city, Resource.folk);
	public static FateCard cityLocation = new FateCard(Realm.city, Resource.location);
	public static FateCard cityNature = new FateCard(Realm.city, Resource.nature);
	public static FateCard citySupernatural = new FateCard(Realm.city, Resource.supernatural);
	public static FateCard cityTreasure = new FateCard(Realm.city, Resource.treasure);
	public static FateCard cityWild = new FateCard(Realm.city, Resource.wild);
	
	public static FateCard coastFolk = new FateCard(Realm.coast, Resource.folk);
	public static FateCard coastLocation = new FateCard(Realm.coast, Resource.location);
	public static FateCard coastNature = new FateCard(Realm.coast, Resource.nature);
	public static FateCard coastSupernatural = new FateCard(Realm.coast, Resource.supernatural);
	public static FateCard coastTreasure = new FateCard(Realm.coast, Resource.treasure);
	public static FateCard coastWild = new FateCard(Realm.coast, Resource.wild);

	public static FateCard desertFolk = new FateCard(Realm.desert, Resource.folk);
	public static FateCard desertLocation = new FateCard(Realm.desert, Resource.location);
	public static FateCard desertNature = new FateCard(Realm.desert, Resource.nature);
	public static FateCard desertSupernatural = new FateCard(Realm.desert, Resource.supernatural);
	public static FateCard desertTreasure = new FateCard(Realm.desert, Resource.treasure);
	public static FateCard desertWild = new FateCard(Realm.desert, Resource.wild);
	
	public static FateCard forestFolk = new FateCard(Realm.forest, Resource.folk);
	public static FateCard forestLocation = new FateCard(Realm.forest, Resource.location);
	public static FateCard forestNature = new FateCard(Realm.forest, Resource.nature);
	public static FateCard forestSupernatural = new FateCard(Realm.forest, Resource.supernatural);
	public static FateCard forestTreasure = new FateCard(Realm.forest, Resource.treasure);
	public static FateCard forestWild = new FateCard(Realm.forest, Resource.wild);
	
	public static FateCard mountainFolk = new FateCard(Realm.mountain, Resource.folk);
	public static FateCard mountainLocation = new FateCard(Realm.mountain, Resource.location);
	public static FateCard mountainNature = new FateCard(Realm.mountain, Resource.nature);
	public static FateCard mountainSupernatural = new FateCard(Realm.mountain, Resource.supernatural);
	public static FateCard mountainTreasure = new FateCard(Realm.mountain, Resource.treasure);
	public static FateCard mountainWild = new FateCard(Realm.mountain, Resource.wild);
	
	public static Trick forestTrick3;
	public static Trick folkTrick3;
	public static Trick wildTrick3;
	
	public static void Initialise() {
		ArrayList<FateCard> cards = new ArrayList<FateCard>();
		cards.add(forestFolk);
		cards.add(forestLocation);
		cards.add(forestNature);
		forestTrick3 = new Trick(cards);
		
		cards = new ArrayList<FateCard>();
		cards.add(cityFolk);
		cards.add(coastFolk);
		cards.add(desertFolk);
		folkTrick3 = new Trick(cards);
				
		cards = new ArrayList<FateCard>();
		cards.add(cityWild);
		cards.add(coastWild);
		cards.add(desertWild);
		wildTrick3 = new Trick(cards);
	}
}
