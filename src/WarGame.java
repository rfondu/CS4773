
public class WarGame {

	public static void main(String[] args) {
		//new Intro();
		//Setup blah = new Setup();
		Card test = new Card(VALUE.RANDOM, null);
		
		System.out.println("Your card is " + test.getValue() + 
				" of " + test.getSuit() + " and is worth " 
				+ test.getValue().getCardValue());
	}
}
