package algorithm;

public class BuildTree {
    class Data {
        int preBegin;
        int preEnd;
        int inBegin;
        int inEnd;
        public Data(int pBegin, int pEnd, int iBegin, int iEnd){
            preBegin = pBegin;
            preEnd = pEnd;
            inBegin = iBegin;
            inEnd = iEnd;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l1 = preorder.length;
        int l2 = inorder.length;
        if (l1 != l2) return null;
        if (l1 == 0) return null;

        Data data = new Data(0, l1-1, 0, l2-1);
        return recursion(preorder, inorder, data);
    }
    
    private TreeNode recursion(int[] preorder, int[] inorder, Data data) {
        if (data.preBegin > data.preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[data.preBegin]);
        int i = data.inBegin;
        while (i <= data.inEnd) {
            if (inorder[i] == preorder[data.preBegin]) {
                break;
            }
            i ++;
        }
        int leftL = i - data.inBegin;
        Data data_left = new Data(data.preBegin+1, data.preBegin+leftL, data.inBegin, i-1);
        root.left = recursion(preorder, inorder, data_left);
        Data data_right = new Data(data.preBegin+leftL+1, data.preEnd, i+1, data.inEnd);
        root.right = recursion(preorder, inorder, data_right);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
