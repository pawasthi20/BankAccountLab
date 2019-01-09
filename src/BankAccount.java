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
	/**
	 * @param amt
	 */
	public void deposit(double amt) 
	{
		if(amt < 0 )
		{
			throw new IllegalArgumentException();
		}
		balance += amt;
	}
	/**
	 * @param amt
	 */
	public void withdraw(double amt)
	{
		
		balance -= amt;
	}
	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * @return accNum
	 */
	public int getAccNum()
	{
		return accNum;
	}
	public abstract void endOfMonthUpdate();
	/**
	 * 
	 * @param other
	 * @param amt
	 */
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	}
	/**
	 * @return "Account Number: " + accNum + "\t" + "Accountholder: " + name + "\t" + "Balance: " + balance;
	 */
	public String toString()
	{
		return "Account Number: " + accNum + "\t" + "Accountholder: " + name + "\t" + "Balance: " + balance;
	}
}