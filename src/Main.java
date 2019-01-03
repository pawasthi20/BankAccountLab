import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author pawasthi20
 *
 */
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		//Array List
		ArrayList <String> BankAccounts = new ArrayList<String>();	
		
		//Variables
		int OVER_DRAFT_FEE = 15;
		double RATE = .0025;
		double TRANSACTION_FEE = 1.5;
		int MIN_BAL = 300;
		int MIN_BAL_FEE = 10;
		int FREE_TRANSACTIONS = 10;
		
		//Loop
		while(!in.equals("terminate"))
		{
			//Prompt
			System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
			in.nextLine();
			
			//Add Account
			if(in.equals("add"))
			{
				System.out.println("Would you like to create a checking or savings account?");
				if(in.equals("checking"))
				{
					 BankAccounts.add(//CheckingAccount)
				}
				if(in.equals("savings"))
				{
					 BankAccounts.add(//SavingsAccount)
				}
			}
			//Make Transaction
			if(in.equals("transaction"))
			{
				System.out.println("Would you like to withdraw, deposit, transfer, or get account number?");
				
			}
		}
	}
}