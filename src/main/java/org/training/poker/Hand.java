package org.training.poker;

import java.util.*;

public class Hand {
	private Ranking ranking;
	private List<Card> cards;
	
	Hand(List<Card> cards) {
		this.ranking = getRanking(cards);
		this.cards = cards;
	}
	

	public List<Card> getCards(){
		return this.cards;
	}
	
	public Ranking getRanking(List<Card> cards) {
		return null;
	}

}


