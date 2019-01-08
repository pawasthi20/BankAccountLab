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
		ArrayList <BankAccount> BankAccounts = new ArrayList<BankAccount>();	
		
		//Variables
		int OVER_DRAFT_FEE = 15;
		double RATE = .0025;
		double TRANSACTION_FEE = 1.5;
		int MIN_BAL = 300;
		int MIN_BAL_FEE = 10;
		int FREE_TRANSACTIONS = 10;
		String input1 = "";
		String name = "";
		double intBal = 0;
		String input2 = "";
		int accNum = 0;
		int len = 0;
		
		//Loop
		while(!input1.equals("3"))
		{
			//Prompt
			System.out.println("Type 1 to add an account, 2 to make a transaction, or 3 to terminate the program?");
			input1 = in.nextLine();
			switch (input1) 
			{
				//Add Account
				case "1":
					System.out.println("Enter accountholder's name:");
					name = in.nextLine();
					System.out.println("Enter initial balance:");
					input2 = in.nextLine();
					if (isNumeric(input2))
					{
						intBal = Double.valueOf(input2);
					}
					else
					{
						System.out.println("Invalid entry. Please retry");
	            		break;
					}
            		System.out.println("Type 1 checking or 2 for savings account");
					input2 = in.nextLine();
    				if (input2.equals("1"))
    				{
    					CheckingAccount newAccount = new CheckingAccount(name, intBal, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS);
    					BankAccounts.add(newAccount);
    					System.out.println("Successfully added checking account: " + newAccount.toString());
    				}
    				else if (input2.equals("2"))
    				{
    					SavingsAccount newAccount = new SavingsAccount(name, intBal, RATE, MIN_BAL, MIN_BAL_FEE);
    					BankAccounts.add(newAccount);
    					System.out.println("Successfully added savings account: " + newAccount.toString());
    				}
    				else
    				{
    					System.out.println("Invalid entry. Please retry");
	            		break;
    				}
            		break;
            		
        		//Make Transaction
            	case "2":
    				System.out.println("Type 1 to withdraw, 2 to deposit, 3 to transfer, or 4 to get account number?");
					input2 = in.nextLine();
					switch (input2) 
					{
						//Withdraw
						case "1":
							BankAccount foundAccount = GetAccount(BankAccounts);							
						    if (foundAccount != null)
						    {
						    	System.out.println("Enter withdrawal amount:");
								input2 = in.nextLine();
								if (isNumeric(input2))
								{
									intBal = Double.valueOf(input2);
								}
								else
								{
									System.out.println("Invalid entry. Please retry");
				            		break;
								}
								try
								{
									foundAccount.withdraw(intBal);
								}
								catch(IllegalArgumentException e)
								{
									System.out.println("Transaction not authorized. Please retry");
				            		break;
								}
								System.out.println("Successfully withdrawn. New balance: " + foundAccount.toString());
						    } 
						    else 
						    {
						    	System.out.println("Account not found. Please retry");
						    }		    	
							break;
						//Deposit
						case "2":
							BankAccount foundAccount1 = GetAccount(BankAccounts);							
						    if (foundAccount1 != null)
						    {							
						    	System.out.println("Enter deposit amount:");
								input2 = in.nextLine();
								if (isNumeric(input2))
								{
									intBal = Double.valueOf(input2);
								}
								else
								{
									System.out.println("Invalid entry. Please retry");
						        	break;
								}
								try
								{
									foundAccount1.deposit(intBal);
								}
								catch(IllegalArgumentException e)
								{
									System.out.println("Transaction not authorized. Please retry");
				            		break;
								}
								System.out.println("Successfully deposited. New balance: " + foundAccount1.toString());
						    } 
						    else 
						    {
						    	System.out.println("Account not found. Please retry");
						    }
							break;
						//Transfer
						case "3":
							BankAccount foundAccount2 = GetAccount(BankAccounts);							
						    if (foundAccount2 != null)
						    {	
						    	System.out.println("Enter account the target number now.");
						    	BankAccount foundAccount3 = GetAccount(BankAccounts);							
							    if (foundAccount3 != null)
							    {
							    	System.out.println("Enter transfer amount:");
									input2 = in.nextLine();
									if (isNumeric(input2))
									{
										intBal = Double.valueOf(input2);
									}
									else
									{
										System.out.println("Invalid entry. Please retry");
					            		break;
									}
									try
									{
										foundAccount2.transfer(foundAccount3, intBal);
									}
									catch(IllegalArgumentException e)
									{
										System.out.println("Transaction not authorized. Please retry");
					            		break;
									}
									System.out.println("Successfully withdrawn. New balance: " + foundAccount2.toString());
									System.out.println("Successfully deposited. New balance: " + foundAccount3.toString());
							    } 
							    else 
							    {
							    	System.out.println("Target Account not found. Please retry");
							    }
						    }
						    else 
						    {
						    	System.out.println("Account not found. Please retry");
						    }
							break;	
						//List accounts by name
						case "4":
							GetAccountbyName(BankAccounts);	
							break;
						default: 
		            		System.out.println("Invalid entry. Please retry");
		            		break;
					}	
					break;
            	case "3":
            		System.out.println("Cya later.");
    				break;
            	default: 
            		System.out.println("Invalid entry. Please retry");
            		break;
			}		
		}
		in.close();
	}
	
	//Methods
	private static boolean isNumeric(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	private static boolean isint(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	private static BankAccount GetAccount(ArrayList <BankAccount> pBankAccounts)
	{
		int accNum = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter account number:");
		String input2 = in.nextLine();
		//in.close();
		if (isint(input2))
		{
			accNum = Integer.valueOf(input2);
		}
		else
		{
			System.out.println("Invalid entry. Please retry");
			return null;
		}
		int len = pBankAccounts.size();
		for(int i=0; i<len; i++)
	    if (accNum == pBankAccounts.get(i).getAccNum())
	    {
			System.out.println("Successfully found account: " + pBankAccounts.get(i).toString());
			return pBankAccounts.get(i);
	    }
		return null;	
	}
	private static void GetAccountbyName(ArrayList <BankAccount> pBankAccounts)
	{
		Scanner in = new Scanner(System.in);
		boolean found = false;
		System.out.println("Enter accountholder's name:");
		String input2 = in.nextLine();
		//in.close();
		if (input2.isEmpty())
		{
			System.out.println("Empty entry. Please retry");
			return;
		}
		int len = pBankAccounts.size();
		for(int i=0; i<len; i++) {
		    if (input2.equalsIgnoreCase(pBankAccounts.get(i).getName()))
		    {
		    	if (pBankAccounts.get(i) instanceof CheckingAccount) 
		    	{
		    		System.out.println("Successfully found checking account: " + pBankAccounts.get(i).toString());
		    		found = true;
		    	}
		    	else 
		    	{
		    		System.out.println("Successfully found saving account: " + pBankAccounts.get(i).toString());
		    		found = true;
		    	}
		    }	
		}
		if (!found)
		{
			System.out.println("Account not found for this name. Please retry");
		}
	}	
}