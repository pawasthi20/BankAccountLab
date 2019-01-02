/**
 * 
 * @author pawasthi20
 *
 */
public abstract class CheckingAccount extends BankAccount
{
	double OVER_DRAFT_FEE;
	double TRANSACTION_FEE;
	double FREE_TRANS;
	
	//Fields
	private int numTransactions;
	
	//Constructors
	public checkingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		name = n;
		balance = b;
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	public checkingAccount(String n, double odf, double tf, int freeTrans)
	{
		String name = n;
		double balance = 0;
		OVER_DRAFT_FEE = odf;
		FREE_TRANS = freeTrans;
		TRANSACTION_FEE = tf;
	}
	
	//Methods
	public void Deposit(double amt, double balance) 
	{
		if(getBalance() <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			balance += amt;
			balance -= TRANSACTION_FEE;
			numTransactions++;
		}
	}
	public void withdraw(double amt)
	{
		if(getBalance() <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.withdraw(amt);
			numTransactions++;
		}
	}
	public void trasnfer(BankAccount other, double amt)
	{
		if (getName().equals(other.getName()))
		{
			withdraw(amt);
			other.deposit(amt);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	public abstract void endOfMonthUpdate();
	{
		numTransactions = 0;
	}
}