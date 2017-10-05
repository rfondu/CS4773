package tests;

import org.junit.Test;

import deck.Card;
import deck.Deck;
import deck.SUIT;
import deck.VALUE;
import player.PlayerType2;

/* 
	This test method will test the win by points play variation for three players
*/
public class WarTestsVar3 {

	@Test
	public void testSueWinsNoWar()
	{
		PlayerType2 sue = new PlayerType2("Sue");
		PlayerType2 bob = new PlayerType2("Bob");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.SPADES));
		
		War game = new WarVariation3(sue, bob, tom, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(sue, game.getWinningPlayer());
	} 
	
	@Test
	public void testTomWinsNoWar()
	{
		PlayerType2 tom = new PlayerType2("Tom");
		PlayerType2 bob = new PlayerType2("Bob");
		PlayerType2 sue = new PlayerType2("Sue");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.SPADES));
		
		War game = new WarVariation3(tom, bob, sue, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(tom, game.getWinningPlayer());
	} 
	
	@Test
	public void testTieGame()
	{
		PlayerType2 tom = new PlayerType2("Tom");
		PlayerType2 bob = new PlayerType2("Bob");
		PlayerType2 sue = new PlayerType2("Sue");
		
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.SPADES));
		
		War game = new WarVariation3(tom, bob, sue, deck);
		game.dealCardsToPlayers();
		game.playGame();
		
		assertEquals(tom, game.getWinningPlayer());
	} 
}
