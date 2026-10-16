class BankAccount
{
    int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accountNumber, String accountHolderName, double balance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    synchronized void deposit(String name, double amount)
    {
        if(amount <= 0)
        {
            System.out.println(name + ": Invalid deposit amount");
            return;
        }

        balance = balance + amount;

        System.out.println(name + " deposited Rs." + amount);
        System.out.println("Updated Balance: Rs." + balance);
    }
    synchronized void withdraw(String name, double amount)
    {
        if(amount <= 0)
        {
            System.out.println(name + ": Invalid withdrawal amount");
            return;
        }

        if(amount > balance)
        {
            System.out.println(name + ": Insufficient Balance");
            return;
        }

        balance = balance - amount;

        System.out.println(name + " withdrew Rs." + amount);
        System.out.println("Updated Balance: Rs." + balance);
    }

    void displayBalance()
    {
        synchronized(this)
        {
            System.out.println("Final Account Balance: Rs." + balance);
        }
    }
}
class UserTransaction extends Thread
{
    BankAccount account;
    String username;
    String type;
    double amount;
    UserTransaction(BankAccount account, String username, String type, double amount)
    {
        this.account = account;
        this.username = username;
        this.type = type;
        this.amount = amount;
    }
    public void run()
    {
        if(type.equals("deposit"))
        {
            account.deposit(username, amount);
        }
        else if(type.equals("withdraw"))
        {
            account.withdraw(username, amount);
        }
    }
}
public class BankDemo
{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(101, "Abhindra", 5000);
        UserTransaction t1 = new UserTransaction(account, "User1", "deposit", -8000);
        UserTransaction t2 = new UserTransaction(account, "User2", "withdraw", 0000);
        UserTransaction t3 = new UserTransaction(account, "User3", "withdraw", 0000);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("\nAll transactions completed.");
        account.displayBalance();
    }
}