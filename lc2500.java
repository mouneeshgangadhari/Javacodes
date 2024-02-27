import java.util.*;

public class lc2500 {
    public static int help(List<PriorityQueue<Integer>> al,int m,int n)
    {
        int c=0;
        for(int i=0;i<n;i++)
        {
            int temp=-1;
            for(PriorityQueue<Integer> x:al)
            {
                int t=x.poll();
                temp=Math.max(temp,t);
            }
            c=c+temp;
        }
        return c;
    }
    public static  void helper(int[] a,List<PriorityQueue<Integer>> al)
    {
        PriorityQueue<Integer> q1=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<a.length;i++)
        {
            q1.add(a[i]);
        }
        al.add(q1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] num=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                num[i][j]=sc.nextInt();
            }
        }
        List<PriorityQueue<Integer>>al=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            helper(num[i],al);
        }
        System.out.println(help(al,m,n));

        
    }
}
