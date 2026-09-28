
import java.util.*;
class InsufficientBalanceException extends Exception
{
    public InsufficientBalanceException(String message)
    {
        super(message);
    }
}
class Account
{
    String accountHolderName;
    double accountBalance;
    public Account(String accountHolderName, double accountBalance)
    {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }
    public void display()
    {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: Rs." + accountBalance);
    }
    public void withdraw(double amount) throws InsufficientBalanceException
    {
        if(amount <= 0)
        {
            System.out.println("Enter a valid withdrawal amount.");
        }
        else if(amount > accountBalance)
        {
            throw new InsufficientBalanceException(
                "Insufficient Balance! Available balance is Rs." + accountBalance
            );
        }
        else
        {
            accountBalance = accountBalance - amount;

            System.out.println("Withdrawal successful!");
            System.out.println("Amount withdrawn: Rs." + amount);
            System.out.println("Remaining balance: Rs." + accountBalance);
        }
    }
}
public class exceptionatm
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Account account = new Account("Abhindra", 100000);
        System.out.println("========== ATM WITHDRAWAL SYSTEM ==========");
        account.display();
        System.out.println("--------------------------------------------");
        System.out.print("Enter amount to withdraw: ");
        try
        {
            double amount = sc.nextDouble();
            account.withdraw(amount);
        }
        catch(InsufficientBalanceException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("ERROR: Invalid input type!");
        }
        System.out.println("--------------------------------------------");
        System.out.println("Updated Account Details:");
        account.display();
        sc.close();
    }
}