// Calculates fees charged on payment. 3rd program! October 8, 2017

public class Pay_Fee
{
	public static void main(String[] args)
	{
		double cash, fee;
		fee = 0;
		System.out.print("Enter your total payment: ");
		cash = IO.readDouble();
	// How much cash?
	
		if (cash <= 500 && cash > 0)
		{
			fee = 10;
		}
		else if (cash > 500 && cash < 5000)
		{
			if (cash * 0.01 > 20)
			{
				fee = cash * 0.01;
			}
			else
			{
				fee = 20;
			}
		}
		else if (cash >= 5000 && cash < 10000)
		{
			if (cash * 0.02 > 120)
			{
				fee = cash * 0.02;
			}
			else
			{
				fee = 120;
			}
		}
		else if (cash >= 10000)
		{
			if (cash <= 15000)
			{
				fee = (10000 * 0.02) + ((cash-10000) * 0.03);
			// Alex points out in line 43: if 14,000, the 4,000 gets * by 0.03 even though it's the next 5,000
			}
			else if (cash > 15000)
			{
				fee = (10000 * 0.02) + (5000 * 0.03) + ((cash-15000) * 0.04);
			}
		}
		// It's beautiful...

	IO.outputDoubleAnswer(fee);
	}
}
