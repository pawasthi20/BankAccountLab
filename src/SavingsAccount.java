/**
 * 
 * @author pawasthi20
 *
 */
public class SavingsAccount extends BankAccount
{
	//Fields
	private double intRate;
	final double MIN_BAL;
	final double MIN_BAL_FEE;
	
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
		double lFee = 0;
		if(getBalance() - amt < MIN_BAL)
		{
			lFee = MIN_BAL_FEE;
		}				
		if(amt < 0 || (getBalance() - amt) < 0)
		{
			//System.out.println("debug:" + getBalance() + " " + " " + amt + " " + lFee);
			throw new IllegalArgumentException();
		}
		else
		{
			super.withdraw(amt);
			super.withdraw(lFee);
		}
	}
	public void transfer(BankAccount other, double amt)
	{
		double lFee = 0;
		if(getBalance() - amt < MIN_BAL)
		{
			lFee = MIN_BAL_FEE;
		}
		if(getBalance() - (amt) < 0 || !getName().equals(other.getName()) || amt < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.transfer(other, amt);
			super.withdraw(lFee);
		}	
	}
	public void addInterest()
	{
		super.deposit(intRate * getBalance());
	}
	public void endOfMonthUpdate()
	{
		addInterest();
	}
} 