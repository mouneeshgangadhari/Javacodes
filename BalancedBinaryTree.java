/*
Mr Rishil is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Anil to check whether BT is a balanced BT or not.
A balanced BT is defined as follows:
- the binary tree in which the left and right subtrees of every node 
differ in height by no more than 1.

Can you help Anil to find and return "true" if the given BT is a balanced tree,
otherwise return "false".

Implement the class Solution:
   1. public boolean isBalanced(BinaryTreeNode root): returns a boolean value.

NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
1 2 3 4 5 -1 -1 6 7

Sample Output-2:
----------------
false
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

public class BalancedBinaryTree
{
	static BinaryTreeNode root;
    public boolean isBalanced(BinaryTreeNode root) 
	{
        if(root==null)
        {
            return true;
        }
        int l=helper(root.left);
        int h=helper(root.right);
        if(Math.abs(l-h)>1)
        {
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    private int helper(BinaryTreeNode root)
	{
       if(root==null || root.data==-1)
       {
           return 0;
       }
       int l=helper(root.left);
       int h=helper(root.right);
       return Math.max(l,h)+1;
    }
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) {
            temp = new BinaryTreeNode(key);
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
		BalancedBinaryTree ln=new BalancedBinaryTree();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(ln.isBalanced(root));
	}
}