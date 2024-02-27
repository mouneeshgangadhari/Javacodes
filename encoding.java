import java.util.*;
public class encoding {
    public static int decimal(int n,int x)
    {
        int m=0,y=0,j=0;
        if(n>0)
        {
            m=n%2;
            j=x;
            y=decimal(n/2,x+1);
        }
        if(n==0)
        {
            return 0;
        }
        if(m==1)
        {
            return y;
        }
        return y+(int)Math.pow(2,x);
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0,x=0;
        System.out.println(decimal(n,x));
    }
}
