/*
 * Mr.Arun is playing with strings, as part of this he is taking a string and writing all possible non-overlapping substrings within that string.
Can you help him with a program which takes a string as input and return a list of all possible combinations of non-overlapping parenthesized substrings.

input format : String
outputformat : parenthesized substrings

Example 1:
input=abcd
output={abcd}
{abc}{d}
{ab}{cd}
{ab}{c}{d}
{a}{bcd}
{a}{bc}{d}
{a}{b}{cd}
{a}{b}{c}{d}
Example 2 :
input=kmit
output={kmit}
{kmi}{t}
{km}{it}
{km}{i}{t}
{k}{mit}
{k}{mi}{t}
{k}{m}{it}
{k}{m}{i}{t}
*/
import java.util.*;
public class NonOverlappingSubstrings {
    public static List<String> result(String s)
    {
        List<String> res=new ArrayList<>();
        generate(s,0," ",res);
        return res;
    }
    public static void generate(String s,int l,String cur,List<String> res)
    {
        if(l==s.length())
        {
            res.add(cur);
            return;
        }
        for(int i=l+1;i<=s.length();i++)
        {
            String str=s.substring(l,i);
            generate(s,i,cur+"{"+str+"}",res);
        }
    }
    public static void main(String v[])
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        List<String> res=result(str).reversed();
        for(String x:res)
        {
            System.out.println(x);
        }
        
    }
}
