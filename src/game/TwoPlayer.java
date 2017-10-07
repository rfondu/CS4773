package game;

import java.util.ArrayList;

import deck.Card;
import player.Player;
import warGame.Output;

public abstract class TwoPlayer implements InterfaceGameType{
	ArrayList<Card> inPlay = new ArrayList<Card>(); 
	ArrayList<Player> players;
	int points = 0;
	Player Winner = null;
	
	public void roundStart (ArrayList<Player> players) {
		this.players = players;
		cardPlayed();	
	}
	
	public void cardPlayed() {
		//check downPile for each player
		if(players.get(0).getDownPile().size() == 0) {
			//call EndGame
			endGame();
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
			Innards(0);
		} else if (inPlay.get(numberCardPlayed - 2).getValue().getCardValue() < inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			Innards(1);									// Somebody won!  Round will end!
		} else {
			war();
		}
	}
	
	public void Innards(int player) {
		Output.roundWinnerPrint(players.get(player).getName());	// Player 1 won send to print the good news
		// Count size of in play array and assign points to player 1 int scoreValue OR player 1 unused hand array
		points(players.get(player));		// Give points to player 1      **** MAY NEED ANOTHER PARAMETER FOR PLAYER TO ASSIGN POINTS TO ***
		roundEnd();										// Somebody won!  Round will end!
	}
	
	public void war() {
	}

	public void roundEnd() {
	}
	
	public void endGame() {		
	}
	
	public void points(Player player) {
	}
	
	public Player getWinner() {
		return Winner;
	}
	
	public void setWinner(Player player) {
		Winner = player;
	}

}