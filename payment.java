import java.util.*;
class Payment
{
    void makePayment(double amount)
    {
        System.out.println("Payment of Rs." + amount);
    }

    void makePayment(double amount,double paymentamount, String transactionId)
    {
        System.out.println("Amount= "+amount);
        System.out.println("Payment of Rs." + paymentamount);
        System.out.println("Transaction ID: " + transactionId);
    }
}

class CreditCardPayment extends Payment
{
    void makePayment(double amount,double paymentamount,String transactionid)
    {
        System.out.println("Credit Card Payment: Rs." + amount);
        System.out.println("Payment amount: Rs."+paymentamount);
        System.out.println("Transaction id: "+ transactionid);
    }
}

class UPIPayment extends Payment
{

    void makePayment(double amount)
    {
        System.out.println("UPI Payment: Rs." + amount);
    }
}

class NetBankingPayment extends Payment
{
    void makePayment(double amount)
    {
        System.out.println("Net Banking Payment: Rs." + amount);
    }
}

public class payment
{
    public static void main(String[] args)
    {
        Payment p;
        Scanner sc=new Scanner(System.in);
        int choice=-1;
        while (choice!=0)
        {
        System.out.println("-----------PAYMENT PORTAL------------");
        System.out.println("1. CREDIT CARD ");
        System.out.println("2. UPI ");
        System.out.println("3.NETBANKING");
        System.out.println("0 TO EXIT");
        System.out.println("-------------------------------------");
        choice=sc.nextInt();
        double amount=0;
        switch (choice)
        {
            case 1: 
                    System.out.println("Enter the amount: ");
                    amount=sc.nextDouble();
                    System.out.println("Enter the payment amount: ");
                    double paymentamount=sc.nextDouble();
                    if (amount<0 || paymentamount<0)
                    {
                        System.out.println("Invalid amount!");
                        return;
                    }
                    System.out.println("Enter the transaction id: ");
                    String transactionid=sc.next();
                    if (transactionid==" ")
                    {
                        System.out.println("Empty transaction id!");
                        return;
                    }
                    p = new CreditCardPayment();
                    p.makePayment(amount,paymentamount,transactionid);
                    System.out.println();break;
            case 2: System.out.println("Enter the amount:");
                    amount=sc.nextDouble();
                    if (amount<0)
                    {
                        System.out.println("Invalid amount!");
                        return;
                    }
                    p = new UPIPayment();
                    p.makePayment(amount); 
                    System.out.println();break;
            case 3: System.out.println("Enter the amount:");
                    amount=sc.nextDouble();
                    if (amount<0)
                    {
                        System.out.println("Invalid amount!");
                        return;
                    }
                    p = new NetBankingPayment();
                    p.makePayment(amount);
                    System.out.println(); break;
            case 0: break;
            default: System.out.println("Invalid input");
                    System.out.println();break;
        }
    }
}
}