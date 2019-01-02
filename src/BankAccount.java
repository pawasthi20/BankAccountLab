/**
 * 
 * @author pawasthi20
 *
 */
public abstract class BankAccount 
{
	static int nextAccNum;
	
	//Fields
	private String name;
	private int accNum;
	private double balance;
	
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
	public void deposit(double amt) 
	{
		balance += amt;
	}
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	public String getName()
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
		withdraw(amt);
		other.deposit(amt);
	}
	public String toString()
	{
		return accNum + "\t" + name + "\t" + balance;
	}
}