package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import deck.Card;
import deck.Deck;
import deck.SUIT;
import deck.VALUE;
import game.Continuous;
import game.Points;
import game.ThreePlayer;
import player.Player;
import player.PlayerContinuous;
import player.PlayerPoints;

public class WarGameJunitTest {
	ArrayList<Player> players = new ArrayList<Player>();
	
	public void tearDown(){
		players.clear();
	}
	
	@Test
	public void testPlayersCreated() {
		Player sue = new Player("Sue");
		Player bob = new Player("Bob");
		Player tom = new Player("Tom");
		players.add(sue);
		players.add(bob);
		players.add(tom);
		assertEquals(players.size(), 3);
	}

	@Test
	public void nullDeck() {
		Deck deck = new Deck();
		assertEquals(0, deck.getDeck().size());
	}
	
	@Test
	public void fullDeck() {
		Deck deck = new Deck();
		deck.normalDeck();
		assertEquals(52, deck.getDeck().size());
	}
	
	@Test
	public void testHandSizeForTwoPlayers() {
		Deck deck = new Deck();
		deck.normalDeck();
		
		Player sue = new Player("Sue");
		Player bob = new Player("Bob");
		players.add(sue);
		players.add(bob);
		warGame.WarGame.distributeCards(deck, players);
		
		assertEquals(players.get(0).getDownPile().size(), 26);
	}

	@Test
	public void testHandSizeForThreePlayers() {
		Deck deck = new Deck();
		deck.normalDeck();
		
		Player sue = new Player("Sue");
		Player bob = new Player("Bob");
		Player tom = new Player("Tom");
		players.add(sue);
		players.add(bob);
		players.add(tom);
		warGame.WarGame.distributeCards(deck, players);
		
		assertEquals(players.get(0).getDownPile().size(), 17);
	}
	
	@Test
	public void testSueWinnerTwoPlayer() {
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.HEARTS));
		deck.addCardToDeck(new Card(VALUE.JACK, SUIT.HEARTS));
		
		PlayerContinuous sue = new PlayerContinuous("Sue");
		PlayerContinuous bob = new PlayerContinuous("Bob");

		players.add(sue);
		players.add(bob);
		
		warGame.WarGame.distributeCards(deck, players);
		game.InterfaceGameType war = new Continuous();
		war.roundStart(players);
		
		assertEquals(sue.getName(), war.getWinner().getName());
	}
	
	@Test
	public void testBobWinnerTwoPlayer() {
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.KING, SUIT.CLUBS));
		deck.addCardToDeck(new Card(VALUE.FOUR, SUIT.SPADES));
		
		PlayerPoints bob = new PlayerPoints("Bob");
		PlayerPoints sue = new PlayerPoints("Sue");
		
		players.add(bob);
		players.add(sue);
		
		warGame.WarGame.distributeCards(deck, players);
		game.InterfaceGameType war = new Points();
		war.roundStart(players);
		
		assertEquals(bob.getName(), war.getWinner().getName());
	}
	
	@Test
	public void testTomWinnerThreePlayer() {
		Deck deck = new Deck();
		deck.addCardToDeck(new Card(VALUE.ACE, SUIT.HEARTS));
		deck.addCardToDeck(new Card(VALUE.JACK, SUIT.HEARTS));
		deck.addCardToDeck(new Card(VALUE.TEN, SUIT.HEARTS));
		
		PlayerPoints tom = new PlayerPoints("Tom");
		PlayerPoints bob = new PlayerPoints("Bob");
		PlayerPoints sue = new PlayerPoints("Sue");
		
		players.add(tom);
		players.add(bob);
		players.add(sue);
		
		warGame.WarGame.distributeCards(deck, players);
		game.InterfaceGameType war = new ThreePlayer();
		war.roundStart(players);
		
		assertEquals(tom.getName(), war.getWinner().getName());
	}
	
	@Test
	public void testShuffleDeck() {
		Deck notShuffledDeck = new Deck();
		Deck deck = new Deck();
		deck.normalDeck();
		deck.shuffle();
		
		assertNotSame(deck, notShuffledDeck);
	}	
	
	@Test
	public void testCardEntered() {
		Card oneCard = new Card(VALUE.ACE, SUIT.HEARTS);		
		Player tom = new Player("Tom");
		tom.addCard(oneCard);
		
		assertEquals(oneCard, tom.drawCard());
	}
	
	@Test
	public void testTieGameTwoPlayerCompleteDeckContinuous() {
		Deck deck = new Deck();
		deck.normalDeck();
		
		PlayerContinuous bob = new PlayerContinuous("Bob");
		PlayerContinuous sue = new PlayerContinuous("Sue");
		
		players.add(bob);
		players.add(sue);
		
		warGame.WarGame.distributeCards(deck, players);
		game.InterfaceGameType war = new Continuous();
		war.roundStart(players);
		
		assertEquals(bob.getDownPile().size(), sue.getDownPile().size());
	}
	
	@Test
	public void testTieGameTwoPlayerCompleteDeckPoints() {
		Deck deck = new Deck();
		deck.normalDeck();
		
		PlayerPoints bob = new PlayerPoints("Bob");
		PlayerPoints sue = new PlayerPoints("Sue");
		
		players.add(bob);
		players.add(sue);
		
		warGame.WarGame.distributeCards(deck, players);
		game.InterfaceGameType war = new Points();
		war.roundStart(players);
		
		assertEquals(bob.getPoints(), sue.getPoints());
	}
	
	@Test
	public void testTieGameThreePlayerCompleteDeckPoints() {
		Deck deck = new Deck();
		deck.normalDeck();
		
		PlayerPoints bob = new PlayerPoints("Bob");
		PlayerPoints sue = new PlayerPoints("Sue");
		PlayerPoints tom = new PlayerPoints("Tom");
		
		players.add(bob);
		players.add(sue);
		players.add(tom);
		
		warGame.WarGame.distributeCards(deck, players);
		game.InterfaceGameType war = new ThreePlayer();
		war.roundStart(players);
		
		assertEquals(bob.getPoints(), sue.getPoints(), tom.getPoints());
	}
}