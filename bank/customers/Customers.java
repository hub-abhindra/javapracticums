package customers;
public class Customers
{
    String cusid;
    String cusname;
    int cusno;
    public Customers(String cusid, String cusname, int cusno)
    {
        this.cusid=cusid;
        this.cusname=cusname;
        this.cusno=cusno;
    }

    public void display()
    {
        System.out.println("Customer ID= " + cusid);
        System.out.println("Customer Name: " + cusname);
        System.out.println("Customer Phone Number: "+cusno);
    }
}