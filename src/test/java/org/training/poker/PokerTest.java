package org.training.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PokerTest {
	
	@Test
	public void canCreateCard() {

		Card card = new Card("5C");

		assertEquals(Rank.FIVE, card.getRank());
		assertEquals(Suit.C, card.getSuit());

	}
	
	@Test
	public void canCreateHand() {

		Card card1 = new Card("5C");
		Card card2 = new Card("6D");
		Card card3 = new Card("7S");
		Card card4 = new Card("8D");
		Card card5 = new Card("9H");
		
		Hand actual = new Hand(Arrays.asList(card1, card2, card3, card4, card5));
		List<Card> cards = Arrays.asList(card1, card2, card3, card4, card5);

		assertTrue(cards.containsAll(actual.getCards()));

	}
	
	
	@Test
	public void canSortCards() {

		Card card1 = new Card("5C");
		Card card2 = new Card("3D");
		Card card3 = new Card("7S");
		Card card4 = new Card("8D");
		Card card5 = new Card("9H");
		
		Hand actual = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		List<Card> cards = Arrays.asList(card2, card1, card3, card4, card5);

		assertEquals(cards, actual.sortCards());

	}


}
