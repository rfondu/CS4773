package player;

import java.util.ArrayList;

import deck.Card;

public class PlayerType1 extends Player{
	
	private ArrayList<Card> winPile;

	public PlayerType1(String name, ArrayList<Card> downPile) {
		super(name, downPile);
		// TODO Auto-generated constructor stub
	}
	
	public void setWinPile(ArrayList<Card> pile){
		this.winPile = pile;
	}
	
	public int pointCount(){
		return winPile.size();
	}
}
