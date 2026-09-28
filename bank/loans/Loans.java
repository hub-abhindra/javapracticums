package loans;
public class Loans
{
    String loanno;
    String loantype;
    double loanamt;
    public Loans(String lobnanno, String loantype, double loanamt)
    {
        this.loanno=loanno;
        this.loantype=loantype;
        this.loanamt=loanamt;
    }
    public void display()
    {
        System.out.println("Loan Number= " + loanno);
        System.out.println("Loan Type: " + loantype);
        System.out.println("Loan Amount: "+loanamt);
    }
}