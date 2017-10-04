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
		deck.NormalDeck();
		deck.Shuffle();
		//Player Initialization
		Start();
	}
	
	public static void Intro() {
		
		System.out.println("Welcome to");
		System.out.println("*************");
		System.out.println("* War Game! *");
		System.out.println("*************");	
	
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
    	System.out.println("Select War Game Variation: \n");
		System.out.println("1) Game type one \n");
		System.out.println("2) Game type two \n");
		System.out.println("3) Game type three \n");
    	int variation = input.nextInt();
        
	}
	
		
	public static void Start() {
		Scanner input = new Scanner(System.in);
			
		System.out.println("How many players?");
		int numPlayers = input.nextInt();		
	}

}