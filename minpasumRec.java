/*Find minimum path sum in a triangle shaped matrix

Given a right-angled triangle-shaped matrix, find the shortest path sum from the top
element to any element in the last row of the matrix.

We can only move down from the present cell at any given time. 
Hence, the legal movements from cell (x,y) are either (x+1,y) or (x+1,y+1). For example, 

input format: integer number m number of rows 
              integer numbers m number of rows enter one integer in first row, 
			  two integers in second row, three integers in third row and m number of integers in last row
output format : intger number

example :
case =1
input =
4
4
1 3
1 2 1
8 4 5 1
output =9


[4]                         [9, 0, 0, 0]
[1, 3]						[6, 5, 0, 0]
[1, 2, 1]                   [5, 6, 2, 0]
[8, 4, 5, 1]                [8, 4, 5, 1]

case =2
input =5
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
output =5*/
import java.util.*;
class Main {
    public static int getMinimumValue(int[][] mat) {
        return getMinimumValueHelper(mat, 0, 0);
    }
    public static int getMinimumValueHelper(int[][] mat, int row, int col) 
	{
        int N = mat.length;
		System.out.println("row " + row + " col " + col);
        // Base case: If we are at the last row, return the value in the matrix
        if (row == N - 1) {
            return mat[row][col];
        }

        // Calculate the minimum sum for the current subproblem
        int leftSum = getMinimumValueHelper(mat, row + 1, col);
        int rightSum = getMinimumValueHelper(mat, row + 1, col + 1);
		System.out.println("After row " + row + " col " + col + " leftsum " + leftSum + " rightsum " + rightSum);
        return mat[row][col] + Integer.min(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] mat = new int[m][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j <= i; j++)
                mat[i][j] = sc.nextInt();
        System.out.println(getMinimumValue(mat));
    }
}
/*
test cases
case =1
input=6
1
2 3
3 4 5
4 5 6 7
5 6 7 8 9
6 7 8 9 10 11
output=21
case =2
input=5
1
1 4
5 3 4
7 3 2 1
8 6 2 4 2
output=9
case =3
input=6
3
2 4
4 5 2
3 2 1 4
1 2 3 4 5
3 2 2 2 2 2
output=15
case =4
input=7
1
2 1
3 2 4
4 5 6 7 1
1 3 5 7 9 8
2 4 6 8 7 5 3
10 13 15 17 19 21 23
output=15
case =5
input=4
10
20 30
10 20 30
1 2 3 4
output=41
*/