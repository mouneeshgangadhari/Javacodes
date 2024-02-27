import java.util.*;
public class groupsumdigit {
    public static int helper(int x,int c)
    {
        if(x<10)
        {
            return x;
        }
        while(x>0)
        {
            c=c+x%10;
            x=x/10;
        }
        return helper(c,0);
    }
    public static int help(int n)
    {
        Map<Integer,Integer> m1=new HashMap<>();
        for(int i=0;i<=n;i++)
        {
            int x=helper(i,0);
            
            m1.put(x,m1.getOrDefault(x,0)+1);
        }
        int max=-1;
        int maxnum=-1;
        for(int i=0;i<10;i++)
        {
            max=Math.max(max, m1.get(i));
            if(max==m1.get(i))
            {
                maxnum=i;
            }
            //System.out.println(i+"  "+m1.get(i)+" "+maxnum);
        }
        return maxnum;
    }
    public static void main(String v[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(help(n));
    }
}
