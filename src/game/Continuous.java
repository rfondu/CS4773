package game;

import player.Player;
import player.PlayerContinuous;
import warGame.Output;

public class Continuous extends TwoPlayer{
	int iterations = 20;
	int i = 0;
	
	@Override
	public void points(Player player) {
		((PlayerContinuous)player).addToDownPile(inPlay);
	}
	
	@Override
	public void roundEnd() {
		inPlay.clear();
		Output.playersContinuousScorePrint(players);
		cardPlayed();
	}
	
	@Override
	public void war() {
		Output.warPrint();						// Print to the console there was a WAR!!!
		if(i == iterations || players.get(0).getDownPile().size() == 0 || players.get(1).getDownPile().size() == 0 ) {
			Output.playersContinuousScorePrint(players);
			endGame();
			return;
		}
		inPlay.add(players.get(0).drawCard());			// Player 1 places a card face down
		inPlay.add(players.get(1).drawCard());			// Player 2 places a card face down
		cardPlayed();									// Go back to cardPlayed() because there was a war!
	}
	
	@Override
	public void cardPlayed() {
		//check downPile for each player
		if(i < iterations) {
			if(players.get(0).getDownPile().size() == 0 || players.get(1).getDownPile().size() == 0 ) {
				//call EndGame
				endGame();
				return;
			}
			inPlay.add(players.get(0).drawCard());     			// Player 1 draws a card
			inPlay.add(players.get(1).drawCard());				// Player 2 draws a card
			Output.cardPlayedPrint(players, inPlay); 	// Sends players and inPlay arrays data to be printed
			i++;
			compareCards();										// Comparison of the 2 cards
		}else {
			endGame();
		}
	}
	
	@Override
	public void endGame() {
		if(players.get(0).getDownPile().size() == players.get(1).getDownPile().size()) {
			Output.tieGamePrint();
		}else if(players.get(0).getDownPile().size() > players.get(1).getDownPile().size()) {
			Output.gameWinnerPrint(players.get(0).getName());
			setWinner(players.get(0));
		}else {
			Output.gameWinnerPrint(players.get(1).getName());
			setWinner(players.get(1));
		}
		
	}
	
}
