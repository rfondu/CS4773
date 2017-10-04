package deck;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
	}

	public void addCardToDeck(Card card) {	
		deck.add(card);
	}

	public static void Shuffle() {
		
	}

}
