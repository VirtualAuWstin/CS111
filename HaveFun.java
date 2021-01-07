// This program is the "tester" (basically, to see if the other programs in this package works)

public class HaveFun
// The funny thing is I won't
{
	public static void main(String[] args)
	{
		// 1st number = value, 2nd number = suit
		Card c1 = new Card(4, 1);
		Card c2 = new Card(5, 1);
		Card c3 = new Card(6, 1);
		Card c4 = new Card(7, 1);
		Card c5 = new Card(8, 1);

		Hand mine = new Hand();
		System.out.println("My hand: ");
		mine.addCard(c1);
		mine.addCard(c2);
		mine.addCard(c3);
		mine.addCard(c4);
		mine.addCard(c5);
		mine.printHand();

		Card c6  = new Card(10, 0);
		Card c7  = new Card(11, 2);
		Card c8  = new Card(12, 1);
		Card c9  = new Card(13, 3);
		Card c10 = new Card(1, 1);

		Hand yours = new Hand();
		System.out.println("Other hand: ");
		yours.addCard(c6);
		yours.addCard(c7);
		yours.addCard(c8);
		yours.addCard(c9);
		yours.addCard(c10);
		yours.printHand();
		
		System.out.println("Has a flush (same suit): " + mine.hasFlush());
		// CHECKED
		System.out.println("Has a straight (in order): " + mine.hasStraight());
		// CHECKED
		System.out.println("Has a straight flush (THE BEST): " + mine.hasStraightFlush());
		//
		System.out.println("Number of pairs: " + mine.numPairs());
		// CHECKED
		System.out.println("Has a triplet: " + mine.hasTriplet());
		// CHECKED
		System.out.println("Has a four of a kind: " + mine.hasFourOfAKind());
		// CHECKED
		System.out.println("Has a full house: " + mine.hasFullHouse());
		// CHECKED
		System.out.println("Highest value: " + mine.highestValue());
		// CHECKED
		System.out.println("Highest duplicate: " + mine.highestDuplicate());
		// CHECKED
		System.out.println("I win (+1), lose (-1), or tie (0): " + mine.compareTo(yours));
		// CHECKED
	}
}
