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
		
		System.out.println(players.get(0).getName() + " plays " + inPlay.get(lastCardPlayed-1).getValue() + " of " + inPlay.get(lastCardPlayed-2).getSuit() + " as up card ");
		System.out.println(players.get(1).getName() + " plays " + inPlay.get(lastCardPlayed).getValue() + " of " + inPlay.get(lastCardPlayed-1).getSuit() + " as up card ");
	}
	
	public static void playersScorePrint(ArrayList<Player> players){
		// need to either pass the score or use array.length to get the score
		// I know it's not correct but the logic is there just need to figure out what will be passed
		
		System.out.println("Score is "); 
		String fencePost = ",";
		int i = 0;
		for(Player p: players) {
			if(i == players.size()-1){
				fencePost = " ";
			}
			System.out.println(p.getName() + " " + ((PlayerPoints) p).getPoints() + fencePost + " ");  // **** How are we going to call points?  PlayerPoints array holds it but we are sending player
			i++;																	 //      we may need to delete PlayerPoints and add its functionality to Player.java.  Thoughts? ****	
		}
		System.out.println("\n");
	}
	
	public static void warPrint(){	
		System.out.println("WAR !\n");
	}
	
	public static void roundWinnerPrint(String winnerName){
		System.out.println(winnerName + " wins the round\n");
	}
	
	public static void gameWinnerPrint(String winnerName){	
		System.out.println(winnerName + " wins the game!\n");
	}
	
	public static void tieGamePrint(){	
		System.out.println("Tie game!\n");
	}
}