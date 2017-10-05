package warGame;

import deck.Card;
import player.Player;

public class Output {
		
	Player name;
	
	public void PlayerWon(Player player){
		System.out.println(name.getName() + " wins the round\n");
	}
	
	public void PlayerCard(Player player, Card card){
		System.out.println(name.getName() + " plays " + card.getValue() + " of " + card.getSuit() + " as up card \n");
	}
	
	public void PlayerScore(Player players){
		// this is assuming an arraylist of players will be passed 
		// need to either pass the score or use array.length to get the score
		// I know it's not correct but the logic is there just need to figure out what will be passed
		
		System.out.println("Score is "); 
		String fencePost = ",";
		for(Player p: Players) {
			if(p == Players.length){
				fencePost = " ";
			}
			System.out.println(p.name.getName() + score + fencePost);
		}
		System.out.println("\n");
	}
	
	public void War(){	
		System.out.println("WAR!\n");
	}
	
	public void WinGame(Player player){	
		System.out.println(name.getName() + " wins the game!\n");
	}
}