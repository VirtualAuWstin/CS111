// This useless program translates an English word into Pig Latin. Tuesday, November 7, 2017

public class PigLatin
{
	public static void main(String[] args)
	{
		String English;			// What normal people would say >> original
		System.out.print("Please type in an English word: ");
		English = IO.readString();
		
		IO.outputStringAnswer(translate(English));
		// THIS WILL BE IGNORED
		// BUT THEN WTH do we return the value to if the grader won't read it? Makes no sense.
	}

	public static String translate (String original)
	{
		String PigSpeak= " ";			// The final result
		
		// Let's do vowels first since that's easier
		if (original.charAt(0) == 'A' || original.charAt(0) == 'E' || original.charAt(0) == 'I'
		 || original.charAt(0) == 'O' || original.charAt(0) == 'U'
		 || original.charAt(0) == 'a' || original.charAt(0) == 'e' || original.charAt(0) == 'i'
		 || original.charAt(0) == 'o' || original.charAt(0) == 'u')
		// There's got to be an easier way to do this! V- use ' ' instead of " "
		{
			PigSpeak = original + "vai";
		}
		
		else // V- Instead of stating if (English.charAt(0) != all the vowels) again
		{
			PigSpeak = original.substring(1) + original.charAt(0) + "ai";
		}
		
		return PigSpeak;
	}
}

/*

Graders will ignore the main method. Use the following method:
public static String translate (String original){}

A word in English is "translated" into Pig Latin using the following rules:
If the English word begins with a consonant (Y included):
	Move the consonant to the end of the word and add "ai".
If the English word begins with a vowel (A, E, I, O, or U):
	Add "vai" to the end of the word.

Write your method so that it returns the pig latin translated original string.
Assume that the input does not contain digits, punctuation, or spaces.
The input may be in any combination of uppercase or lowercase.
The case of your output does not matter.

*/