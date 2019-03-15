package org.training.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PokerTest {
	
	@Test
	public void canCreateCard() {

		Card card = new Card("5C");

		assertEquals(Rank.FIVE, card.getRank());
		assertEquals(Suit.C, card.getSuit());

	}

}
