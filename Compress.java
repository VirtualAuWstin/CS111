// Takes a string, compresses it using RLE, and returns the compressed string. Wednesday, November 8, 2017

public class Compress
{
	public static void main(String[] args)
	{
		String normal;		// Yeah, why not keep it that way? >> original
		System.out.print("Please type in the string: ");
		normal = IO.readString();
		
		IO.outputStringAnswer(compress(normal));
	}

	public static String compress(String original)
	{
		String shortened = "";		// What determines my grade
		// The no space / space thing nearly screwed me over
		int number = 1;				// A number that replaces letters
		// Why start with 1 though? I did it just so code works, but...
		for (int scanner=0; scanner<original.length(); scanner++)
		{
			if (scanner+1 == original.length())		// To fix the last sequence dilemma
			{
				if (original.charAt(scanner) == original.charAt(scanner-1)) // Same as before, need to +1
				{
					shortened += number + "" + original.charAt(scanner);
				// this >> "" gets me SO angry- changes so much stuff if you don't have it
				}
				else		// Not same as before, just add letter
				{
					shortened += original.charAt(scanner);
				}
				// Nailed down the output for the end sequence!
			}
			
			else if (original.charAt(scanner) == original.charAt(scanner+1)) // For "normal" operations
			{
				number++;
			}
			
			else // So that 1 does not get printed out
			{
				if(number==1)
				{
					shortened+= "" + original.charAt(scanner);
				}
				else
				{
					shortened += number + "" + original.charAt(scanner);
				}
				number = 1;
			}
		}
		return shortened;
	}
}

/*

Main method will be ignored. Use this method:
public static String compress (String original){ }
 
Run-length encoding (RLE) is a simple "compression algorithm"
(takes a block of data and reduces its size)
Replacing repetitive sequences of identical data items with short "tokens" that represent entire sequences.
Applying RLE to a string involves finding sequences in the string where the same character repeats.

Each such sequence should be replaced by a "token" consisting of:
the number of characters in the sequence
the repeating character
If a character does not repeat, it should be left alone.

For example:
qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT
After applying the RLE algorithm:
q9w5e2rt5y4qw2Er3T

Case matters- uppercase and lowercase characters should be considered distinct.
You may assume that there are no digit characters in the input string.
There are no other restrictions on the input - it may contain spaces or punctuation.
There is no need to treat non-letter characters any differently from letters.
*/