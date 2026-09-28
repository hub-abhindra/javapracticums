import java.util.*;
class studentuni
{
    int studentID;
    String studentName;
    String department;

    studentuni(int studentID, String studentName, String department)
    {
        this.studentID = studentID;
        this.studentName = studentName;
        this.department = department;
    }

    void displayStudentDetails()
    {
        if (studentID<0)
        {
            System.out.println("Invalid student Id:");
        }
        else
        {
            System.out.println("Student ID: " + studentID);
        }
        if (studentName=="")
        {
            System.out.println("Name field is empty");
        }
        else
        {
            System.out.println("Student Name: " + studentName);
        }
        System.out.println("Department: " + department);
    }
}

class UndergraduateStudent extends studentuni
{
    int semester;
    double cgpa;
    UndergraduateStudent(int studentID, String studentName, String department,int semester, double cgpa)
    {
        super(studentID, studentName, department);
        this.semester = semester;
        this.cgpa = cgpa;
    }

    void displayUGDetails()
    {
        displayStudentDetails();
        if (semester>0 && semester<9)
        {
            System.out.println("Semester: " + semester);
        }
        else
        {
            System.out.println("Invalid Semester!");
        }
        if (cgpa>0 && cgpa<=10)
        {
            System.out.println("CGPA: " + cgpa);
        }
        else
        {
            System.out.println("Invalid CGPA");
        }
    }
}

class PostgraduateStudent extends studentuni
{
    String specialization;
    String researchTopic;
    PostgraduateStudent(int studentID, String studentName, String department, String specialization, String researchTopic)
    {
        super(studentID, studentName, department);
        this.specialization = specialization;
        this.researchTopic = researchTopic;
    }

    void displayPGDetails()
    {
        displayStudentDetails();
        System.out.println("Specialization: " + specialization);
        if (researchTopic=="")
        {
            System.out.println("Research topic field is empty");
        }
        else
        {
            System.out.println("Research Topic: " + researchTopic);
        }
    }
}

public class ugpg
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        UndergraduateStudent ug = new UndergraduateStudent(101, "", "Cse", 10, -1);
        PostgraduateStudent pg = new PostgraduateStudent(201, "Anita", "Ece", "AI","");
        int choice=-1;
        while(choice!=0)
        {
            System.out.println("*********************************");
            System.out.println("STUDENT DETAILS:");
            System.out.println("1. UNDERGRADUATE DETAILS");
            System.out.println("2. POSTGRADUATE DETAILS");
            System.out.println("0 TO EXIT");
            System.out.println("*********************************");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1: System.out.println("UNDERGRADUATE STUDENT");
                        ug.displayUGDetails(); break;
                case 2: System.out.println("POSTGRADUATE STUDENT");
                        pg.displayPGDetails();break;
                case 0: return;
                default: System.out.println("Invalid input!"); break;
            }

        }
       
    }
}