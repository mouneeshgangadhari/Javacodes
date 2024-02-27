/*Mr.Sathya is solving a puzzle, the problem is given a sorted array which 
contains only 0s and 1s. He has to find total number of 1s in the given list, 
can you write a program to do this task in an efficient way.

*****************************
input Format : integer number n
         n number of integers (contains 0s and 1s only in a sorted order)
output Format :An integer
*****************************
Samples
example 1:
input =5
0 0 1 1 1
output =3
Example 2:
input =10
1 1 1 1 1 1 1 1 1 1
output =10
*/
import java.util.*;
public class numberofones {
    public static int findLastOneIndex(int[] arr, int l, int r) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (arr[mid] == 1 && arr[mid - 1] == 0) {
            return mid;
        }
        if (arr[mid] == 1 && arr[mid - 1] == 1) {
            return findLastOneIndex(arr, l, mid - 1);
        }
        return findLastOneIndex(arr, mid + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[0] == 1) {
            System.out.println(n);
        } else if (arr[n - 1] == 0) {
            System.out.println(0);
        } else {
            int idx = findLastOneIndex(arr, 0, n - 1);
            System.out.println(n - idx);
        }
    }
}
