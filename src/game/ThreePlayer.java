package game;

import java.util.ArrayList;

import deck.Card;
import player.Player;
import player.PlayerPoints;
import warGame.Output;

public class ThreePlayer implements InterfaceGameType{
	ArrayList<Card> inPlay = new ArrayList<Card>(); 
	ArrayList<Player> players;
	int points = 0;
	Player winner;
	
	public void roundStart (ArrayList<Player> players) {
		this.players = players;
		cardPlayed();	
	}
	
	public void cardPlayed() {
		//check downPile for each player
		if(players.get(0).getDownPile().size() == 0) {
			endGame();
			return;
		}
		inPlay.add(players.get(0).drawCard());     			// Player 1 draws a card
		inPlay.add(players.get(1).drawCard());				// Player 2 draws a card
		inPlay.add(players.get(2).drawCard());				// Player 2 draws a card
		Output.cardPlayedPrint(players, inPlay); 	// Sends players and inPlay arrays data to be printed
		compareCards();										// Comparison of the 2 cards
	}
	
	public void compareCards() {
		int numberCardPlayed = inPlay.size(); 				// get how many cards are in the inPlay array currently
		if(inPlay.get(numberCardPlayed - 3).getValue().getCardValue() > inPlay.get(numberCardPlayed - 2).getValue().getCardValue()) {
			if(inPlay.get(numberCardPlayed - 3).getValue().getCardValue() > inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
				Innards(0);
			}else {
				Innards(2);
			}
		}else if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() > inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			Innards(1);
		} else if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() < inPlay.get(numberCardPlayed - 1).getValue().getCardValue()){
			Innards(2);
		} else {
			war();
		}
	}
	
	public void war() {
		Output.warPrint();						// Print to the console there was a WAR!!!
		if(players.get(0).getDownPile().size() == 0) {
			Output.playersPointsScorePrint(players);
			endGame();
			return;
		}
		inPlay.add(players.get(0).drawCard());			// Player 1 places a card face down
		inPlay.add(players.get(1).drawCard());			// Player 2 places a card face down
		inPlay.add(players.get(2).drawCard());			// Player 3 places a card face down
		cardPlayed();									// Go back to cardPlayed() because there was a war!
	}
	
	public void Innards(int player) {
		Output.roundWinnerPrint(players.get(player).getName());	// Player 1 won send to print the good news
		// Count size of in play array and assign points to player 1 int scoreValue OR player 1 unused hand array
		((PlayerPoints)(players.get(player))).setPoints(inPlay.size());		// Give points to player 1     
		roundEnd(); // Player 1 won!  Round will end!
		return;
	}

	public void roundEnd() {
		inPlay.clear();
		Output.playersPointsScorePrint(players);
		cardPlayed();
	}
	
	public void endGame() {
		if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(1)).getPoints()) {
			if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(2)).getPoints()) {
				Output.gameWinnerPrint(players.get(0).getName());
				setWinner(players.get(0));
			}else {
				Output.gameWinnerPrint(players.get(2).getName());
				setWinner(players.get(2));
			}
		}else if (((PlayerPoints)players.get(1)).getPoints() > ((PlayerPoints)players.get(2)).getPoints()){
			Output.gameWinnerPrint(players.get(1).getName());
			setWinner(players.get(1));
		}else {
			Output.gameWinnerPrint(players.get(2).getName());
			setWinner(players.get(2));
		}
	}

	@Override
	public Player getWinner() {
		return winner;
	}

	@Override
	public void setWinner(Player player) {
		winner = player;
	}

}