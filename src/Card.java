import java.util.Random;

public class Card {
	
	private VALUE value;
	private SUIT suit;
	
	public Card (VALUE value, SUIT suit) {
		if(value == null || value.equals(value.RANDOM)) {			
			this.value = getNewValue(value);
		} else 
			this.value = value;
		if(suit == null || suit.equals(suit.RANDOM)) {
			this.suit = getNewSuit(suit);
		} else 
			this.suit = suit;
	}
	
	 public SUIT getSuit(){
	    return suit;
	  }
	 
	 public void setSuit(SUIT suit){
	    this.suit = suit;
	  }
	 
	 public VALUE getValue() {
	    return value;
	  }
	 
	 public void setValue(VALUE value){
	    this.value = value;
	  }
	 
	 public VALUE getNewValue (VALUE newValue) {
		Random randomNumber = new Random();
		int newCard = randomNumber.nextInt(13) + 2;
		if(newCard == 2) {
			newValue = newValue.TWO;
			return newValue;
		} else if (newCard == 3) {
			newValue = newValue.THREE;
			return newValue;			
		} else if (newCard == 4) {
			newValue = newValue.FOUR;
			return newValue;			
		} else if (newCard == 5) {
			newValue = newValue.FIVE;
			return newValue;			
		} else if (newCard == 6) {
			newValue = newValue.SIX;
			return newValue;			
		} else if (newCard == 7) {
			newValue = newValue.SEVEN;
			return newValue;			
		} else if (newCard == 8) {
			newValue = newValue.EIGHT;
			return newValue;			
		} else if (newCard == 9) {
			newValue = newValue.NINE;
			return newValue;			
		} else if (newCard == 10) {
			newValue = newValue.TEN;
			return newValue;			
		} else if (newCard == 11) {
			newValue = newValue.JACK;
			return newValue;			
		} else if (newCard == 12) {
			newValue = newValue.QUEEN;
			return newValue;			
		} else if (newCard == 13) {
			newValue = newValue.KING;
			return newValue;			
		} else if (newCard == 14) {
			newValue = newValue.ACE;
			return newValue;			
		}
		return newValue;
	 }
	 
	 public SUIT getNewSuit (SUIT newSuit) {
		 Random randomNumber = new Random();
		 int newCard = randomNumber.nextInt(4) + 1;
		if(newCard == 1) {
			newSuit = newSuit.SPADES;
			return newSuit;
		} else if (newCard == 2) {
			newSuit = newSuit.HEARTS;
			return newSuit;			
		} else if (newCard == 3) {
			newSuit = newSuit.CLUBS;
			return newSuit;			
		} else if (newCard == 4) {
			newSuit = newSuit.DIAMONDS;
			return newSuit;
		}
		return newSuit;		 		 
	}
}