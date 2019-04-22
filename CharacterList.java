package fightinggame;

import java.util.ArrayList;

public class CharacterList {
	
	ArrayList<Character> characterList = new ArrayList<Character>();
	
	public CharacterList() {
		Loki loki = new Loki();
		characterList.add(loki);
		
		Zeus zeus = new Zeus();
		characterList.add(zeus);
	}

	public ArrayList<Character> getCharacterList() {
		return characterList;
	}
}
