package Account;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Question7
{
	public static void main(String[] args)
			throws IOException, InterruptedException
	{
		Scanner in = new Scanner(System.in);
		//Checking Account object:
		System.out.print("Enter amount to deposit in your new Checking Account: ");
		double a = in.nextDouble();

		CheckingAccount account1 = new CheckingAccount(354316, a);
		System.out.println("\nEnter 1 for deposit.\nEnter 2 for withdrawal.\nEnter 3 for checking current balance.");
		switch (System.in.read())
		{
		case '1':
		{
			System.out.print("Enter amount to deposit: ");
			double am = in.nextDouble();
			if(!account1.deposit(am))
			{
				System.err.println("ERROR! You entered negative amount!");
			}
			else
			{
				System.out.println("Deposited successfully!");
				System.out.println("New balance: " + account1.getBalance());
			}
			break;
		}
		case '2':
		{
			System.out.print("Enter amount to withdraw: ");
			double w = in.nextDouble();
			if(account1.withdraw(w))
			{
				System.out.println("Withdrawn successfully!");
				System.out.println("New balance: " + account1.getBalance());
			}
			break;
		}
		case '3':
		{
			System.out.println("Your current balance is " + account1.getBalance());
			break;
		}
		default:
			System.err.println("INVALID ENTRY!");
		}

		System.out.print(
				"\nEnter amount to deposit in your new Saving Account: ");
		double a2 = in.nextDouble();
		//Saving Account object:
		SavingAccount account2 = new SavingAccount(468247, a2);
		System.out.println("\nEnter 1 for deposit.\nEnter 2 for withdrawal.\nEnter 3 for checking current balance.");
		switch (System.in.read())
		{
		case '1':
		{
			System.out.print("Enter amount to deposit: ");
			double am = in.nextDouble();
			if(!account2.deposit(am))
			{
				System.err.println("ERROR! You entered negative amount!");
			}
			else
			{
				System.out.println("Deposited successfully!");
				System.out.println("New balance: " + account2.getBalance());
			}
			break;
		}
		case '2':
		{
			System.out.print("Enter amount to withdraw: ");
			double w = in.nextDouble();
			if(!account2.withdraw(w))
			{
				System.err.println("Insufficient balance!");
			}
			else
			{
				System.out.println("Withdrawn successfully!");
				System.out.println("New balance: " + account2.getBalance());
			}
			break;
		}
		case '3':
		{
			System.out.println("Your current balance is " + account2.getBalance());
			break;
		}
		default:
			System.err.println("INVALID ENTRY!");
		}
	}
}

class Account
{
	protected int accountNo;
	protected double balance;

	Account(int n, double bal)
	{
		accountNo = n;
		System.out.println("Your account number is "+accountNo);
		balance = bal;
	}

	boolean deposit(double amount) throws InterruptedException
	{
		if (amount<0)
		{
			return false;
		}
		else
		{
			System.out.println("Deposit amount: " + amount);
			System.out.print("Depositing " + amount + " ");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.println(".");
			balance += amount;
			return true;
		}
	}

	double getBalance()
	{
		return balance;
	}
}

class CheckingAccount extends Account
{
	CheckingAccount(int n, double bal)
	{
		super(n, bal);
	}

	boolean withdraw(double amount) throws InterruptedException
	{
		System.out.println("Current balance: "+super.balance);
		int overdraft = 100;
		if(amount>super.balance)
		{
			System.err.println("Insufficient balance!");
			System.out.print("Using overdraft protection.");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(600);
			System.out.println(".\n");
			super.balance += overdraft;
			if (amount>super.balance)
			{
				System.err.println("Overdraft source insufficient!");
				return false;
			}
			else
			{
				System.out.print("Withdrawing " + amount + " ");
				TimeUnit.MILLISECONDS.sleep(600);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(600);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(600);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(600);
				System.out.print(".");
				TimeUnit.MILLISECONDS.sleep(600);
				System.out.println(".");
				super.balance -= amount;
				return true;
			}
		}
		else
		{
			super.balance -= amount;
			return true;
		}
	}
}

class SavingAccount extends Account
{
	SavingAccount(int n, double bal)
	{
		super(n, bal);
	}

	boolean withdraw(double amount)
	{
		System.out.println("Current balance: "+super.balance);
		if(amount>super.balance)
		{
			return false;
		}
		else
		{
			super.balance -= amount;
			System.out.println("New balance: "+super.balance);
			return true;
		}
	}
}