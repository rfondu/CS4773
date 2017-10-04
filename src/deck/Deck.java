package deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		deck = new ArrayList<Card>();
	}
	
	public void NormalDeck(){
		for(SUIT suit: SUIT.values()) {
			for(VALUE value: VALUE.values()) {
				deck.add(new Card(value, suit));				
			}
		}
	}

	public void addCardToDeck(Card card) {	
		deck.add(card);
	}

	public void Shuffle() {
		Collections.shuffle(deck);
	}

}
