// Outputs the biggest and smallest numbers in a list of numbers entered by the user. October 24, 2017

public class SmallestLargest
{
	public static void main(String[] args)
	{
		System.out.print("Enter a terminating value: ");
		double terminator = IO.readDouble();
		// We've got a terminating value
		int count = 0;
		// So smallest and largest will not be output if there are no numbers in list!

		System.out.println("Enter the numbers: ");
		double number = IO.readDouble();
		double smallest = number;
		double largest = number;
		count ++;
		// So that the program will recognize when there is at least one number!
		
		if (number == terminator)
		{
			System.out.println("You did not enter at least 1 number value!");
			IO.reportBadInput();
			// Report bad input via IO.reportBadInput() and exit on error
		}
		
		while (number!=terminator)
			// Until user types in terminator, they keep entering values
			// Haha! So that's how you do it >> terminate the sequence
		{
			number = IO.readDouble();
			// Keep track of list >> Don't need System.out cause #s appear in green
			// Must be at least one number in the list >> No problem, already 1 # going into list
			count ++;
			
			if (number < smallest)
			// Compare values to output the smallest value
			{
				if(number!=terminator)
				// So that the terminator itself won't be a value
				{
					smallest = number;
				}
			}
			
			else if (number > largest)
			// Compare values to output the biggest value
			{
				if(number!=terminator)
				{
					largest = number;
				}
			}
			
		}
		
		if(count > 1)
		{
			System.out.println("Smallest number: ");
			IO.outputDoubleAnswer(smallest);
			System.out.println("Largest number: ");
			IO.outputDoubleAnswer(largest);
		}
	}
}
