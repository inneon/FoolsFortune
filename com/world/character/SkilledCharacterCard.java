package com.world.character;

import com.world.*;
import com.world.character.CharacterCard;

public class SkilledCharacterCard extends CharacterCard {
	
	private Realm realm;
	private Resource resource;

	public SkilledCharacterCard(Realm realm, Resource resource) {
		if (realm == null) throw new java.lang.IllegalArgumentException("realm is null");
		if (resource == null) throw new java.lang.IllegalArgumentException("resource is null");
		this.realm = realm;
		this.resource = resource;
	}
	
	public Realm GetRealm() {
		return realm;
	}
	
	public Resource GetResource() {
		return resource;
	}
	
	public String Printable(int depth) {
		String result = GetPadding(depth) + "Skilled Character, alligned to "
			+ realm + " " 
			+ resource;
		return result;
	}
	
}
