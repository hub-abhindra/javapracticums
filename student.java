import java.util.*;
class Student{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name:");
        String name=sc.nextLine();
        System.out.println("Enter the Register Number:");
        double regno=sc.nextDouble();
        System.out.println("Enter the Subject1 marks:");
        int m1=sc.nextInt();
        System.out.println("Enter the Subject2 marks:");
        int m2=sc.nextInt();
        System.out.println("Enter the Subject3 marks:");
        int m3=sc.nextInt();
        System.out.println("Enter the CGPA:");
        float cgpa=sc.nextFloat();
        System.out.println("Name: "+ name);
        System.out.println("Reg no.: "+ regno);
        System.out.println("Subject 1 marks : "+ m1);
        System.out.println("Subject 2 marks : "+ m2);
        System.out.println("Subject 3 marks : "+ m3);
        System.out.println("CGPA : "+ cgpa);

    }
}