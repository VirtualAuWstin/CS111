// This program multiplies two numbers. First code on my own! October 7, 2017

public class Multiply
{
	public static void main(String[] args)
	{
		int a, b, c;
		
		System.out.print("Enter value of first #: ");
		a = IO.readInt();
		
		System.out.print("Enter value of second #: ");
		b = IO.readInt();
		
		c = a*b; // Does the one-step multiplication
		IO.outputIntAnswer(c);
	}

}
