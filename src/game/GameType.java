package game;

import deck.Card;
import deck.SUIT;
import deck.VALUE;

public class GameType {

	public void Round (Player player1, Player player2) {
		PlayCards(player1.drawCard, player2.drawCard);	
	}
	
	public void PlayCards(Card player1Card, Card player2Card) {
		// Call Print class to say what cards are being played by players
		CompareCards(player1Card, player2Card);
	}
	
	public void CompareCards (Card player1Card, Card player2Card) {		
		if(player1Card.getValue().getCardValue() > player2Card.getValue().getCardValue()) {
			System.out.println("WE GOT HERE PLAYER 1 WON!");
			// Count size of in play array and assign points to player 1 int scoreValue OR player 1 unused hand array
			RoundEnd();
		} else if (player1Card.getValue().getCardValue() < player2Card.getValue().getCardValue()) {
			System.out.println("WE GOT HERE PLAYER 2 WON!");
			// Count size of in play array and assign points to player 2 int scoreValue OR player 2 unused hand array
			RoundEnd();
		} else {
			System.out.println("WAR!");
			// Print class to say TIE and WAR!
			// Place one down card for each player and call PlayCards() to get another up card for each player
		}
	}

	public void War() {
		// May not need this function
	}
	
	public void RoundEnd() {
		// Print Class to say what player won!
	}

}