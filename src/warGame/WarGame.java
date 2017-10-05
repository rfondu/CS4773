package warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import deck.Card;
import deck.Deck;
import player.Player;
import player.PlayerPoints;
import player.PlayerContinuous;

public class WarGame {
	
	private static int gameType;

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		
		Intro();
		Deck deck = new Deck();
		deck.NormalDeck();
		deck.Shuffle();
		//Player initialization
		playerSetup(players);
		DistributeCards(deck, players);
		Start(players);
	}
	
	public static void Intro() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to\n");
		System.out.println("*************");
		System.out.println("* War Game! *");
		System.out.println("*************\n");	
		
		do {
	    	System.out.println("Select War Game Variation: \n");
			System.out.println("1) 2 Players - Won Cards Go Back to Winning Players Deck.  Game Ends After a Set Number of Turns.");
			System.out.println("2) 2 Players - Won Cards Go to Winning Players Points Pile.  Game Ends After All Cards Played Once.");
			System.out.println("3) 3 Players - Won Cards Go to Winning Players Points Pile.  Game Ends After All Cards Played Once.");
	    	
			if(input.hasNextInt())
	    		gameType = input.nextInt();
	    	else {
	    		System.out.println("You must enter a number 1-3");
	    		input.next();
	    	}
		} while (gameType > 3 || gameType < 1);
		input.close();
	}
		
	public static void Start(ArrayList<Player> players) {
		if(gameType == 1) {
			game.gameType1();
		}
		if(gameType == 2){
			game.gameType2();
		}
		if(gameType == 3) {
			game.gameType3();
		}
	}
	
	public static ArrayList<Player> playerSetup(ArrayList<Player> players) {
		if(gameType == 1) {
			PlayerPoints player1 = new PlayerPoints("Sue");
			PlayerPoints player2 = new PlayerPoints("Bob");
			Collections.addAll(players, player1, player2);
		}
		if(gameType == 2){
			PlayerContinuous player1 = new PlayerContinuous("Sue");
			PlayerContinuous player2 = new PlayerContinuous("Bob");
			Collections.addAll(players, player1, player2);
		}
		if(gameType == 3) {
			PlayerPoints player1 = new PlayerPoints("Sue");
			PlayerPoints player2 = new PlayerPoints("Bob");
			PlayerPoints player3 = new PlayerPoints("Tom");
			Collections.addAll(players, player1, player2, player3);
		}
		return players;
	}
	
	public static void DistributeCards(Deck deck, ArrayList<Player> players) {
		int split = deck.getDeck().size() / players.size();
		for(int j = 0; j < players.size(); j++) {
			for(int i = 0; i < split; i++) {
				Card card = deck.getDeck().remove(i);
				players.get(j).addCard(card);
			}
		}
	}

}