package game;

import java.util.ArrayList;

import deck.Card;
import player.Player;
import player.PlayerPoints;
import warGame.Output;

public class ThreePlayer implements InterfaceGameType{
	ArrayList<Card> inPlay = new ArrayList<Card>(); 
	ArrayList<Player> players;
	Player winner;
	
	public void startRound (ArrayList<Player> players) {
		this.players = players;
		playCards();	
	}
	
	public void playCards() {
		//check downPile for each player
		if(players.get(0).getDownPile().size() == 0) {
			roundWinner();
			return;
		}
		inPlay.add(players.get(0).drawCard());     			// Player 1 draws a card
		inPlay.add(players.get(1).drawCard());				// Player 2 draws a card
		inPlay.add(players.get(2).drawCard());				// Player 2 draws a card
		Output.playedCardPrint(players, inPlay); 	// Sends players and inPlay arrays data to be printed
		compareCards();										// Comparison of the 2 cards
	}
	
	public void compareCards() {
		int numberCardPlayed = inPlay.size(); 				// get how many cards are in the inPlay array currently
		if(inPlay.get(numberCardPlayed - 3).getValue().getCardValue() > inPlay.get(numberCardPlayed - 2).getValue().getCardValue()) {
			if(inPlay.get(numberCardPlayed - 3).getValue().getCardValue() > inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
				endRound(0);
			}else if(inPlay.get(numberCardPlayed - 3).getValue().getCardValue() < inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
				endRound(2);
			} else
				war();
		}else if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() > inPlay.get(numberCardPlayed - 1).getValue().getCardValue()) {
			if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() > inPlay.get(numberCardPlayed - 3).getValue().getCardValue()) {
				endRound(1);
			} else
				war();
		} else if(inPlay.get(numberCardPlayed - 2).getValue().getCardValue() < inPlay.get(numberCardPlayed - 1).getValue().getCardValue())
			endRound(2);
		else 
			war();
	}
	
	public void war() {
		Output.warPrint();						// Print to the console there was a WAR!!!
		if(players.get(0).getDownPile().size() == 0) {
			Output.printScorePointsPlayers(players);
			roundWinner();
			return;
		}
		inPlay.add(players.get(0).drawCard());			// Player 1 places a card face down
		inPlay.add(players.get(1).drawCard());			// Player 2 places a card face down
		inPlay.add(players.get(2).drawCard());			// Player 3 places a card face down
		playCards();									// Go back to cardPlayed() because there was a war!
	}
	
	public void endRound(int player) {
		Output.roundWinnerPrint(players.get(player).getName());	// Player 1 won send to print the good news
		// Count size of in play array and assign points to player 1 int scoreValue OR player 1 unused hand array
		((PlayerPoints)(players.get(player))).setPoints(inPlay.size());		// Give points to player 1     
		nextRoundSetup(); // Player 1 won!  Round will end!
		return;
	}

	public void nextRoundSetup() {
		inPlay.clear();
		Output.printScorePointsPlayers(players);
		playCards();
	}
	
	public void roundWinner() {
		if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(1)).getPoints()) {
			if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(2)).getPoints()) {
				declareWinner(0);
			}else if(((PlayerPoints)players.get(0)).getPoints() == ((PlayerPoints)players.get(2)).getPoints()){
				Output.tieGamePrint();
			}else {
				declareWinner(2);
			}
		}else if(((PlayerPoints)players.get(0)).getPoints() == ((PlayerPoints)players.get(1)).getPoints()){
			if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(2)).getPoints()) {
				Output.tieGamePrint();
			}else {
				declareWinner(2);
			}
		}else if (((PlayerPoints)players.get(1)).getPoints() > ((PlayerPoints)players.get(2)).getPoints()){
			declareWinner(1);
		}else if (((PlayerPoints)players.get(1)).getPoints() == ((PlayerPoints)players.get(2)).getPoints()){
			Output.tieGamePrint();
		}else {
			declareWinner(2);
		}
	}
	
	public void declareWinner(int player) {
		Output.gameWinnerPrint(players.get(player).getName());
		setWinner(players.get(player));
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