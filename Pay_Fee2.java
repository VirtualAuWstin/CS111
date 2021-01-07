public class Pay_Fee2
// ^^ This
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
			if (cash == 10000)
			{
				fee = (10000 * 0.02);
			}
			else if (cash > 10000 && cash <= 15000)
			{
				fee = (10000 * 0.02) + (5000* 0.03);
			}
			else if (cash > 15000)
			{
				fee = (10000 * 0.02) + (5000 * 0.03) + ((cash-15000) * 0.04);
			}
		}

	IO.outputDoubleAnswer(fee);
	}
}
