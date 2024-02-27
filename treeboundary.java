/*
Indian Army setup some military-camps, sitauted at random places at LAC in Galwan.
There exist a main base camp connected with other base camps as follows:
Each military-camp is connected with atmost two other military-camps.
Each military-camp will be identified with an unique ID,(an integer).

To safeguard all the military-camps, Govt of India planned to setup protective 
S.H.I.E.L.D. Govt of India ask your help to build the S.H.I.E.L.D that should 
enclose all the militar-camps.

You are given the IDs of the military-camps as binary tree. 
Your task is to find and return the military camp IDs, those are on the edge of 
the S.H.I.E.L.D in anti-clockwise order.

Implement the class Solution:
   1. public List<Integer> compoundWall(BondaryOfBTNode root): returns a boolean value.
  

NOTE:
'-1' in the IDs indicates no military-camp (NULL).


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]

*/
import java.util.*;

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class treeboundary {
    static BinaryTreeNode root;
    List<Integer> nodes = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return nodes;
        }
        if (root.left == null && root.right == null) {
            nodes.add(root.data);
            return nodes;
        }
        nodes.add(root.data);
        leftBoundary(root.left);
        leaves(root);
        rightBoundary(root.right);
        return nodes;
    }

    public void leftBoundary(BinaryTreeNode root) {
        if(root==null ||root.data==-1)
        {
            return ;
        }
        if((root.left==null || root.left.data==-1)&&(root.right==null|| root.right.data==-1))
        {
            return ;
        }
        if(root.data!=-1)
        {
            nodes.add(root.data);
        }
        if(root.left!=null && root.left.data==-1)
        {
            leftBoundary(root.right);
        }
        else
            leftBoundary(root.left);
    }

    public void rightBoundary(BinaryTreeNode root) {
        if(root==null || root.data==-1)return;
        if((root.left ==null || root.left.data==-1) && (root.right==null || root.right.data==-1))return;
        if(root.right!=null && root.right.data!=-1)rightBoundary(root.right);
        else rightBoundary(root.left);
        nodes.add(root.data);

    }

    public void leaves(BinaryTreeNode root) {
        if(root==null || root.data==-1)return;
        if((root.left ==null || root.left.data==-1) && (root.right==null || root.right.data==-1))nodes.add(root.data);
        if(root.left!=null && root.left.data!=-1)
        leaves(root.left);
        if(root.right!=null && root.right.data!=-1)
        leaves(root.right);

    }
    void insert(BinaryTreeNode temp, int key) {
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.remove();

            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        treeboundary bbt = new treeboundary();

        String str[] = sc.nextLine().split(" ");

        root = new BinaryTreeNode(Integer.parseInt(str[0]));

        for (int i = 1; i < str.length; i++)
            bbt.insert(root, Integer.parseInt(str[i]));

        List<Integer> l1=bbt.boundaryOfBinaryTree(root);
        System.out.println(l1);
    }
}

