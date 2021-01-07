// Deja vu of Lucky Sevens all over again? I think not.
// It's 2:15 AM, gotta... get... this... done. October 27, 2017

public class LuckyNines
{
	public static void main(String[] args)
	{
		// Ask user for lower end of range
		int lowerEnd = 0;
		System.out.print("Enter the lower end of the range: ");
		lowerEnd = IO.readInt();
				
		// Ask user for upper end of range
		int upperEnd = 0;
		System.out.print("Enter the upper end of the range: ");
		upperEnd = IO.readInt();
		
		//Deja vu all over again? I think not.
	
	IO.outputIntAnswer(countLuckyNines(lowerEnd, upperEnd));
	// Is THIS how you call a method? I hate it! Took me 30 minutes to figure out!! >:(
	}

	public static int countLuckyNines (int lowerEnd, int upperEnd)
	{
		int nines = 0;
		// So just go through and switch all the 7s to 9s ? Simple enough? Almost too easy...?
		int i = 0;
		for (i=lowerEnd; i<=upperEnd; i++)
		{
			int calculations = i;
			if (calculations < 0)
			{
				calculations = calculations * (-1);
			}
			if (calculations%10 == 9)
			{
				nines ++;			
			}
			while (calculations > 0)
			{
				calculations = calculations/10;
				if (calculations%10 ==9)
				{
					nines ++;
				}
			}
		}
		if (lowerEnd > upperEnd || lowerEnd == upperEnd)
		{
			System.out.print("Your range makes no sense so... minus 1");
			System.out.println();
			return nines-1;
		}
		else
		{
			return nines;
		}
	}
}
