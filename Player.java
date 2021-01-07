public class Player
{
	private double seizeBal = 0;
	private Hand playerHand;
	
	public Player(double balance)
	{
		seizeBal = balance;
		playerHand = new Hand();
	}
	
	public void deal(Card c)
	{
		playerHand.addCard(c);
    }

	public Card[] discard()
	{
		Card[] discardArray = new Card[1];
		
		discardArray[0] = playerHand.getCard(0);
		playerHand.removeCard(0);
		return discardArray;
		/*
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
		*/
	}
	
	public double wager(double min)
	{
		return min;
		
		/*
		double wager;
		
		if (min > 1000)
			return -1;
		else if(min < seizeBal)
			wager = min;
		else if (min == 0)
			return 0;
		else
			return -1;
		
		if (seizeBal == 10000) {
			if(min != 0) {
				return wager;
			}
			else {
				return 10;
			}
		}
		
		if (seizeBal - wager <= 10)
			return 0;
		else {
			wager += 10;
			return wager;
		}
		*/
	}

	public Hand showHand()
	{
		return playerHand;
	}

	public double getBalance()
	{
		return seizeBal;
	}
	
	public void winnings(double amount)
	{
		seizeBal += amount;
		playerHand.clear();
	}
}