package tests;

import org.junit.Test;

import deck.Card;
import deck.Deck;
import deck.SUIT;
import deck.VALUE;
import player.PlayerType1;

/* 
	This test method will test the continuous play variation
 */

public class WarTestsVar1 {

	@Test
	public void testSueWinsNoWar()
	{
		PlayerType1 sue = new PlayerType1("Sue");
		PlayerType1 bob = new PlayerType1("Bob");
		
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
		PlayerType1 bob = new PlayerType1("Bob");
		PlayerType1 sue = new PlayerType1("Sue");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		
		War game = new WarVariation1(bob, sue, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(bob, game.getWinningPlayer());
	} 
}
