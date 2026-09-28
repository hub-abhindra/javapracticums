import java.util.*;
class Bank
{
    String name; long accno;  double balance; String type;
    Bank (String name,long accno,double balance,String type)
    {
        this.accno=accno;
        this.name=name;
        this.balance=balance;
        this.type=type;
    }
    void display(Scanner sc)
    {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accno);
        System.out.println("Account Type: " + type);
        System.out.println("Account Balance: " + balance);
    }
    void create(Scanner sc)
    {
        System.out.println("Enter the Account holder name: ");
        name=sc.next();
        System.out.println("Enter the Account number: ");
        accno=sc.nextLong();
        System.out.println("Enter the Account type: ");
        type=sc.next();
        System.out.println("Enter the intial amount you wish to deposit: ");
        balance=sc.nextDouble();
        
    }
    void deposit(Scanner sc)
    {
        System.out.println("Enter the amount you wish to deposit");
        double depo=sc.nextDouble();
        if (depo>=0)
        {
            balance=balance+depo;
            System.out.println("Amount deposited successfully.");

        }
        else
        {
            System.out.println("Deposit a valid amount.");
        }
    
    }
    void withdraw(Scanner sc)
    {
        System.out.println("Enter the amount you wish to withdraw: ");
        double wd=sc.nextDouble();
        if (wd<=balance && wd>=0)
        {
            balance=balance-wd;
            System.out.println("Withdrawal successful!");
        }
        else if (wd>balance)
        {
            System.out.println("Insufficient balance.");
        }
        else
        {
            System.out.println("Please enter a valid amount.");
        }
       
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Bank b=new Bank(" ",0,0.0," ");
        int choice=0;
        do 
        {
            System.out.println("BANKING OPTIONS:");
            System.out.println("1. CREATE ACCOUNT");
            System.out.println("2. DEPOSIT MONEY");
            System.out.println("3. WITHDRAW MONEY");
            System.out.println("4. DISPLAY DETAILS");
            System.out.println("0  to exit");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1: b.create(sc); break;
                case 2: b.deposit(sc); break;
                case 3: b.withdraw(sc); break;
                case 4: b.display(sc); break;
                case 0: return;
                default: System.out.println("Enter a valid option:"); break;
            }
        }while (choice!=0);

    }
}
    