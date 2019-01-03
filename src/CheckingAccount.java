/**
 * 
 * @author pawasthi20
 *
 */
public class CheckingAccount extends BankAccount
{
	final double OVER_DRAFT_FEE;
	final double TRANSACTION_FEE;
	final double FREE_TRANS;
	
	//Fields
	private int numTransactions;
	
	//Constructors
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(n);
		OVER_DRAFT_FEE = odf;
		FREE_TRANS = freeTrans;
		TRANSACTION_FEE = tf;
	}
	
	//Methods
	public void Deposit(double amt) 
	{
		if(amt < 0 || (numTransactions >= FREE_TRANS && amt < TRANSACTION_FEE))
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.deposit(amt);
			if(numTransactions >= FREE_TRANS) super.withdraw(TRANSACTION_FEE);
			numTransactions++;
		}
	}
	public void withdraw(double amt)
	{
		if(amt < 0 || getBalance() < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.withdraw(amt);
			if(numTransactions >= FREE_TRANS) super.withdraw(TRANSACTION_FEE);
			if(getBalance() < 0) super.withdraw(OVER_DRAFT_FEE);
			numTransactions++;
		}
	}
	public void trasnfer(BankAccount other, double amt)
	{
		double lFee = 0;
		if(numTransactions >= FREE_TRANS) lFee = TRANSACTION_FEE;
		
		if (getName().equals(other.getName()) && getBalance() >= (amt + lFee))
		{
			super.trasnfer(other, amt);
			super.withdraw(lFee);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
}