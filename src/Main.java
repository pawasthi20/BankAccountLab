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
		
		System.out.println("Would you like to add an account, make a transaction, or terminate the program?");
		in.nextLine();
	}
}