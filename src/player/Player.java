package player;

import java.util.ArrayList;

import deck.Card;

public class Player {
	
	private String name;
	protected ArrayList<Card> downPile = new ArrayList<Card>();
	
	public Player(String name){
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

	public void addCard(Card card) {
		this.downPile.add(card);
	}
	
	public Card drawCard() {
		return downPile.remove(0);
	}
	
	public void setDownPile(ArrayList<Card> downpile) {
		this.downPile = downpile;
	}
	
}
