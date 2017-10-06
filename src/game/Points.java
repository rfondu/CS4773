package game;

import player.Player;
import player.PlayerPoints;
import warGame.Output;

public class Points extends TwoPlayer{
	
	@Override
	public void points(Player player) {
		((PlayerPoints)player).setPoints(inPlay.size());
	}
	
	@Override
	public void roundEnd() {
		inPlay.clear();
		Output.playersPointsScorePrint(players);
		cardPlayed();
	}
	
	@Override
	public void endGame() {
		if(((PlayerPoints)players.get(0)).getPoints() == ((PlayerPoints)players.get(1)).getPoints()) {
			Output.tieGamePrint();
		}else if(((PlayerPoints)players.get(0)).getPoints() > ((PlayerPoints)players.get(1)).getPoints()) {
			Output.gameWinnerPrint(players.get(0).getName());
			setWinner(players.get(0));
		}else {
			Output.gameWinnerPrint(players.get(1).getName());
			setWinner(players.get(1));
		}
		
	}
	
	@Override
	public void war() {
		Output.warPrint();						// Print to the console there was a WAR!!!
		if(players.get(0).getDownPile().size() == 0) {
			Output.playersPointsScorePrint(players);
			endGame();
			return;
		}
		inPlay.add(players.get(0).drawCard());			// Player 1 places a card face down
		inPlay.add(players.get(1).drawCard());			// Player 2 places a card face down
		cardPlayed();									// Go back to cardPlayed() because there was a war!
	}
}
