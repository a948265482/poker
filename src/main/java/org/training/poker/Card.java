package org.training.poker;

public class Card {
	Rank rank;
	Suit suit;
	
	public Card(String face)	{
		rank = getRank(face.charAt(0));
		suit = getSuit(face.charAt(1));
	}
	


	public Rank getRank(char rank) {
			switch(rank) {
			case '2': return Rank.TWO; 
			case '3': return Rank.THREE;
			case '4': return Rank.FOUR; 
			case '5': return Rank.FIVE;
			case '6': return Rank.SIX; 
			case '7': return Rank.SEVEN;
			case '8': return Rank.EIGHT; 
			case '9': return Rank.NINE;
			case 'T': return Rank.TEN;
			case 'J': return Rank.J;
			case 'Q': return Rank.Q;
			case 'K': return Rank.K;
			case 'A': return Rank.A;
			}
		return null;
	}
		

	private Suit getSuit(char suit) {
		switch(suit) {
		case 'C': return Suit.C;
		case 'D': return Suit.D;
		case 'H': return Suit.H;
		case 'S': return Suit.S;
		
		}
		
		return null;
		
	}


}





enum Rank{
	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, J, Q, K, A;
}


 enum Suit {
	C, D, H, S;
}
 