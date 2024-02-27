/*Given the array of strings S[], you need to find the longest string S 
which is the prefix of ALL the strings in the array.
Longest common prefix (LCP) for a pair of strings S1 and S2 is the 
longest string S which is the prefix of both S1 and S2.
For Example: longest common prefix of “abcdefgh” and “abcefgh” is “abc”.

Time complexity: O(NM log M)
N = Number of strings
M = Length of the longest string

Space complexity:
O(M) 
M = Length of the longest string 

Test Cases:
case1:
input=flower flow flight
output=fl

case2:
input=hello hell her he
output=he

case3:
input=anty anticipate ant antacid
output=ant
*/

import java.util.*;
public class longestcommonprifix {
    public static String help(String[] str,int l,int r)
    {
        if(l>r)
        {
            return str[l];
        }
        int m=(l+r)/2;
        String left=help(str,l,m);
        String right=help(str,m+1,r);
        return helper(left,right);
        
    }
    public static String helper(String a,String b)
    {
        int min=Math.min(a.length(),b.length());
        int l=0;
        int h=min-1;
        while(l<=h)
        {
            int m=(l+h)/2;
            if(a.substring(0,m+1).equals(b.substring(0,m+1)))
            {
                l=m+1;
            }
            else
            {
                h=m-1;
            }
        }
        return a.substring(0,h+1);
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        System.out.println(help(str,0,str.length));
    }
}
/*
 import java.util.*;
class Test
{
    public static String check(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j))
                break;
            res.append(s1.charAt(i));
            i++;
            j++;
        }
        return res.toString();
    }

    public static String solve(ArrayList<String> v, int i, int j) {
        if (i == j)
            return v.get(i);

        if (i < j) {
            int mid = i + (j - i) / 2;

            String s1 = solve(v, i, mid);
            String s2 = solve(v, mid + 1, j);

            return check(s1, s2);
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringTokenizer st = new StringTokenizer(input);
        ArrayList<String> v = new ArrayList<>();
        while (st.hasMoreTokens()) {
            v.add(st.nextToken());
        }

        String result = solve(v, 0, v.size() - 1);
        System.out.println(result);
    }
}

 */
