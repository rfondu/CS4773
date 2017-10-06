package game;

import java.util.ArrayList;

import deck.Card;
import player.Player;
import player.PlayerPoints;
import warGame.Output;

public class TwoPlayer implements InterfaceGameType{
	ArrayList<Card> inPlay = new ArrayList<Card>(); 
	ArrayList<Player> players;
	int points = 0;
	
	public void roundStart (ArrayList<Player> players) {
		this.players = players;
		cardPlayed();	
	}
	
	public void cardPlayed() {
		//check downPile for each player
		if(players.get(0).getDownPile().size() == 0) {
			//call EndGame
			EndGame();
			return;
		}
		inPlay.add(players.get(0).drawCard());     			// Player 1 draws a card
		inPlay.add(players.get(1).drawCard());				// Player 2 draws a card
		Output.cardPlayedPrint(players, inPlay); 	// Sends players and inPlay arrays data to be printed
		compareCards();										// Comparison of the 2 cards
	}
	
	public void compareCards() {
		int numberCardPlayed = inPlay.size(); 				// get how many cards are in the inPlay array currently
		if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() > inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			Output.roundWinnerPrint(players.get(0).getName());	// Player 1 won send to print the good news
			// Count size of in play array and assign points to player 1 int scoreValue OR player 1 unused hand array
			((PlayerPoints)(players.get(0))).setPoints(numberCardPlayed);		// Give points to player 1      **** MAY NEED ANOTHER PARAMETER FOR PLAYER TO ASSIGN POINTS TO ***
			roundEnd();										// Somebody won!  Round will end!
		} else if (inPlay.get(numberCardPlayed - 2).getValue().getCardValue() < inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			Output.roundWinnerPrint(players.get(1).getName());	// Player 2 won send to print the good news
			// Count size of in play array and assign points to player 2 int scoreValue OR player 2 unused hand array
			((PlayerPoints)players.get(1)).setPoints(numberCardPlayed);		// Give points to player 2		**** MAY NEED ANOTHER PARAMETER FOR PLAYER TO ASSIGN POINTS TO ***
			roundEnd();										// Somebody won!  Round will end!
		} else {
			Output.warPrint();						// Print to the console there was a WAR!!!
			if(inPlay.size() > 0) {
				Output.playersScorePrint(players);
				EndGame();
			}
			inPlay.add(players.get(0).drawCard());			// Player 1 places a card face down
			inPlay.add(players.get(1).drawCard());			// Player 2 places a card face down
			cardPlayed();									// Go back to cardPlayed() because there was a war!
		}
	}

	public void roundEnd() {
		inPlay.clear();
		Output.playersScorePrint(players);
		cardPlayed();
	}
	
	public void EndGame() {
		if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(1)).getPoints()) {
			Output.gameWinnerPrint(players.get(0).getName());
		}else {
			Output.gameWinnerPrint(players.get(1).getName());
		}
		
	}

}