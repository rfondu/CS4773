package player;

import java.util.ArrayList;

import deck.Card;

public class Player {
	
	private String name;
	protected ArrayList<Card> downPile;
	
	public Player(String name, ArrayList<Card> downPile){
		this.setDownPile(downPile);
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getDownPile() {
		return downPile;
	}

	public void setDownPile(ArrayList<Card> downPile) {
		this.downPile = downPile;
	}
	
	public Card drawCard() {
		return downPile.get(0);
	}
}
