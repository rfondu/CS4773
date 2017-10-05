package deck;

public class Card{
	
	private VALUE value;
	private SUIT suit;
	
	public Card (VALUE value, SUIT suit) {
			this.value = value;
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
	
	//TODO
	public String toString(){
		return null;
	}
	
}