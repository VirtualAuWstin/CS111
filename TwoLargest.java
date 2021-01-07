// Takes a set of numbers and determines which are the two largest. October 25, 2017
// Apparently still have problems with the code

public class TwoLargest
{
	public static void main(String[] args)
	{
		// First task: Ask for a terminating value
		System.out.print("Enter THE terminating value: ");
		double terminator = IO.readDouble();
		// The terminator's back!
		double input;
		// Apparently declaring double input = 0 vs.double input; makes a big difference. :o
		
		int count = 0;
		
		// Enter the sequence of numbers
		System.out.print("Enter the first number: ");
		input = IO.readDouble();
		if (input != terminator)
		{
			count++;
		}
		// That's one entry down, one more to go! (hard part)
		double Largest = input;
		double secondLargest = Largest;
		
		while (input == terminator)
		// Missed this step the first submission: This step keeps the user in a loop until they get it right!
		// For those that typed in terminator values back to back
		{
			System.out.print("You need to enter a value besides the terminator!");
			System.out.println();
			IO.reportBadInput();
          
            // Enter the sequence of numbers
			System.out.println("Try again: ");
			input = IO.readDouble();
			if (input != terminator)
			{
				count++;
			}
			if (input >= Largest)
			{
				secondLargest = Largest;
				Largest = input;
			}
			else
			{
				secondLargest = input;
			}
		}
		
		while (input != terminator)
		// Only works if input is not equal to terminator value
			// BUT... if only one value is entered, still a problem as program still runs
		{
			input = IO.readDouble();
			count ++;
			// To solve the "only enter 1 number" problem
			
			if (input >= Largest)
			// Compute the largest and second-largest real number (could be the same #)
			{
				if (input != terminator)
				// To prevent the terminator from being the largest number!
				{
					secondLargest = Largest;
					Largest = input;
				}
			}
		}
		
		// Final step: Output the two largest numbers!
		// Still, what if count != 2? Can I get it to run again?
		if (count >2)
		{
			System.out.println("Largest number: ");
			IO.outputDoubleAnswer(Largest);
			System.out.println("Second largest number: ");
			IO.outputDoubleAnswer(secondLargest);
		}
		else
		{
			IO.reportBadInput();
			System.out.println("Keep trying: ");
			input = IO.readDouble();
			while (input != terminator)
			{
				input = IO.readDouble();
				if (input >= Largest)
				{
					if (input != terminator)
					{
						secondLargest = Largest;
						Largest = input;
					}
				}
			}
			System.out.println("Largest number: ");
			IO.outputDoubleAnswer(Largest);
			System.out.println("Second largest number: ");
			IO.outputDoubleAnswer(secondLargest);
		}
	}
}