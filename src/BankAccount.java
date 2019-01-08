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
		nextAccNum++;
	}
	public BankAccount(String n, double b)
	{
		name = n;
		accNum = nextAccNum;
		balance = b;
		nextAccNum++;
	}
	
	//Methods
	public void deposit(double amt) 
	{
		if(amt < 0 )
		{
			throw new IllegalArgumentException();
		}
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
	public int getAccNum()
	{
		return accNum;
	}
	public abstract void endOfMonthUpdate();
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	}
	public String toString()
	{
		return "Account Number: " + accNum + "\t" + "Accountholder: " + name + "\t" + "Balance: " + balance;
	}
}