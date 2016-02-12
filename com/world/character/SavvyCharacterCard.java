package com.world.character;

import com.world.*;
import com.world.character.CharacterCard;

public class SavvyCharacterCard extends CharacterCard {
	private Realm realm;
	private Resource resource;
	private TrickType savvyType;

	public SavvyCharacterCard(Realm realm) {
		if (realm == null) throw new java.lang.IllegalArgumentException("realm is null");
		this.realm = realm;
		savvyType = TrickType.realm;
	}
	
	public SavvyCharacterCard(Resource resource) {
		if (resource == null) throw new java.lang.IllegalArgumentException("resource is null");
		this.resource = resource;
		savvyType = TrickType.resource;
	}
	
	public TrickType GetSavvyType() {
		return savvyType;
	}
	
	public Realm GetRealm() {
		if (savvyType == TrickType.resource) throw new java.lang.UnsupportedOperationException("This character is not savvy to a realm");
		return realm;
	}
	
	public Resource GetResource() {
		if (savvyType == TrickType.realm) throw new java.lang.UnsupportedOperationException("This character is not savvy to a resource");
		return resource;
	}
	
	public String Printable(int depth) {
		String result = GetPadding(depth) + "Savvy Character, savvy to ";
		if (savvyType == TrickType.realm) {
			result += realm;
		} else {
			result += resource;
		}
		return result;
	}
}
