package game;

import java.util.ArrayList;

import player.Player;
import player.PlayerPoints;

public interface InterfaceGameType {
	
	public void roundStart (ArrayList<Player> players);
	public void cardPlayed();
	public void compareCards();
	public void roundEnd();
}
