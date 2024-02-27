/*
you are working in a chain marketing system. In this chain one person can mentor maximum two persons only.
Your manager asked you to find the number of persons connected in the longest path starting from root to 
the farthest leaf node.Return that number. 

Here we give some id numbers to persons which are greater than 0. and may be repeated.
  
Input Format:
-------------
A single line of space separated integers

Output Format:
--------------
An integer

Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
3

Sample Input-2:
---------------
2 1 6 5 3 4 3 8 9 2 3 4 5 

Sample Output-2:
----------------
4
*/
import java.util.*;
class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data){
		this.data = data; 
		left = null; 
		right = null; 
	}
}
class Solution 
{
    public int maxChainLength(BinaryTreeNode root) 
    {
        return root==null ? 0 : 1 + Math.max(maxChainLength(root.left) , maxChainLength(root.right));
    }
}

class MaxChainLength
{
	static BinaryTreeNode root;
	static BinaryTreeNode temp = root;
	static void insert(BinaryTreeNode temp, int key)
    {
         if (temp == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
         // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.remove();
             if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			insert(root,Integer.parseInt(str[i]));
		Solution sol= new Solution();
		System.out.println(sol.maxChainLength(root));
	}
}
