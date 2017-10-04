package player;

import java.util.ArrayList;

import deck.Card;

public class PlayerType2 extends Player{
	
	private ArrayList<Card> winPile;

	public PlayerType2(String name, ArrayList<Card> downPile) {
		super(name, downPile);
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