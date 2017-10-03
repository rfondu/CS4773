import java.util.ArrayList;

public class Deck {
	
	public Deck() {
		ArrayList cardDeck = new ArrayList();
		
		for(int i = 0; i <= 4; i++) {
			for(int j = 0; j <= 13; j++) {
				Card card = new Card (VALUE.values(j), SUIT.values(i));
				cardDeck.add(card);				
			}
		}
	}

}
