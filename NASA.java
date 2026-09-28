import java.util.*;
class NASAMission
{
    String missionType;
    String missionName;
    int launchYear;
    String destination;
    
    

    NASAMission(String missionType, String missionName,int launchYear,String destination)
    {
        this.missionType=missionType;
        this.missionName=missionName;
        this.launchYear=launchYear;
        this.destination=destination;
    }
}
class Marsmission extends NASAMission{
    int numberOfRover;
    Marsmission(String missionType, String missionName,int launchYear,String destination, int numberOfRover)
    {
        super(missionType, missionName, launchYear, destination);
        this.numberOfRover=numberOfRover;
    }
    void displaymars()
        {
            System.out.println("Mission Name: "+missionName);
            if (launchYear>=2000 && launchYear<=2100)
            {
                System.out.println("Launch Year: "+ launchYear);    
            }
            else
            {
                System.out.println("Invalid Launch Year");
            }
            System.out.println("Destination: "+destination);
            System.out.println("Mission Type: Mars Exploration");
            if(numberOfRover>=1 && numberOfRover<=10){
                System.out.println("Number of Rovers: "+numberOfRover);
            }
            else{
                System.out.println("Invalid Number of rovers");
            }
        }
}
class Moonmission extends NASAMission{
    int numberOfAstronaut;
    Moonmission(String missionType, String missionName,int launchYear,String destination,int numberOfAstronaut)
    {
        super(missionType, missionName, launchYear, destination);
        this.numberOfAstronaut=numberOfAstronaut;
    }
    void displaymoon()
        {
            System.out.println("Mission Name: "+missionName);
            if (launchYear>=2000 && launchYear<=2100)
            {
                System.out.println("Launch Year: "+ launchYear);    
            }
            else
            {
                System.out.println("Invalid Launch Year");
            }
            System.out.println("Destination: "+destination);
            System.out.println("Mission Type: Lunar Exploration");
            if(numberOfAstronaut>=1 && numberOfAstronaut<=20){
                System.out.println("Number of Astronauts: "+numberOfAstronaut);
            }
            else{
                System.out.println("Invalid Number of Astronauts");
            }
        }
}
public class NASA{
    public static void main(String[] args)
    {
         Scanner sc=new Scanner(System.in);
        String missionType=sc.next();
        sc.nextLine();
        String missionName=sc.nextLine();
        int launchYear=sc.nextInt();
        String destination=sc.next();
        NASAMission na=new NASAMission(missionType,missionName,launchYear,destination);
        if (missionType.equals("Mars"))
        {
            int numberOfRover=sc.nextInt();
            Marsmission ma=new Marsmission(missionType,missionName,launchYear,destination,numberOfRover);
            ma.displaymars();
        }
        else if (missionType.equals("Moon"))
        {
            int numberOfAstronaut=sc.nextInt();
            Moonmission mo=new Moonmission(missionType,missionName,launchYear,destination,numberOfAstronaut);
            mo.displaymoon(); 
        }
        else
        {
            System.out.println("Invalid type");
        }
        }
   
}