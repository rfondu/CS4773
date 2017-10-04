package warGame;

import java.util.Scanner;

import deck.Card;
import deck.Deck;
import deck.SUIT;
import deck.VALUE;

public class WarGame {

	public static void main(String[] args) {
		Intro();
		Deck deck = new Deck();
		for(SUIT suit: SUIT.values()) {
			for(VALUE value: VALUE.values()) {
				deck.addCardToDeck(new Card(value, suit));				
			}
		}
	}
	
	public static void Intro() {
		int gameType = 0;
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
	
		
	public static void Start() {
		Scanner input = new Scanner(System.in);
			
		System.out.println("How many players?");
		int numPlayers = input.nextInt();		
	}

}