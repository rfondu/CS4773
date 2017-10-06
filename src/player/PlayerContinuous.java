package player;

import java.util.ArrayList;

import deck.Card;

public class PlayerContinuous extends Player{

	public PlayerContinuous(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void addToDownPile(ArrayList<Card> pile){
		ArrayList<Card> TempArray = downPile;
		for(int i = 0; i < pile.size(); i++) {
			TempArray.add(pile.get(i));
		}
		setDownPile(TempArray);
	}
	

}