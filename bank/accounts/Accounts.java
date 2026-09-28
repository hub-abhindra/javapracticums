package accounts;
import java.util.Scanner;
public class Accounts
{
    String accno;
    String acctype;
    double balance;
    public Accounts(String accno, String acctype, double balance)
    {
        this.accno=accno;
        this.acctype=acctype;
        this.balance=balance;
    }
    public void display()
    {
        System.out.println("Account Number= " + accno);
        System.out.println("Account Type: " + acctype);
        System.out.println("Account Balance: "+balance);
    }
    public void withdraw()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount to withdraw: ");
        int withdraw=sc.nextInt();
        if(withdraw<balance)
        {
            balance=balance-withdraw;
            System.out.println("Withdrawal successful!");
        }
        else if (withdraw<0)
        {
            System.out.println("Enter a valid amount!");
        }
        else
        {
            System.out.println("Insufficient Balance");

        }
    }
    public void deposit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount you wish to deposit");
        double deposit=sc.nextDouble();
        if(deposit>0)
        {
            balance=balance+deposit;
            System.out.println("Deposit successful");
        }
        else
        {
            System.out.println("Enter a valid amount");
        }
    }
}