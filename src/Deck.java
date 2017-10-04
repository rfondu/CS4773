package warGame;

import java.util.ArrayList;

public class Deck {
	
	public Deck() {
		ArrayList<Card> cardDeck = new ArrayList<Card>();
		
		for(SUIT suit: SUIT.values()) {
			for(VALUE value: VALUE.values()) {
				cardDeck.add(new Card(value, suit));				
			}
		}
		// TEMP just to see what's in the arraylist
		for(Card c: cardDeck) {	
			System.out.println("Suit " + c.getSuit() + " value " + c.getValue() + "\n");
		}
	}

}
