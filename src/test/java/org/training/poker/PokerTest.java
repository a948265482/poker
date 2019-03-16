package org.training.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

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
	
	
	@Test
	public void canGetRankFrequency() {

		Card card1 = new Card("3C");
		Card card2 = new Card("3D");
		Card card3 = new Card("7S");
		Card card4 = new Card("8D");
		Card card5 = new Card("9H");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		Map expected = new TreeMap();
		expected.put(card1.getRank(), 2);
		expected.put(card3.getRank(), 1);
		expected.put(card4.getRank(), 1);
		expected.put(card5.getRank(), 1);
		
		assertEquals(hand.getRankFrequency(), expected);

	}
	
	
	@Test
	public void isStraight() {
		Card card1 = new Card("5C");
		Card card2 = new Card("6D");
		Card card3 = new Card("7S");
		Card card4 = new Card("8D");
		Card card5 = new Card("9H");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isStraight());
	}
	
	
	@Test
	public void isFlush() {
		Card card1 = new Card("5C");
		Card card2 = new Card("6C");
		Card card3 = new Card("TC");
		Card card4 = new Card("9C");
		Card card5 = new Card("9C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isFlush());
	}
	
	
	@Test
	public void isStraightFlush() {
		Card card1 = new Card("5C");
		Card card2 = new Card("6C");
		Card card3 = new Card("7C");
		Card card4 = new Card("8C");
		Card card5 = new Card("9C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isFlush() && hand.isStraight()); 
	}
	
	

	@Test
	public void isFourOfaKind() {
		Card card1 = new Card("5C");
		Card card2 = new Card("5C");
		Card card3 = new Card("5D");
		Card card4 = new Card("5H");
		Card card5 = new Card("9C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isFourOfaKind()); 
	}
	
	@Test
	public void isThreeOfaKind() {
		Card card1 = new Card("5C");
		Card card2 = new Card("5C");
		Card card3 = new Card("5D");
		Card card4 = new Card("8H");
		Card card5 = new Card("9C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isThreeOfaKind()); 
	}
	
	
	@Test
	public void isFullHouse() {
		Card card1 = new Card("5C");
		Card card2 = new Card("5C");
		Card card3 = new Card("5D");
		Card card4 = new Card("9H");
		Card card5 = new Card("9C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isFullHouse()); 
	}
	

	@Test
	public void isTwoPair() {
		Card card1 = new Card("5C");
		Card card2 = new Card("5C");
		Card card3 = new Card("8D");
		Card card4 = new Card("9H");
		Card card5 = new Card("9C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isTwoPair()); 
	}
	
	
	@Test
	public void isPair() {
		Card card1 = new Card("3C");
		Card card2 = new Card("5C");
		Card card3 = new Card("8D");
		Card card4 = new Card("9H");
		Card card5 = new Card("5C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertTrue(hand.isPair()); 
	}

	
	@Test
	public void getRanking_RoyalFlush() {
		Card card1 = new Card("TC");
		Card card2 = new Card("JC");
		Card card3 = new Card("QC");
		Card card4 = new Card("KC");
		Card card5 = new Card("AC");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.ROYALFLUSH); 
	}
	
	
	
	@Test
	public void getRanking_StraightFlush() {
		Card card1 = new Card("3C");
		Card card2 = new Card("4C");
		Card card3 = new Card("5C");
		Card card4 = new Card("6C");
		Card card5 = new Card("7C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.STRAIGHTFLUSH); 
	}
	
	
	@Test
	public void getRanking_Straight() {
		Card card1 = new Card("3C");
		Card card2 = new Card("4D");
		Card card3 = new Card("5H");
		Card card4 = new Card("6S");
		Card card5 = new Card("7C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.STRAIGHT); 
	}
	
	
	@Test
	public void getRanking_Flush() {
		Card card1 = new Card("3C");
		Card card2 = new Card("9C");
		Card card3 = new Card("5C");
		Card card4 = new Card("6C");
		Card card5 = new Card("7C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.FLUSH); 
	}
	
	
	@Test
	public void getRanking_FourOfaKind() {
		Card card1 = new Card("3C");
		Card card2 = new Card("3H");
		Card card3 = new Card("3D");
		Card card4 = new Card("3S");
		Card card5 = new Card("7C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.FOUROFAKIND); 
	}
	
	@Test
	public void getRanking_ThreeOfaKind() {
		Card card1 = new Card("3C");
		Card card2 = new Card("3H");
		Card card3 = new Card("3D");
		Card card4 = new Card("4S");
		Card card5 = new Card("7C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.THREEOFAKIND); 
	}
	
	@Test
	public void getRanking_FullHouse() {
		Card card1 = new Card("3C");
		Card card2 = new Card("3H");
		Card card3 = new Card("3D");
		Card card4 = new Card("4S");
		Card card5 = new Card("4C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.FULLHOUSE); 
	}
	
	
	
	@Test
	public void getRanking_TwoPair() {
		Card card1 = new Card("3C");
		Card card2 = new Card("4H");
		Card card3 = new Card("5D");
		Card card4 = new Card("3S");
		Card card5 = new Card("4C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.TWOPAIR); 
	}
	
	
	
	
	
	@Test
	public void getRanking_Pair() {
		Card card1 = new Card("3C");
		Card card2 = new Card("3H");
		Card card3 = new Card("5D");
		Card card4 = new Card("6S");
		Card card5 = new Card("4C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.PAIR); 
	}
	
	
	
	@Test
	public void getRanking_HighCard() {
		Card card1 = new Card("3C");
		Card card2 = new Card("9H");
		Card card3 = new Card("5D");
		Card card4 = new Card("6S");
		Card card5 = new Card("4C");
		
		Hand hand = new Hand(Arrays.asList(card1, card2, card4, card5, card3));
		
		assertEquals(hand.getRanking(), Ranking.HIGHCARD); 
	}
	
	
	
	
	
}
