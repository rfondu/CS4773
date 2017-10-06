package game;

import java.util.ArrayList;

import deck.Card;
import player.Player;
import player.PlayerPoints;

public class GameType {
	ArrayList<Card> inPlay = new ArrayList<Card>(); 
	ArrayList<Player> players;
	public void roundStart (ArrayList<Player> players) {
		this.players = players;
		cardPlayed();	
	}
	
	public void cardPlayed() {
		inPlay.add(players.get(0).drawCard());     			// Player 1 draws a card
		inPlay.add(players.get(1).drawCard());				// Player 2 draws a card
		warGame.Output.cardPlayedPrint(players, inPlay); 	// Sends players and inPlay arrays data to be printed
		compareCards();										// Comparison of the 2 cards
	}
	
	public void compareCards () {
		int numberCardPlayed = inPlay.size(); 				// get how many cards are in the inPlay array currently
		if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() > inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			warGame.Output.roundWinnerPrint(players.get(0).getName());	// Player 1 won send to print the good news
			
			// Count size of in play array and assign points to player 1 int scoreValue OR player 1 unused hand array
			PlayerPoints.setPoints(numberCardPlayed);		// Give points to player 1      **** MAY NEED ANOTHER PARAMETER FOR PLAYER TO ASSIGN POINTS TO ***
			roundEnd();										// Somebody won!  Round will end!
		} else if (inPlay.get(numberCardPlayed - 2).getValue().getCardValue() < inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			warGame.Output.roundWinnerPrint(players.get(1).getName());	// Player 2 won send to print the good news
			// Count size of in play array and assign points to player 2 int scoreValue OR player 2 unused hand array
			PlayerPoints.setPoints(numberCardPlayed);		// Give points to player 2		**** MAY NEED ANOTHER PARAMETER FOR PLAYER TO ASSIGN POINTS TO ***
			roundEnd();										// Somebody won!  Round will end!
		} else {
			warGame.Output.warPrint();						// Print to the console there was a WAR!!!
			inPlay.add(players.get(0).drawCard());			// Player 1 places a card face down
			inPlay.add(players.get(1).drawCard());			// Player 2 places a card face down
			cardPlayed();									// Go back to cardPlayed() because there was a war!
		}
	}

	public void roundEnd() {
		warGame.Output.playersScorePrint(players);
	}

}
