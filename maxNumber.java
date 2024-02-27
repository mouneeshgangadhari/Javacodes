/*You are solving a puzzle,you are given an integer num. You can swap two digits at most once to get the maximum valued number.By using your porgramming skills solve this.

Return the maximum valued number you can get.

Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.
 

Constraints:

0 <= num <= 10^8

*/
import java.util.*;
public class maxNumber {
    public static int help(int num)
    {
        if(num < 10) return num;
        char[] arr = String.valueOf(num).toCharArray();
        int[] rightIndex = new int[10];  
        for(int i=0; i<arr.length; i++){
            rightIndex[arr[i] - '0'] = i;
        }
        for(int i=0; i<arr.length; i++){
            for(int j=9; j>arr[i] - '0'; j--)
            {
                if(rightIndex[j] > i){ 
                    char temp = arr[i];
                    arr[i] = arr[rightIndex[j]];
                    arr[rightIndex[j]] = temp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(help(n));
        
    }
}
