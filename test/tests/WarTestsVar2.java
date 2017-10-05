package tests;

import org.junit.Test;
import deck.Card;
import deck.Deck;
import deck.SUIT;
import deck.VALUE;
import player.PlayerType2;

/* 
	This test method will test the win by points play variation for two players
*/

public class WarTestsVar2 {

	@Test
	public void testSueWinsNoWar()
	{
		PlayerType2 sue = new PlayerType2("Sue");
		PlayerType2 bob = new PlayerType2("Bob");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		
		War game = new WarVariation1(sue, bob, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(sue, game.getWinningPlayer());
	} 
	
	@Test
	public void testBobWinsNoWar()
	{
		PlayerType2 sue = new PlayerType2("Sue");
		PlayerType2 bob = new PlayerType2("Bob");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		
		War game = new WarVariation1(bob, sue, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(bob, game.getWinningPlayer());
	}
	
	@Test
	public void testTieGame()
	{
		PlayerType2 sue = new PlayerType2("Sue");
		PlayerType2 bob = new PlayerType2("Bob");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		
		War game = new WarVariation1(bob, sue, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(bob, game.getWinningPlayer());
	} 
}
