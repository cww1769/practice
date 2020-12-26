package algorithm;

public class MinTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) 
            return null;
        int len = nums.length;
        return createMinTree(nums, 0 , len-1);
    }

    TreeNode createMinTree(int[] nums, int start, int end){
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        /*if (start - 1 = end) {
            TreeNode root = new TreeNode(nums[end]);
            root.left = new TreeNode(nums[start]);
            return root;
        }*/
        int mid = start + (end-start)/2;
        System.out.println("mid = " + mid);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createMinTree(nums, start, mid - 1);
        root.right = createMinTree(nums, mid + 1, end);
        return root;
    }

	public static void main(String[] args) {
		int[] nums = {-10,-3,0,5,9};
		MinTree min = new MinTree();
		TreeNode root = min.sortedArrayToBST(nums);
		BFS.printTree(root);

	}

}
