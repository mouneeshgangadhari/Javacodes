/*
 There are N lamp-posts with various heights as an array height[]. A group 
of lamp-posts is called as closed sequence when we subtract the maximum height 
and minimum height of the lamp-post among all in that group should be 1.

You can form the lamp-post group as sequence of lamp-posts. A sequence 
is formed by removing some or no lamp-posts without changing the order of them.

Your task is to find the length of its largest closed lamp-post sequence among 
all its possible sequences.

Input Format:
-------------
Line-1: An integer N, number of lamp-posts.
Line-2: N space separated integers, represent the heights[].
 
Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
6
4 3 5 2 6 3
 
Sample Output-1:
----------------
3

Explanation:
------------
lamp-post sequence is [4,3,3]


Sample Input-2:
---------------
7
20 19 19 29 37 35 19

Sample Output-2:
----------------
4

Explanation:
------------
lamp-post sequence is [20 19 19 19]


 */
import java.util.*;
public class prefstest2 {
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int c=1;
        if(n==0)
        {
            System.out.println(0);
            return;
        }
        if(n==1)
        {
            System.out.println(1);
            return ;
        }
        int max=-1;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(a[i]-a[j]==1)
                {
                    c++;
                }
            }
            max=Math.max(max,c);
            c=1;
        }
        System.out.println(max);

    }
}
