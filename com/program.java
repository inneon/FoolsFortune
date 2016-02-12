package com;

import java.util.ArrayList;
import com.world.*;

public class program {

  public static void main(String[] args) {
    System.out.println("Hello world!");
	FateCard card = new FateCard(Realm.forest, Resource.folk);
	ArrayList<FateCard> cards = new ArrayList<FateCard>();
	cards.add(new FateCard(Realm.city, Resource.wild));
	cards.add(new FateCard(Realm.coast, Resource.wild));
	cards.add(new FateCard(Realm.mountain, Resource.wild));
	cards.add(new FateCard(Realm.forest, Resource.folk));
	Trick t1 = new Trick(cards);
	System.out.println(t1.Printable(0));
	System.out.println(t1.GetTrickType());
	System.out.println(t1.GetRealm());
	System.out.println(t1.GetResource());
  }
} 
