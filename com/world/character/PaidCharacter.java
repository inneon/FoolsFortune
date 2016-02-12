package com.world.character;

import java.util.ArrayList;
import java.util.List;

import com.world.*;
import com.world.character.CharacterCard;

public class PaidCharacter extends Printable {
	private FateCard fee1;
	private FateCard fee2;
	private CharacterCard character;
	private PaidCharacterStatus status;
	
	public PaidCharacter (CharacterCard character, FateCard fee1, FateCard fee2) {
		if (character == null) throw new java.lang.IllegalArgumentException("Character card is null");
		if (fee1 == null) throw new java.lang.IllegalArgumentException("Fee1 is null");
		if (fee2 == null) throw new java.lang.IllegalArgumentException("Fee2 is null");
		
		this.character = character;
		this.fee1 = fee1;
		this.fee2 = fee2;
		this.status = PaidCharacterStatus.engaged;
	}
	
	public String Printable (int depth) {
		String result = GetPadding(depth) + "Character: {\n"
			+ character.Printable(depth + 1) + " : " + status + "\n"
			+ (fee1 != null ? fee1.Printable(depth + 1) : GetPadding(depth + 1) + "<<Unpaid>>") + "\n"
			+ (fee2 != null ? fee2.Printable(depth + 1) : GetPadding(depth + 1) + "<<Unpaid>>") + "\n"
		+ GetPadding(depth) + "}";
		return result;
	}	

	public CharacterCard GetCharacterCard() {
		return character;
	}
	
	public List<FateCard> GetFees() {
		ArrayList<FateCard> result = new ArrayList<FateCard>();
		
		if (fee1 != null) {
			result.add(fee1);
		}
		if (fee2 != null) {
			result.add(fee2);
		}
		
		return result;
	}
	
	public PaidCharacterStatus GetStatus() {
		return status;
	}
	
	public void SetStatus(PaidCharacterStatus status) {
		this.status = status;
	}
}
