package warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import deck.Card;
import deck.Deck;
import game.TwoPlayer;
import player.Player;
import player.PlayerPoints;
import player.PlayerContinuous;

public class WarGame {
	
	private static int gameType;

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		
		intro();
		Deck deck = new Deck();
		deck.normalDeck();
		deck.shuffle();
		playerSetup(players);
		distributeCards(deck, players);
		startGame(players);
		System.out.println("Finished");
	}
	
	public static void intro() {
		Scanner input = new Scanner(System.in);
		Output.introductionPrint();
		
		do {
			Output.variationInformationPrint();

			if(input.hasNextInt())
	    		gameType = input.nextInt();
	    	else {
	    		Output.selectionErrorPrint();
	    		input.next();
	    	}
		} while (gameType > 3 || gameType < 1);
		input.close();
	}
		
	public static void startGame(ArrayList<Player> players) {
		game.InterfaceGameType war = new TwoPlayer();
		war.roundStart(players);
		/*if(gameType == 1) {
			game.gameType1();
		}
		if(gameType == 2){
			game.gameType2();
		}
		if(gameType == 3) {
			game.gameType3();
		}*/
	}
	
	public static void playerSetup(ArrayList<Player> players) {
		if(gameType == 1){
			PlayerContinuous player1 = new PlayerContinuous("Sue");
			PlayerContinuous player2 = new PlayerContinuous("Bob");
			Collections.addAll(players, player1, player2);
		}
		if(gameType == 2) {
			PlayerPoints player1 = new PlayerPoints("Sue");
			PlayerPoints player2 = new PlayerPoints("Bob");
			Collections.addAll(players, player1, player2);
		}
		if(gameType == 3) {
			PlayerPoints player1 = new PlayerPoints("Sue");
			PlayerPoints player2 = new PlayerPoints("Bob");
			PlayerPoints player3 = new PlayerPoints("Tom");
			Collections.addAll(players, player1, player2, player3);
		}
	}
	
	public static void distributeCards(Deck deck, ArrayList<Player> players) {
		int split = deck.getDeck().size() / players.size();
		for(int j = 0; j < players.size(); j++) {
			for(int i = 0; i < split; i++) {
				Card card = deck.getDeck().remove(0);
				players.get(j).addCard(card);
			}
		}
	}

}