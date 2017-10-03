
public class WarGame {

	public static void main(String[] args) {
		//new Intro();  // uncomment this before turn in
		//Setup blah = new Setup();  // also uncomment this before turn in
		Card test = new Card(VALUE.ACE, SUIT.SPADES);
		
		System.out.println("Your card is " + test.getValue() + 
				" of " + test.getSuit() + " and is worth " 
				+ test.getValue().getCardValue());
	}
}
