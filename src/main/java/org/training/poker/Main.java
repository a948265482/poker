package org.training.poker;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Card card1 = new Card("5C");
		Card card2 = new Card("6D");
		Card card3 = new Card("8S");
		Card card4 = new Card("7D");
		Card card5 = new Card("9H");
		
		List<Card> cards = Arrays.asList(card2, card1, card3, card4, card5);

        Hand hand = new Hand(cards);
        
        //hand.rankFrequency(cards);
        System.out.println(hand.getRankFrequency());
        System.out.println(hand.isStraight());
    }

    
  
    
}
