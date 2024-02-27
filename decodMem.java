/*
Given a positive number, map its digits to the corresponding alphabet in the mapping table [(1, 'A'), (2, 'B'),(26, 'Z')], and return the count of the total number of decodings possible. Assume that the input number can be split into valid single-digit or two-digit numbers that are present in the mapping table.
A single-digit between 1 to 9 can be mapped to a corresponding alphabet between A to I.
Two digits between 10 to 26 can be mapped to a corresponding alphabet between J to Z.
input format: an intger number 
output format : an integer number
Example
Input:  123
Output: 3
Explanation : with 123 combination we can form [ABC(123), AW(A=1,W=23), LC(L=12 and C=3)]
Input:  1221
Output: 5
Explanation :with 1221 combination we can form [ABBA, ABU, AVA, LBA, LU]
*/
import java.util.*;
class Test {
    // Function to count the total decodings of a given sequence of digits
    public static int countDecodings(char[] chars, int n, int[] memo) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Check if the result for this subproblem is already computed
        if (memo[n] != -1) {
            return memo[n];
        }
        int totalDecodings = 0;
        // consider single digit numbers (1, 2, upto 9)
        if (chars[n - 1] > '0') 
		{
            totalDecodings = countDecodings(chars, n - 1, memo);
        }
        // consider 2 digit numbers (10, 11, upto 26)
        if (chars[n - 2] == '1' || (chars[n - 2] == '2' && chars[n - 1] <= '6')) 
		{
            totalDecodings += countDecodings(chars, n - 2, memo);
        }
        // Store the result in the memoization table
        memo[n] = totalDecodings;
        return totalDecodings;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        char[] chars = String.valueOf(x).toCharArray();
        int[] memo = new int[chars.length + 1];
        Arrays.fill(memo, -1);
        System.out.println(countDecodings(chars, chars.length, memo));
    }
}

/*
Test cases 
case =1
input =1234
output =3
case =2
input=123321
output=6
case =3
input =222120
output=5
case =4
input=112233
output=8
case =5
input=88888
outpu=1
case =6
input=898989
output=1

*/