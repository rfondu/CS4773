package game;

import java.util.ArrayList;

import player.Player;

public interface InterfaceGameType {
	
	public void roundStart (ArrayList<Player> players);
	public void cardPlayed();
	public void compareCards();
	public void roundEnd();
	public Player getWinner();
	public void setWinner(Player player);
}
