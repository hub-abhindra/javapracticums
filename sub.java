import java.util.*;
class Sub{
    static int a ; static int b; static int result;
    Sub(int a,int b){
        this.a=a;
        this.b=b;
        this.result=a-b;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        Sub d= new Sub(a,b);
        System.out.println(d.result);

    }
}