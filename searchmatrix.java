import java.util.*;
public class searchmatrix {
  public static int help(int[][] a,int m,int n,int k)
    {
        int l=0,r=n,x=0;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(k>=a[mid][0]&&k<=a[mid][m-1])
            {
                x=mid;
                break;
            }
            else if(k<a[mid][0])
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return x;
    }
    public static int helper(int[][] a,int x,int m,int k)
    {
        int l=0,r=m,y=0;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(a[x][mid]==k)
            {
                y=mid;
                break;
            }
            else if(k<a[x][mid])
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return y;
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        int k=sc.nextInt();
        int x=help(a,m,n,k);
        int y=helper(a,x,m,k);
        System.out.print(x+" "+y);
    }
}
