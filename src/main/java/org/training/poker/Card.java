package org.training.poker;

import java.util.*;

public class Card implements Comparable<Card>{
	private Rank rank;
	private Suit suit;

	Card(String face) {
		rank = Rank.getRank(face.charAt(0));
		suit = Suit.getSuit(face.charAt(1));
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}

	public int compareTo(Card card) {
		return this.rank.compareTo(card.rank);
	}
	
	
	

}




