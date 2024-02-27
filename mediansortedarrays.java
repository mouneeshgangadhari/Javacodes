import java.util.*;

public class mediansortedarrays {
     public static double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        if (n > m) {
            return findMedianSortedArrays(B, A);
        }

        int i = 0;
        int j = n;
        int finalLen = (n + m + 1) / 2;

        while (i <= j) {
            int mid = (i + j) / 2;
            int leftASize = mid;
            int leftBSize = finalLen - mid;
            int leftA = (leftASize > 0) ? A[leftASize - 1] : Integer.MIN_VALUE;
            int leftB = (leftBSize > 0) ? B[leftBSize - 1] : Integer.MIN_VALUE;
            int rightA = (leftASize < n) ? A[leftASize] : Integer.MAX_VALUE;
            int rightB = (leftBSize < m) ? B[leftBSize] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] A=new int[n];
        int[] B=new int[m];
        for(int i=0;i<n;i++)
        {
            A[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++)
        {
            B[i]=sc.nextInt();
        }
        double median = findMedianSortedArrays(A, B);
        System.out.println(median);
    }
}
