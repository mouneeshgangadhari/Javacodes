/*There is a survey taking place in a city with the aim of identifying 
special houses known as 'peaks,' where a house stands higher than its 
neighboring ones. Can you assist the surveyor by writing a program that takes 
the heights of houses as an array and prints the heights of the peak houses 
in a sorted list?

input : an integer n 
        n number of distinct integers
output : list of integers in sorted order

Example 1:
input = 8
9 4 5 3 8 7 10 11
output =[5, 8, 9, 11]
Example 2:
input = 10
1 2 3 4 5 6 7 8 9 10
output=[10]
Example 3:
input =10
10 9 8 7 6 5 4 3 2 1
output=[10]
Example 4:
input = 10
1 2 3 4 5 10 6 7 8 9
output = [9, 10]
*/
import java.util.*;
public class peakElement {
    public static List<Integer> findPeakHouses(int[] heights) {
        List<Integer> peaks = new ArrayList<>();
        findPeakHouses(heights, 0, heights.length - 1, peaks);
        return peaks;
    }

    private static void findPeakHouses(int[] heights, int left, int right, List<Integer> peaks) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || heights[mid] >= heights[mid - 1]) && (mid == heights.length - 1 || heights[mid] >= heights[mid + 1])) {
                peaks.add(heights[mid]);
            }
            findPeakHouses(heights, left, mid - 1, peaks);
            findPeakHouses(heights, mid + 1, right, peaks);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        List<Integer> al=findPeakHouses(a);
        Collections.sort(al);

        System.out.print(al);
    }
}
