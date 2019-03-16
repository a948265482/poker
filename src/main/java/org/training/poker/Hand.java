package org.training.poker;

import java.util.*;

public class Hand {
	private Ranking ranking;
	private List<Card> cards;

	Hand(List<Card> cards) {
		this.cards = cards;
		this.ranking = getRanking();
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public List<Card> sortCards() {
		Collections.sort(this.cards);
		return this.cards;
	}

	public Ranking getRanking() {
		if (isStraight() && isFlush() && cards.get(0).getRank() == Rank.TEN) {
			return Ranking.ROYALFLUSH;
		}

		if (isStraight() && isFlush()) {
			return Ranking.STRAIGHTFLUSH;
		}

		if (isStraight()) {
			return Ranking.STRAIGHT;
		}

		if (isFlush()) {
			return Ranking.FLUSH;
		}
		if (isFourOfaKind()) {
			return Ranking.FOUROFAKIND;
		}
		if (isFullHouse()) {
			return Ranking.FULLHOUSE;
		}
		if (isThreeOfaKind()) {
			return Ranking.THREEOFAKIND;
		}
		if (isTwoPair()) {
			return Ranking.TWOPAIR;
		}
		if (isPair()) {
			return Ranking.PAIR;
		}

		return Ranking.HIGHCARD;

	}

	public Map<Rank, Integer> getRankFrequency() {
		Map<Rank, Integer> rankFrequency = new TreeMap<Rank, Integer>();
		for (int i = 0; i < cards.size(); i++) {
			if (!rankFrequency.containsKey(cards.get(i).getRank())) {
				rankFrequency.put(cards.get(i).getRank(), 1);
			} else {
				int frequency = rankFrequency.get(cards.get(i).getRank());
				frequency++;
				rankFrequency.put(cards.get(i).getRank(), frequency);
			}
		}
		return rankFrequency;
	}

	public boolean isStraight() {
		int uniqueRanks = this.getRankFrequency().size();
		this.cards = this.sortCards();

		if (uniqueRanks == 5) {
			for (int i = 0; i < 4; i++) {
				int difference = cards.get(i).getRank().compareTo(cards.get(i + 1).getRank());
				if (difference != -1) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	public boolean isFlush() {
		Set<Suit> suits = new HashSet<Suit>();
		for (Card card : cards) {
			suits.add(card.getSuit());
		}

		if (suits.size() == 1) {
			return true;
		}

		return false;
	}

	public boolean isFourOfaKind() {
		if (this.getRankFrequency().containsValue(4)) {
			return true;
		}
		return false;
	}

	public boolean isFullHouse() {
		if (this.getRankFrequency().containsValue(3) && this.getRankFrequency().containsValue(2)) {
			return true;
		}
		return false;
	}

	public boolean isThreeOfaKind() {
		if (this.getRankFrequency().containsValue(3)) {
			return true;
		}
		return false;
	}

	public boolean isTwoPair() {
		int count = Collections.frequency(new ArrayList<Integer>(getRankFrequency().values()), 2);

		if (count == 2) {
			return true;
		}
		return false;
	}

	public boolean isPair() {
		if (this.getRankFrequency().containsValue(2)) {
			return true;
		}
		return false;
	}

}
