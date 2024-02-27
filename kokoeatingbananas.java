/*
 /*We are given an array of size n which contains the number of bananas in 
each pile. In one hour Koko can eat at most K bananas. 
If the pile contains less than K bananas in that case if Koko finishes 
all bananas of that pile then she cannot start eating bananas from another pile 
in the same hour.
Koko wants to eat all bananas within H hours. 
We are supposed to find the minimum value of K.

Sample Input-1:
---------------
4 8 9 13
8
Sample Output-1:
----------------
5

Sample Input-2:
---------------
15 18 12 17 22
7
Sample Output-2:
----------------
17
*/
import java.util.*;

public class kokoeatingbananas {
    public static int help(int[] a,int hr)
    {
        Arrays.sort(a);
        int l=1,h=a[a.length-1];
        while(l<=h)
        {
            int t=0;
            int m=(l+h)/2;
            for(int x:a)
            {
                t=t+(x+m-1)/m;
            }
            if(t>hr)
            {
                l=m+1;
            }
            else
            {
                h=m-1;
            }
        }
        return l;
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        int[] a=new int[str.length];
        for(int i=0;i<str.length;i++)
        {
            a[i]=Integer.parseInt(str[i]);
        }
        int h=sc.nextInt();
        System.out.println(help(a,h));
        
    }
}
