package com.world;

import java.util.*;

public class Trick extends FateCardCollection {
	private TrickType trickType;
	private Realm realm;
	private Resource resource;
	
	public Trick(ArrayList<FateCard> initialCards) {
		if (initialCards == null || initialCards.size() == 0) throw new java.lang.IllegalArgumentException("cards is null or empty");
		if (!Validate(initialCards)) throw new java.lang.IllegalArgumentException("cards do not make a valid trick");
		
		for (FateCard card : initialCards) {
			cards.add(card);
		}
	}
	
	protected boolean Validate(ArrayList<FateCard> cards) {
		boolean result = 3 <= cards.size() && cards.size() <= 5;
		boolean allRealmsMatch = true;
		Realm candidateRealm = cards.get(0).GetRealm();
		boolean allResourcesMatch = true;
		Resource candidateResource = cards.get(0).GetResource();
		
		for (int i = 1; i < cards.size() && result; i++) {
			allRealmsMatch &= cards.get(i).GetRealm() == candidateRealm;
			allResourcesMatch &= (cards.get(i).GetResource() == candidateResource
				|| cards.get(i).GetResource() == Resource.wild
				|| candidateResource == Resource.wild);
			if (candidateResource == Resource.wild) 
				candidateResource = cards.get(i).GetResource();
			result &= (allRealmsMatch || allResourcesMatch);
			
			for (int j = i+1; j < cards.size() && result; j++) {
				boolean identical = cards.get(i).GetRealm() == cards.get(j).GetRealm()
					&& cards.get(i).GetResource() == cards.get(j).GetResource();
				result &= ! identical;
			}
		}
		
		if (allRealmsMatch) { 
			trickType = TrickType.realm;
			realm = candidateRealm;
		}
		if (allResourcesMatch) {
			trickType = TrickType.resource;
			resource = candidateResource;
		}
		
		return result;
	}
	
	public void Add(FateCard card) {
		if (!CanAddCard(card)) {
			throw new java.lang.IllegalArgumentException("card cannot be added");
		}
		cards.add(card);
	}
	
	public boolean CanAddCard(FateCard card) {
		boolean result = false;
			
		if (trickType == TrickType.realm
			&& GetRealm() == card.GetRealm()) {
			result = true;
		} else if (trickType == TrickType.resource
			&& (GetResource() == card.GetResource()
				|| card.GetResource() == Resource.wild
				|| GetResource() == Resource.wild)) {
			result = true;
		}
			
		result &= !Contains(card);
		return result;
	}
	
	public TrickType GetTrickType() {
		return trickType;
	}
	
	public Realm GetRealm() {
		if (trickType != TrickType.realm) throw new java.lang.UnsupportedOperationException("This is not a realm based trick");
		return realm;
	}
	
	public Resource GetResource() {
		if (trickType != TrickType.resource) throw new java.lang.UnsupportedOperationException("This is not a resource based trick");
		return resource;
	}
	
	public Collection<FateCard> GetCards() {
		return cards;
	}
	
	private boolean Contains(FateCard card) {
		boolean result = false;
		for(FateCard c : cards) {
			result |= card.GetRealm() == c.GetRealm() && card.GetResource() == c.GetResource();
		}
		return result;
	}
	
	public String Printable (int depth) {
		String result = super.Printable(depth);
		result += " " + trickType + " trick in " + (trickType == TrickType.realm ? realm : resource);
		return result;
	}
}
