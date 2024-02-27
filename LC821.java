import java.util.*;
public class LC821 {
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char ch=sc.next().charAt(0);
        int n=str.length();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            int c1=Integer.MAX_VALUE,c2=Integer.MAX_VALUE;
            int j=i,k=i;
            while(j>0||k<n)
            {
                if(j>0&&str.charAt(j)==ch)
                {
                    c1=j;
                    break;
                }
                if(k<n&&str.charAt(k)==ch)
                {
                    c2=k;
                    break;
                }
                if(j>0)
                {
                    j--;
                }
                if(k<n)
                {
                    k++;
                }
            }
            a[i]=Math.min(c1,c2);
        }
        for(int x:a)
        {
            System.out.println(x);
        }
    }
}
