package algorithm;

import java.util.concurrent.ConcurrentHashMap;

public class Diameter {
    private static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) 
            return 0;
        int depth_left = depth(node.left);
        int depth_right = depth(node.right);
        diameter = Math.max(depth_left + depth_right, diameter);
        return Math.max(depth_left, depth_right) + 1;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		Diameter d = new Diameter();
	
	}

}
