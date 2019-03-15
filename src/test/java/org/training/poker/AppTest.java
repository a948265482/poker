package org.training.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
	public void canCreateCard() {

		Card card = new Card("5C");

		assertEquals(card.rank, Rank.FIVE);
		assertEquals(card.suit, Suit.C);

	}

}
