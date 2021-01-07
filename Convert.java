// Takes a string and a boolean, converts string to decimal integer equivalent, return the resulting integer.

public class Convert
{
	public static void main(String[] args)
	{
		String binary;		// The normal # or weird sequence
		System.out.print("Please enter the string of numbers: ");
		binary = IO.readString();
		boolean intNot;		// Is it a signed integer or not?
		System.out.print("YES for signed (weird one), NO if unsigned: ");
		intNot = IO.readBoolean();
		
		IO.outputIntAnswer(convert(binary, intNot));
	}

	public static int convert(String binaryString, boolean signBit)
	{
		int newSequence = 0;		// Ha! Put it in the if statement before and it didn't work
		if (signBit == false)		// Because it would suck if signBit were true
		{
			for(int scan=0; scan<binaryString.length(); scan++)
			{
				if (binaryString.charAt(scan) == '1')
				{
					newSequence += Math.pow(2, binaryString.length()-1-scan);
					// Key part of this program (formula from first day, slightly modified)
				}
			}
		}
		else if (signBit == true)
		// Why do you want to make my life so hard???
		{
			if (binaryString.charAt(0) == '1')
			{
				for(int scan=1; scan<binaryString.length(); scan++)
				{
					if (binaryString.charAt(scan) == '1')
					{
					newSequence += -Math.pow(2, binaryString.length()-1-scan);
					}
				}
			}
			else
			{
				for(int scan=0; scan<binaryString.length(); scan++)
				{
					if (binaryString.charAt(scan) == '1')
					{
					newSequence += Math.pow(2, binaryString.length()-1-scan);
					// As what would normally happen
					}
				}
			}
		}
		else
		{
			IO.reportBadInput();
		}
		return newSequence;
	}
}

/*

Main method will be ignored. Use this method:
public static int convert (String binaryString, boolean signBit){ }

*/