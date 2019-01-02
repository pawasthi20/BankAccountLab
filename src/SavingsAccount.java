/**
 * 
 * @author pawasthi20
 *
 */
public class SavingsAccount extends BankAccount
{
	//Fields
	private double intRate;
	private double MIN_BAL;
	private double MIN_BAL_FEE;
	
	//Constructors
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n, b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	//Methods
	public void withdraw(double amt)
	{
		if(getBalance() <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			balance -= amt;
			balance -= MIN_BAL_FEE;
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
	public void addInterest()
	{
		Object balance = balance + (intRate*balance);
	}
	public void endOfMonthUpdate()
	{
		balance.addInterest();
	}
} 