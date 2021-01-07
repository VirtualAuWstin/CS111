
public class PlayerComments
{
	/**
	Each player will be given an initial balance of $10,000
	Each player will be dealt a hand of 5 cards
	Initial wager will start with the first player (first player will be alternated in each round) 
	Our AI player will always initially bet some amount of money > 0
	Our AI player will randomly match a bet of yours
	Our AI player will have some wager threshold over which it will fold, dependent on its hand.
	Wagering will continue back and forth between the two players until both players “stand” (i.e. wager 0)
	Each player will have an opportunity to discard 0 – 5 cards in their hand
	Each player will be dealt new cards, replacing the cards they discarded
	A second round of wagering will occur identical to (3) – (4)
	The game will determine the winner based on the hands and distribute the winnings to each player
	*/
	private double seizeBal = 0;
	// You need to seize the balance, the $$!
	private Hand playerHand;
	
	public PlayerComments(double balance)
	{
		// Am I entering in the balance or the "computer"? Unclear!
		seizeBal = balance;
		playerHand = new Hand();
	}
	
	// Add a card to a hand
	public void deal(Card c)
	{
		// Wait, so isn't this just the add card method from the hand class?
		playerHand.addCard(c);
    }

/**
 * Returns an array of Cards that the Player wishes to discard.
 * Game calls deal() on player for each card that exists in the return value.
 * MS2 Instructions:
 * Print the hand to the terminal using System.out.println
 * Ask the user which cards they would like to discard.
 * User will first enter the number of cards they wish to discard
 * 		followed by the indices, one at a time, of card(s) to discard,
 * Return an array with the appropriate Card objects that have been discarded
 * Remove the Card objects from this player's hand.
 * Use IO.readInt() for all inputs.
 * In cases of error re-ask the user for input.
 * 
 * Example call to discard():
 * This is your hand:
 * 0: Ace of Hearts
 * 1: 2 of Diamonds
 * 2: 5 of Hearts
 * 3: Jack of Spades
 * 4: Ace of Clubs
 * 
 * How many cards would you like to discard?
 * 2 (# of cards person discards)
 * 1 (index of the card being discarded)
 * 2 (index of the card being discarded)
 * 
 * Resultant array contains 2 of Diamonds and 5 of hearts in that order
 * This player's hand will now only have 3 cards
 */
	public Card[] discard()
	{
		Card[] discardArray = new Card[0];
		
		if(playerHand.hasStraightFlush())
		{
			return discardArray;
		}
		else if (playerHand.hasFourOfAKind())
		{
			playerHand.sortByValue();
			if (playerHand.getCard(0).equals(playerHand.getCard(1)))
			{
				Card toBeRemoved = playerHand.getCard(4);
				playerHand.removeCard(4);
				Card[] discardArray1 = {toBeRemoved};
				return discardArray1;
			}
			else
			{
				Card toBeRemoved = playerHand.getCard(0);
				playerHand.removeCard(0);
				Card[] discardArray1 = {toBeRemoved};
				return discardArray1;
			}
		}
		else if(playerHand.hasFullHouse())
		{
			return discardArray;
		}
		else if (playerHand.hasFlush())
		{
			return discardArray;
		}
		else if(playerHand.hasStraight())
		{
			return discardArray;
		}
		else if(playerHand.hasTriplet())
		{
			if (playerHand.getCard(0).equals(playerHand.getCard(1)))
			{
				Card toBeRemoved = playerHand.getCard(4);
				Card toBeRemoved2 = playerHand.getCard(3);
				playerHand.removeCard(4);
				playerHand.removeCard(3);
				Card[] discardArray1 = {toBeRemoved, toBeRemoved2};
				return discardArray1;
			}
			if (playerHand.getCard(1).equals(playerHand.getCard(2)))
			{
				Card toBeRemoved = playerHand.getCard(0);
				Card toBeRemoved2 = playerHand.getCard(4);
				playerHand.removeCard(4);
				playerHand.removeCard(0);
				Card[] discardArray1 = {toBeRemoved, toBeRemoved2};
				return discardArray1;
			}
			else
			{
				Card toBeRemoved = playerHand.getCard(0);
				Card toBeRemoved1 = playerHand.getCard(1);
				playerHand.removeCard(0);
				playerHand.removeCard(1);
				Card[] discardArray1 = {toBeRemoved, toBeRemoved1};
				return discardArray1;
			}
		}
		else
		{
			discardArray = new Card[5];
			for(int i = 0; i < playerHand.getCardCount(); i++)
			{
				Card toBeRemoved = playerHand.getCard(i);
				playerHand.removeCard(i);
				discardArray[i] = toBeRemoved;
			}
			return discardArray;
		}

	
//		// Ask how many cards they want to discard
//		int numDiscard;
//		Card[] discardArray;		// Does this work?
//		System.out.print("How many cards would you like to discard? ");
//		numDiscard = IO.readInt();
//		discardArray = new Card[numDiscard];
//		
//		System.out.print("Enter the index of the cards you would like to discard: ");
//		// Print out hand to show player what to discard
//		for(int i=0; i<numDiscard; i++)
//		{
//			int index = IO.readInt();
//			Card toBeRemoved = playerHand.getCard(index);
//			playerHand.removeCard(index);
//			discardArray[i] = toBeRemoved;
//			System.out.println();
//		}
//		for(int i=0; i<discardArray.length; i++)
//		{
//			System.out.println(discardArray[i].toString());
//		}
//		return discardArray;
}

/**
 * Returns the amount that this player would like to wager
 * Returns -1.0 to fold hand
 * Any non zero wager should immediately be deducted from player's balance.
 * This player's balance can never be below 0 at any time.
 * This player's wager must be >= to the parameter min
 * 
 * MS2 Instructions: Show the user the minimum bet via the terminal
 * aka (System.out.println)
 * 		Ask the user for their wager.
 * Use IO.readDouble() for input.
 * In cases of error re-ask the user for input.
 * 
 * Example call to wager()
 * How much do you want to wager?
 * 200
 * 
 * This will result in this player's balance reduced by 200
 */
	public double wager(double min)
	{
		double wager;
		
		//Logic Tree
		//If min is too much
		if (min > 1000)
			return -1;
		//If you have money to bet
		else if(min < seizeBal)
			wager = min;
		//When computer stops betting you stop too
		else if (min == 0)
			return 0;
		//Broke
		else
			return -1;
		
		//First round
		if (seizeBal == 10000) {
			//Parameter given
			if(min != 0) {
				return wager;
			}
			//Bet whatever you want
			else {
				return 10;
			}
		}
		
		//If not first round
		//If betting 10 will make you have less than 10 dollars, stand
		if (seizeBal - wager <= 10)
			return 0;
		//Otherwise, bet your 10 bucks
		else {
			wager += 10;
			return wager;
		}
		
//		boolean badValue = false;
//		System.out.println("Minimum bet: " + min);
//		System.out.println("Enter how much you would like to wager: ");
//		wager = IO.readDouble();
//		if(wager == -1)
//		{
//			wager = -1;
//		}
//		else if(wager < min)
//		{
//			IO.reportBadInput();
//			badValue = true;
//		}
//		if(wager > seizeBal)
//		{
//			//IO.reportBadInput();
//			//badValue = true;
//		}
//		while(badValue == true)
//		{
//			System.out.println("You entered a bad value, please re-enter: ");
//			wager = IO.readDouble();
//			if (wager >= min && wager<=seizeBal)
//			{
//				badValue = false;
//				seizeBal = seizeBal - wager;
//			}
//		}
		
	}

    // Returns this player's hand
	public Hand showHand()
	{
		// Which one? The cards left over? Or the original hand?
		return playerHand;
	}

    // Returns this player's current balance
	public double getBalance()
	{
		return seizeBal;
	}

    // Increase player's balance by the amount specified in the parameter,
    // then reset player's hand in preparation for next round.
	// Amount will be 0 if player has lost hand
	public void winnings(double amount)
	// What? If amount = 0 if player loses hand, does that mean they go all in every time?
	{
		seizeBal += amount;
		// Set cards back to 5	
		playerHand.clear();
	}
}
