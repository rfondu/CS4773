package player;

import java.util.ArrayList;

import deck.Card;

public class PlayerPoints extends Player{
	
	private ArrayList<Card> winPile;

	public PlayerPoints(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void setWinPile(ArrayList<Card> pile){
		this.winPile = pile;
	}
	
	public int pointCount(){
		return winPile.size();
	}
}
