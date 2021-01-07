// Counts the number of words in a sentence that are equal to or less than maxLength. Wednesday, November 8, 2017

public class WordCount
{
	public static void main(String[] args)
	{
		int max;				// Max length for word to be counted >> maxLength
		String sentence;		// The actual sentence >> original
	
		System.out.print("Please enter the max length of string: ");
		max = IO.readInt();
		System.out.print("Please enter the sentence: ");
		sentence = IO.readString();
		
		// Whew. That was only the easy part.
		
		IO.outputIntAnswer(countWords(sentence, max));
	}

	public static int countWords(String original, int maxLength)
	{
		int check=0;			// value used to compare to maxLength
		int wordCount=0;		// What I'm getting graded on
		
		for (int byWord=0; byWord<original.length(); byWord++)
		{
			if ((original.charAt(byWord)>='a' && original.charAt(byWord)<='z')
			 || (original.charAt(byWord)>='A' && original.charAt(byWord)<='Z'))
			{
				check++; // Literally counts if something is a letter
				System.out.print(original.charAt(byWord));
				if (byWord+1 == original.length() && check<=maxLength)	// In order to check the last word
				{
					wordCount++;
				}
			}
			
			else if (byWord+1 == original.length() && check<=maxLength)	// In order to check the last word
			{
				wordCount++;
			}
			
			else if (original.charAt(byWord) == ' ')
			{
				if(check<=maxLength && check!=0)
				{
					wordCount++;
				}
				check=0;
			}
		}
		return wordCount;
	}
}

/*

Main method will be ignored. Use this method:
public static int countWords(String original, int maxLength){ }

Your method should count the number of words in the sentence that meet or are less than maxLength (in letters).
For example, if the maxLength length given is 4, your program should only count words that are at most 4 letters long.

Words will be separated by one or more spaces.
Non-letter characters (spaces, punctuation, digits, etc.) may be present, but should not count towards the length of words.

Hint: Write method that counts number of letters (and ignores punctuation) in a string holding a single word w/o spaces.
In your countWords method, break the input string up into words and send each one to your method.

*/