/**
 * 
 * @author pawasthi20
 *
 */
public abstract class BankAccount 
{
	static int nextAccNum;
	
	//Fields
	String name;
	int accNum;
	double balance;
	
	//Constructors
	public BankAccount(String n)
	{
		name = n;
		accNum = nextAccNum;
		balance = 0;
	}
	public BankAccount(String n, double b)
	{
		name = n;
		accNum = nextAccNum;
		balance = b;
	}
	
	//Methods
	public void Deposit(double amt) 
	{
		balance += amt;
	}
	public void Withdraw(double amt)
	{
		balance -= amt;
	}
	public String GetName()
	{
		return name;
	}
	public double getBalance()
	{
		return balance;
	}
	public abstract void endOfMonthUpdate();
	public void trasnfer(BankAccount other, double amt)
	{
		Withdraw(amt);
		other.Deposit(amt);
	}
	public String toString()
	{
		return accNum + "\t" + name + "\t" + balance;
	}
}