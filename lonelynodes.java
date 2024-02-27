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

class Solution {
    public ArrayList<Integer> getPersonIDs(BinaryTreeNode root) {
        ArrayList<Integer> lonelyNodes = new ArrayList<>();
        getPersonIDs(root, false, lonelyNodes);
        return lonelyNodes;
    }

    private void getPersonIDs(BinaryTreeNode root, boolean isLonely, ArrayList<Integer> nodes) {
        if (root == null) {
            return;
        }

        if (isLonely && root.left == null && root.right == null) {
            nodes.add(root.data);
        }

        // Recursively check the left and right subtrees
        getPersonIDs(root.left, root.right == null, nodes);
        getPersonIDs(root.right, root.left == null, nodes);
    }
}

public class lonelynodes {
    static BinaryTreeNode root;

    void insert(BinaryTreeNode temp, int key) {
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);

        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

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
        lonelynodes ln = new lonelynodes();
        Solution sol = new Solution();

        String str[] = sc.nextLine().split(" ");
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++)
            ln.insert(root, Integer.parseInt(str[i]));

        ArrayList<Integer> result = sol.getPersonIDs(root);
        Collections.sort(result);
        System.out.println(result);
    }
}
