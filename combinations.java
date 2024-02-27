/*You are attending an interview, interviewer given a positive integer n,asked you to print all combinations of numbers between 1 and n having sum 'm'.Write a program to do this task.
Note : 1. To avoid ambiguity, combination will be constructed in  
          non-decreasing order.
	   2. Distinct combinations are to be printed, i.e [1,2] and [2,1]   
	      are same, if [1,2] is printed then avoid [2,1].
	   2. m <= n.

input format: two integer numbers n and m
output format : lists
Example :
For n = 5,m=5 the following combinations are possible:
1 1 1 1 1
1 1 1 2
1 1 3
1 2 2
1 4
2 3
5
Example 2:
input = 4 3
output =
1 1 1
1 2
3
*/

import java.util.*;

public class combinations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> al = findCombinations(n, m);
        for (List<Integer> x : al) {
            System.out.println(x);
        }
    }
    public static List<List<Integer>> findCombinations(int n, int m) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curComb = new ArrayList<>();
        generateCombinations(1, n, m, curComb, result);
        return result;
    }
    private static void generateCombinations(int start, int n, int m, List<Integer> curComb, List<List<Integer>> result) {
        if (m == 0) {
            result.add(new ArrayList<>(curComb));
            return;
        }
        for (int i = start; i <= n && i <= m; i++) {
            curComb.add(i);
            generateCombinations(i, n, m - i, curComb, result);
            cur Comb.remove(curComb.size() - 1);
        }
    }
}
