package com.world;

import java.util.*;

import com.world.character.*;

public class Stage extends Printable {
	private ArrayList<Trick> cache;
	private FateCardCollection camp;
	private ArrayList<PaidCharacter> crew;

	public Stage() {
		cache = new ArrayList<Trick>();
		camp = new FateCardCollection();
		crew = new ArrayList<PaidCharacter>();
	}

	public String Printable (int depth) {
		String result = GetPadding(depth) + "Cache: { \n";
		for (Trick trick : cache) {
			result += trick.Printable(depth + 1) + "\n";
		}
		result += GetPadding(depth) + "}";
		
		result += GetPadding(depth) + "Camp: { \n" 
			+ camp.Printable(depth + 1) 
			+ "\n}";
			
		result += GetPadding(depth) + "Crew: { \n";
		for (PaidCharacter character : crew) {
			result += character.Printable(depth + 1) + "\n";
		}
		result += GetPadding(depth) + "}";
		
		return result;
	}

	public Collection<Trick> GetCache() {
		return cache;
	}
	
	public Collection<FateCard> GetCamp() {
		return camp.GetCards();
	}
	
	public Collection<PaidCharacter> GetCrew () {
		return crew;
	}
	
  	public void AddToCache(Trick trick) {
		if (trick == null) throw new java.lang.IllegalArgumentException("trick is null");
		
		cache.add(trick);
	}
	
	public void RemoveFromCache(Trick trick) {
		if (trick == null) throw new java.lang.IllegalArgumentException("trick is null");
		
		if (!cache.remove(trick)) {
			throw new java.lang.IllegalArgumentException("Attempted to remove trick " + trick.Printable(0) + " from the camp which was not found");
		}
	}
	
	public void AddToCamp(FateCard card) {
		camp.Add(card);
	}
	
  	public void RemoveFromCamp(FateCard card) {
		camp.Remove(card);
	}
	
	public void AddToCrew(PaidCharacter character) {
		crew.add(character);
	}
	
	public void RemoveFromCrew(PaidCharacter character) {
		crew.remove(character);
	}
	
}
