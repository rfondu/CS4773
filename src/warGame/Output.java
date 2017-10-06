package warGame;

import java.util.ArrayList;

import deck.Card;
import player.Player;
import player.PlayerPoints;

public class Output {
	
	public static void introductionPrint(){
		System.out.println("Welcome to\n");
		System.out.println("*************");
		System.out.println("* War Game! *");
		System.out.println("*************\n");	
	}
	
	public static void variationInformationPrint(){
    	System.out.println("Select War Game Variation: \n");
		System.out.println("1) 2 Players - Won Cards Go Back to Winning Players Deck.  Game Ends After a Set Number of Turns.");
		System.out.println("2) 2 Players - Won Cards Go to Winning Players Points Pile.  Game Ends After All Cards Played Once.");
		System.out.println("3) 3 Players - Won Cards Go to Winning Players Points Pile.  Game Ends After All Cards Played Once.");
	}
	
	public static void selectionErrorPrint(){
		System.out.println("You must enter a number 1-3");		
	}
	
	public static void cardPlayedPrint(ArrayList<Player> players, ArrayList<Card> inPlay){
		int lastCardPlayed = inPlay.size();
		for (int i = 0, j = players.size(); i < players.size(); i++, j--) {
			System.out.println(players.get(i).getName() + " plays " + inPlay.get(lastCardPlayed-j).getValue() + " of " + inPlay.get(lastCardPlayed-j).getSuit() + " as up card ");
		  //System.out.println(players.get(1).getName() + " plays " + inPlay.get(lastCardPlayed-1).getValue() + " of " + inPlay.get(lastCardPlayed-1).getSuit() + " as up card ");
		}
	}
	
	public static void playersScorePrint(ArrayList<Player> players){

		System.out.print("Score is "); 
		String fencePost = ",";		
		for(Player p: players) {
			if(players.indexOf(p) == players.size()-1){
				fencePost = " ";
			}
			System.out.print(p.getName() + " " + ((PlayerPoints) p).getPoints() + fencePost + " ");  																		
		}
		System.out.println("\n");
	}
	
	public static void warPrint(){
		System.out.println("WAR !\n");
	}
	
	public static void roundWinnerPrint(String winnerName){
		System.out.println(winnerName + " wins the round");
	}
	
	public static void gameWinnerPrint(String winnerName){	
		System.out.println(winnerName + " wins the game!");
	}
	
	public static void tieGamePrint(){	
		System.out.println("Tie game!");
	}
}