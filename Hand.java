/**
 * Objects here (Hand.java) represents a hand of cards.
 * The cards belong to the class Card
 * Hand is empty when it is created
 * Any number of cards can be added to the hand
 * 
 * The first submission I submitted with step 9 commented out AND single highestDuplicate Method
 * The second submission, step 9 was deleted AND highestDuplicate method was split into two
 * 	Also corrected the mineMirror problem in the compareTo method
 * The third submission, combine highestDuplicate AND resurrected step 9 AND put in STRAIGHT FLUSH
 */

public class Hand
{
	private Card[] hand;   // The cards in the hand.
	private int count; 

	/**
	* Create a hand that is initially empty.
	*/
	public Hand()
	{
		hand = new Card[5];
		// Woah... hand of cards is represented by an array!!
		count = 0;
	}
	
	/**
	* Remove all cards from the hand, leaving it empty.
	*/
	public void clear()
	{
		for(int i=0 ; i<hand.length; i++)
		{
			hand[i] = null;
		}
		count = 0;
	}
	
	/**
	* Add a card to the hand. It is added at the end of the current hand.
	* @param c the non-null card to be added.
	* @throws NullPointerException if the parameter c is null.
	*/
	public void addCard(Card c)
	{
		for(int i=0 ; i<hand.length; i++)
		{ 
			if (hand[i] == null)
			{
				hand[i] = c;
				count = count + 1;
				break;
			}
		}
	}
	
	/**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
	public void removeCard(Card c)
	{
		for(int i=0 ; i<hand.length; i++)
		{
			if (hand[i].equals(c))
			{
				hand[i] = null;
				count = count-1;
			}
		}
	}

	/**
    * Remove the card in a specified position from the hand.
    * @param position = the position of the card that is to be removed
    * @throws IllegalArgumentException if the position does not exist in the hand,
    * that is if the position is < 0 or >= to the number of cards in the hand.
    */
	public void removeCard(int position)
	{
		if (position < 0 || position >= hand.length)
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		hand[position] = null;
	}
	
	/**
    * Returns the number of cards in the hand.
    */
	public int getCardCount()
	{
		return count;
	}

   /**
    * Gets the card in a specified position in the hand.
    * 	Note that this card is not removed from the hand!
    * @param position = the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
	public Card getCard(int position)
	{
		if (position < 0 || position >= hand.length)
			throw new IllegalArgumentException("Position does not exist in hand: " + position);
		return hand[position];
	}
   
   /**
    * Sorts the cards in the hand so that cards of the same SUIT are GROUPED TOGETHER,
    * and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
	public void sortBySuit()
	{
		int size = count;
		int nonnull = 0;
		int index = 0;
	   
		Card[] newHand = new Card[5];
		while (size > 0)
		{
			if (hand[nonnull] == null)
			{
				nonnull = nonnull+1; continue;
			}
			int pos = nonnull;		// Position of minimal card.
			Card c = hand[nonnull];	// Minimal card.
		 
		for (int i = nonnull+1; i < hand.length; i++)
		{
			Card c1 = hand[i];
			if (c1 != null)
			{
				if ( c1.getSuit() <  c.getSuit() ||
				    (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) )
				{
					pos = i;
					c = c1;
				}
			}
		}
		hand[pos] = null;
		size = size - 1;
		newHand[index++] = c;
		nonnull = 0;
		}
		hand = newHand;
	}
	
   /**
    * Sorts the cards in the hand so that cards of the same VALUE are grouped together.
    * Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
	public void sortByValue()
	{
		int size = count;
		int nonnull = 0;
		int index = 0;
	  
		Card[] newHand = new Card[5];
		while (size > 0)
		{
			if (hand[nonnull] == null)
			{
				nonnull = nonnull+1; continue;
			}
			int pos = nonnull;			// Position of minimal card.
			Card c = hand[nonnull];		// Minimal card.
		for (int i = nonnull+1; i < hand.length; i++)
        {    
			Card c1 = hand[i];
			if (c1 != null)
			{
				if ( c1.getValue() <  c.getValue() ||
				   ( c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) )
				{
					pos = i;
					c = c1;
				}
			}
        }
		hand[pos] = null;
		size = size - 1;
		newHand[index++] = c;
		nonnull = 0;
		}
		hand = newHand;
	}

	public void printHand()
	{
		for(int i=0; i<hand.length; i++)
		{
			if (hand[i] != null)
			{
				System.out.println(hand[i]);
			}
		}
		System.out.println();
	}
	// You're on your own soldier... 21 November 2017

// STEP 1 CHECKED
	public boolean hasFlush()
	// Returns true if this hand has all cards that are of the SAME SUIT
	// Apparently easiest one? According to Professor Trees. Try this one out!
	{
		boolean doYou = true;
		for(int scan=1; scan<hand.length; scan++)
		{
			if (hand[scan].getSuit() != hand[scan-1].getSuit())
			{
				doYou = false;	// Just need one false case
			}
		}
		return doYou;
	}

// STEP 2 CHECKED
	public boolean hasStraight()
	// Returns true if this hand has 5 CONSECUTIVE CARDS of any suit
	{
		sortByValue();
		boolean youStraight = true;
		for(int scan=0; scan<hand.length-1; scan++)
		{
			if (hand[scan].getValue()+1 != hand[scan+1].getValue())
			// Does this +1 actually add 1 to the value??? Don't know
				// Yes! It does work! - 30 November 2017
			{
				youStraight = false;
				// Again, just need one false case
			}
		}
		// NEED TO ACCOUNT FOR THE ACE LOOP AROUND
		if(hand[0].getValue() == 1  &&
		   hand[1].getValue() == 10 &&
		   hand[2].getValue() == 11 &&
		   hand[3].getValue() == 12 &&
		   hand[4].getValue() == 13)
		// And this solves it as this is the only case
		{
			youStraight = true;
		}
		return youStraight;
	}

// STEP 3 CHECKED
	public int numPairs()
	// Returns the number of pairs this hand contains
	{
		int countPairs = 0;
		sortByValue();
		// So all the cards of the same value are together
		if(hand[0].getValue() == hand[1].getValue())
		{
			countPairs ++;
		}
		if(hand[1].getValue() == hand[2].getValue())
		{
			countPairs ++;
		}
		if(hand[2].getValue() == hand[3].getValue())
		{
			countPairs ++;
		}
		if(hand[3].getValue() == hand[4].getValue())
		{
			countPairs ++;
		}
		int problems = 0;	// To count 2 pairs when there is a 4 of a kind
		for(int scan=1; scan<hand.length; scan++)
		{
			if(hand[scan].getValue() == hand[scan-1].getValue())
			{
				problems++;
			}
		}
		if (problems == 3)
		{
			countPairs = 2;
		}
		boolean TripleThreat = false;	// So something like 5,5,5,6,7 doesn't screw with me
		for(int scan=2; scan<hand.length; scan++)
		{
			if(hand[scan].getValue() == hand[scan-1].getValue() &&
			   hand[scan].getValue() == hand[scan-2].getValue() &&
			   problems != 3)
			{
				TripleThreat = true;
			}
		}
		if (TripleThreat == true)
		{
			countPairs--;
		}
		return countPairs;
	}

// STEP 4 CHECKED
	public boolean hasTriplet()
	// Returns true if this hand has 3 cards that are of the same value
	{
		boolean haveTriplet = false;
		boolean TripletCheck = false;
		sortByValue();
		for(int scan=2; scan<hand.length; scan++)
		{
			if(hand[scan].getValue() == hand[scan-1].getValue() &&
			   hand[scan].getValue() == hand[scan-2].getValue())
			{
				TripletCheck = true;
			}
			// First if statement checks for triplets
			if(TripletCheck==true)
			{
				haveTriplet = true;
			}
			// Second if statement confirms it
		}
		return haveTriplet;
	}

// STEP 5 CHECKED
	public boolean hasFourOfAKind()
	// Returns true if this hand has 4 cards that are of the same value
	{
		boolean haveQuad = false;
		boolean QuadCheck = false;


		for(int scan=3; scan<hand.length; scan++)
		{
			if(hand[scan].getValue() == hand[scan-1].getValue() &&
			   hand[scan].getValue() == hand[scan-2].getValue() &&
			   hand[scan].getValue() == hand[scan-3].getValue())
			{
				QuadCheck = true;
			}
			// First if statement checks for quads (statement can become false)
			if(QuadCheck==true)
			{
				haveQuad = true;
			}
			// Second if statement confirms it
		}
		return haveQuad;
		// Wow... it's almost as if I copy and pasted the hasTriplet method.
	}
	
// STEP 6 CHECKED
	public boolean hasFullHouse()
	// Returns true if this hand has a triplet and a pair of different values
	{
		boolean haveFullHouse = false;
		sortByValue();
		if((hand[0].getValue() == hand[1].getValue() && hand[0].getValue() == hand[2].getValue()) &&
		   (hand[3].getValue() == hand[4].getValue()))
		{
			haveFullHouse = true;
		}
		if((hand[0].getValue() == hand[1].getValue()) &&
		   (hand[2].getValue() == hand[3].getValue() && hand[2].getValue() == hand[4].getValue()))
		{
			haveFullHouse = true;
		}
		return haveFullHouse;
	}
	
// STEP 7 CHECKED
	public Card highestValue()
	// Returns the card with the highest value in the hand.
	// When there is more than one highest value card, you may return any one of them 
	{
		sortByValue();		// Doesn't this put the highest card at the last index???
		return hand[4];		// Does this get the card at index 4?
	}
	// ... Wow. Easiest one so far?

// STEP 8 CHECKED
	public Card highestDuplicate()
	// Returns the highest valued Card of any pair or triplet found, null if none.
	// When values are equal, you may return either
	// You see, these instructions are not clear- highest card or highest card of triplet??
	// The worst method I have ever had to create. Period.
	{
		sortByValue();
		Card highestDup = null;
		
		int checking = 0;
		for (int scan=hand.length-1; scan>0; scan--)
		{
			if(hand[scan].getValue() == hand[scan-1].getValue())
			{
				checking++;
				if(checking == 1)
				{
					highestDup = hand[scan];
				}
			}
		}
		int tripCheck = 0;	// For valuing triples higher than doubles
		for (int tripScan=hand.length-1; tripScan>1; tripScan--)
		{
			if(hand[tripScan].getValue() == hand[tripScan-1].getValue() &&
			   hand[tripScan].getValue() == hand[tripScan-2].getValue())
			{
				tripCheck++;
				if(tripCheck == 1)
				{
					highestDup = hand[tripScan]; //change from highestTrip
				}
			}
		}
		return highestDup;
	}
	
// STEP 9... Do we need this or do we not???
    public boolean hasStraightFlush()
    // Returns true if his hand has 5 CONSECUIVE CARDS of the SAME SUIT
    // Extra method!
    // I mean... I could just not write this and use Straight + Flush methods in compareTo but...
    {
    		if(this.count != 5)
    			return false;
    		System.out.println("...");
    		this.printHand();
        sortByValue();
        boolean straightFlushYah = true;
        for(int scan=0; scan<hand.length-1; scan++)
        {
            if ((hand[scan].getValue()+1 != hand[scan+1].getValue()) &&
                (hand[scan].getSuit()    != hand[scan+1].getSuit()))
            {
                straightFlushYah = false;
                
            }
        }
        if(hand[0].getValue() == 1 &&
           hand[1].getValue() == 10 &&
           hand[2].getValue() == 11 &&
           hand[3].getValue() == 12 &&
           hand[4].getValue() == 13 &&
           hand[0].getSuit() == hand[1].getSuit() &&
           hand[1].getSuit() == hand[2].getSuit() &&
           hand[2].getSuit() == hand[3].getSuit() &&
           hand[3].getSuit() == hand[4].getSuit())
        {
            straightFlushYah = true;
        }
        return straightFlushYah;
    }

// STEP 10 CHECKED
	public int compareTo(Hand h)
	// Returns -1 if the instance hand loses to the parameter hand,
	// 0 if the hands are equal, +1 if the instance hand wins over the parameter hand.
	// Hint: you might want to use some of the methods above
	{
		int WinOrLose = 0;		// Will either be -1, 1, or 0
		int minePoints = 0;
		int yourPoints = 0;
		
		Hand mineMirror = new Hand();
		mineMirror.addCard(hand[0]);
		mineMirror.addCard(hand[1]);
		mineMirror.addCard(hand[2]);
		mineMirror.addCard(hand[3]);
		mineMirror.addCard(hand[4]);
		
		// Points for MY hand
		if(mineMirror.hasStraightFlush() == true)
			// On Wikipedia, this is the highest combo
			// Only thing I see that could be possibly wrong after 3 submissions
		{
			minePoints=8;
		}
		if(mineMirror.hasFourOfAKind() == true)
			// Damn. I didn't put "mineMirror" in front of methods. Screwed it all over.
		{
			minePoints=7;
		}
		else if(mineMirror.hasFullHouse() == true)
		{
			minePoints=6;
		}
		else if(mineMirror.hasFlush() == true)
		{
			minePoints=5;
		}
		else if(mineMirror.hasStraight() == true)
		{
			minePoints=4;
		}
		else if(mineMirror.hasTriplet() == true)
		{
			minePoints=3;
		}
		else if(mineMirror.numPairs() == 2)
		{
			minePoints=2;
		}
		else if(mineMirror.numPairs() == 1)
		{
			minePoints=1;
		}
		
		// Points for YOUR hand
		if(h.hasStraightFlush() == true)
		{
			yourPoints=8;
		}
		if(h.hasFourOfAKind() == true)
		{
			yourPoints=7;
		}
		else if(h.hasFullHouse() == true)
		{
			yourPoints=6;
		}
		else if(h.hasFlush() == true)
		{
			yourPoints=5;
		}
		else if(h.hasStraight() == true)
		{
			yourPoints=4;
		}
		else if(h.hasTriplet() == true)
		{
			yourPoints=3;
		}
		else if(h.numPairs() == 2)
		{
			yourPoints=2;
		}
		else if(h.numPairs() == 1)
		{
			yourPoints=1;
		}
		
		if(minePoints==0 && yourPoints==0)	// No one has combos so go by highest card
		{
			if(mineMirror.highestValue().getValue() > h.highestValue().getValue())
			{
				WinOrLose = 1;
			}
			else if(mineMirror.highestValue().getValue() < h.highestValue().getValue())
			{
				WinOrLose = -1;
			}
			else if(mineMirror.highestValue().getValue() == h.highestValue().getValue())
			{
				WinOrLose = 0;
			}
		}
		else if(minePoints<yourPoints)
		{
			WinOrLose = -1;
		}
		else if(minePoints>yourPoints)
		{
			WinOrLose = 1;
		}
		else if(minePoints==yourPoints)
		// Only case left is if the points are equal to each other (Hence same combo)
		// For PAIRS and QUADS: highestDuplicate()
		// After fixing highestDuplicate(): now also works for FULL HOUSE and TRIPLETS
			// Update: highestDuplicate doesn't work for FULL HOUSE and TRIPLETS
			// Update 2.0: disregard update
		// For FLUSH and STRAIGHT: highestValue()
			// And now... STRAIGHT FLUSH also uses highestValue()
		{
			if(minePoints == 7 || minePoints == 2 || minePoints == 1)
				// The four-of-a-kind and pairs
			{
				if(mineMirror.highestDuplicate().getValue() > h.highestDuplicate().getValue())
				{
					WinOrLose = 1;
				}
				else if(mineMirror.highestDuplicate().getValue() < h.highestDuplicate().getValue())
				{
					WinOrLose = -1;
				}
				else
				{
					WinOrLose = 0;
				}
			}
			else if(minePoints == 6 || minePoints == 3)
				// The full house and triplet
			{
				if(mineMirror.highestDuplicate().getValue() > h.highestDuplicate().getValue())
				// Changed from highestTriplet
				{
					WinOrLose = 1;
				}
				else if(mineMirror.highestDuplicate().getValue() < h.highestDuplicate().getValue())
				// Changed from highestTriplet
				{
					WinOrLose = -1;
				}
				else
				{
					WinOrLose = 0;
				}
			}
			else if(minePoints == 8 || minePoints == 5 || minePoints == 4)
				// The straight flush, flush, and straight
			{
				if(mineMirror.highestValue().getValue() > h.highestValue().getValue())
				{
					WinOrLose = 1;
				}
				else if(mineMirror.highestValue().getValue() < h.highestValue().getValue())
				{
					WinOrLose = -1;
				}
				else
				{
					WinOrLose = 0;
				}
			}
		}
		return WinOrLose;
	}
	// Wow. Got to this point on Friday, December 1, 2017. 590 lines of code. Sucks.
}

// FYI: We have to write a test class if we want to test our program
