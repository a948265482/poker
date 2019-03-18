package org.training.poker;

import java.util.*;
import java.util.Map.Entry;

public class Hand {
	private List<Card> cards;

	Hand(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public List<Card> sortCards() {
		Collections.sort(this.cards);
		return this.cards;
	}

	/**
	 * 
	 * @param hand1
	 * @param hand2
	 * @return int, if positive, hand1 wins, if negative, hand2 wins, if 0, it's a
	 *         tie
	 */
	public int compareHands(Hand hand1, Hand hand2) {
		if (hand1.getRanking() != hand2.getRanking()) {
			return hand1.getRanking().compareTo(hand2.getRanking());
		} else {
			if (hand1.getRanking() == Ranking.ROYALFLUSH) {
				return 0;
			} else if ((hand1.getRanking() == Ranking.STRAIGHTFLUSH) || (hand1.getRanking() == Ranking.STRAIGHT)) {
				return hand1.sortCards().get(4).getRank().compareTo(hand2.sortCards().get(4).getRank());
			} else if (hand1.getRanking() == Ranking.FOUROFAKIND) {
				Rank rankOfFour1 = hand1.frequencyToRank().get(4).get(0);
				Rank rankOfFour2 = hand2.frequencyToRank().get(4).get(0);

				return rankOfFour1.compareTo(rankOfFour2);

			} else if ((hand1.getRanking() == Ranking.FULLHOUSE) || (hand1.getRanking() == Ranking.THREEOFAKIND)) {
				Rank rankOfThree1 = hand1.frequencyToRank().get(3).get(0);
				Rank rankOfThree2 = hand2.frequencyToRank().get(3).get(0);

				return rankOfThree1.compareTo(rankOfThree2);

			} else if (hand1.getRanking() == Ranking.TWOPAIR) {
				Rank rankOfFirstPair1 = hand1.frequencyToRank().get(2).get(0);
				Rank rankOfFirstPair2 = hand2.frequencyToRank().get(2).get(0);

				Rank rankOfSecondPair1 = hand1.frequencyToRank().get(2).get(1);
				Rank rankOfSecondPair2 = hand2.frequencyToRank().get(2).get(1);

				if (rankOfSecondPair1 == rankOfSecondPair2) {
					return rankOfFirstPair1.compareTo(rankOfFirstPair2);
				}

				return rankOfSecondPair1.compareTo(rankOfSecondPair2);

			} else if (hand1.getRanking() == Ranking.PAIR) {
				Rank rankOfPair1 = hand1.frequencyToRank().get(2).get(0);
				Rank rankOfPair2 = hand2.frequencyToRank().get(2).get(0);

				if (rankOfPair1 != rankOfPair2) {
					return rankOfPair1.compareTo(rankOfPair2);
				}
				return hand1.frequencyToRank().get(1).get(2).compareTo(hand2.frequencyToRank().get(1).get(2));

			} else if (hand1.getRanking() == Ranking.HIGHCARD || hand1.getRanking() == Ranking.FLUSH) {
				for (int i = 4; i > 0; i--) {
					if (hand1.sortCards().get(i) != hand2.sortCards().get(i)) {
						return hand1.sortCards().get(i).compareTo(hand2.sortCards().get(i));
					}
					return 0;
				}
			}

		}

		return 0;
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

	public Map<Integer, List<Rank>> frequencyToRank() {
		Map<Rank, Integer> rankToFrenquency = this.getRankFrequency();

		Map<Integer, List<Rank>> frequencyRank = new TreeMap<Integer, List<Rank>>();

		for (Entry<Rank, Integer> entry : rankToFrenquency.entrySet()) {

			if (!frequencyRank.containsKey(entry.getValue())) {
				ArrayList<Rank> rankList = new ArrayList<Rank>();
				rankList.add(entry.getKey());
				frequencyRank.put(entry.getValue(), rankList);
			} else {
				frequencyRank.get(entry.getValue()).add(entry.getKey());
			}
		}

		return frequencyRank;
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
