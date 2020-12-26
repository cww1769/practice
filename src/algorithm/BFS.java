package algorithm;

import java.util.HashMap;
import java.util.LinkedList;

public class BFS {
	
	public static void printTree(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.pop();
			System.out.println(curr.val);
			if (curr.left != null) {
				queue.push(curr.left);
			}
			if (curr.right != null) {
				queue.push(curr.right);
			}
		}
	} 
	public static void main(String[] args) {
		
	}

}
