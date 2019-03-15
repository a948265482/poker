package org.training.poker;

enum Suit {
	C, D, H, S;

	public static Suit getSuit(char suit) {
		switch (suit) {
		case 'C':
			return Suit.C;
		case 'D':
			return Suit.D;
		case 'H':
			return Suit.H;
		case 'S':
			return Suit.S;

		}

		return null;

	}
}
