/*
You have a keypad with 9 buttons, numbered from 1 to 9, each mapped to lowercase English letters. You can choose which characters each button is matched to as long as:

All 26 lowercase English letters are mapped to.
Each character is mapped to by exactly 1 button.
Each button maps to at most 3 characters.
To type the first character matched to a button, you press the button once. To type the second character, you press the button twice, and so on.

Given a string s, return the minimum number of keypresses needed to type s using your keypad.

Note that the characters mapped to by each button, and the order they are mapped in cannot be changed.

example 1=
input = apple













Output: 5
Explanation: One optimal way to setup your keypad is shown above.
Type 'a' by pressing button 1 once.
Type 'p' by pressing button 6 once.
Type 'p' by pressing button 6 once.
Type 'l' by pressing button 5 once.
Type 'e' by pressing button 3 once.
A total of 5 button presses are needed, so return 5.

example 2
input = abcdefghijkl















Output: 15
Explanation: One optimal way to setup your keypad is shown above.
The letters 'a' to 'i' can each be typed by pressing a button once.
Type 'j' by pressing button 1 twice.
Type 'k' by pressing button 2 twice.
Type 'l' by pressing button 3 twice.
A total of 15 button presses are needed, so return 15.












*/


import java.util.*;

class Solution 
{
    public int minimumKeypresses(String s) 
	{
        int result = 0;
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        for(int i=0; i<s.length(); i++) 
		{
            freq[s.charAt(i)-'a']++;
        }
		System.out.println(Arrays.toString(freq));
        Arrays.sort(freq, (a,b)->b-a);
		System.out.println(Arrays.toString(freq));

        for(int i=0; i<26; i++) 
		{
            if(i<9) {
                result += freq[i];
            } else if(i<18) {
                result += 2*freq[i];
            } else {
                result += 3*freq[i];
            }
        }
        return result;
    }
	
	public static void main(String[] args)
    {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();     
		System.out.println(new Solution().minimumKeypresses(s));
	}
}
/*
case =1
input =helloworld
output=10
case =2
input =javaprogram
output=11
case=3
input=algorithmanalysis
output=20
case=4
input=babababcbcbcbcba
output=16
case =5
input=abcdefghi
output=9
*/










