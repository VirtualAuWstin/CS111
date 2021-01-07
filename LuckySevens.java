// Count the number of sevens that appear within a range of numbers. October 25, 2017

public class LuckySevens
{
	// Hint: Some numbers have more than 1 seven, and not every 7 appears in the ones place.
	// Hint2: Nested loops are helpful
	public static void main(String[] args)
	{
		// Well, no sevens so far...
		int sevens = 0;
		
		// Ask user for lower end of range
		int lowerEnd = 0;
		System.out.print("Enter the lower end of the range: ");
		lowerEnd = IO.readInt();
		
		// Ask user for upper end of range
		int upperEnd = 0;
		System.out.print("Enter the upper end of the range: ");
		upperEnd = IO.readInt();
	
		if (lowerEnd > upperEnd || lowerEnd == upperEnd)
		// Woah. I just used an OR statement! Sick!
		{
			System.out.print("Your range makes no sense");
			System.out.println();
			IO.reportBadInput();
		}
		else
		{
			int i = 0;
			for (i=lowerEnd; i<=upperEnd; i++)
			{
				int calculations = i;
				if (calculations < 0)
				{
					calculations = calculations * (-1);
				}
				if (calculations%10 == 7)
				{
					sevens ++;			
				}
				// Aghhh! Doesn't count for the sevens in the ones place :(
			while (calculations > 0)
			{
				calculations = calculations/10;
				if (calculations%10 ==7)
				// What makes 77 freakin' work!
				{
					sevens ++;
				}
			}
			}
		}
	System.out.println("And the number of sevens is: ");
	IO.outputIntAnswer(sevens);
	}
}