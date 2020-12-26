package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import exam.NLoop;


public class Permutation {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	List<List<Integer>> permutation(int[] nums){
		LinkedList<Integer> res = new LinkedList<Integer>();
		dfs(nums, res);
		return ans;
	}
	
	void dfs(int[] nums, LinkedList<Integer> res) {
		if (nums.length == res.size()) {
			ans.add(new ArrayList<Integer>(res));
			return;
		}
		for (int num: nums) {
			if (res.contains(num)) {
				continue;
			}
			res.add(num);
			dfs(nums, res);
			res.removeLast();
		}
	}
	
	List<List<Integer>> Nloop(int[] nums){
		LinkedList<Integer> res = new LinkedList<Integer>();
		dfs_n(nums, res, 0);
		return ans_n;
	}
	List<List<Integer>> ans_n = new ArrayList<List<Integer>>();
	void dfs_n(int[] nums, LinkedList<Integer> res, int curr) {
		if (curr == nums.length) {
			ans_n.add(new ArrayList<Integer>(res));
			return;
		}
		for (int i = 0; i <= nums[curr]; i ++ ) {
			res.add(i);
			dfs_n(nums, res, curr+1);
			res.removeLast();
		}
	}
	
	public void printListList(List<List<Integer>> listlist) {
		Iterator<List<Integer>> it = listlist.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> e = (ArrayList<Integer>)it.next();
			printList(e);
		}

	}
	public void printList(List<Integer> list) {
		Iterator<Integer> it = list.listIterator();
		StringBuilder sb = new StringBuilder("[");
		while (it.hasNext()) {
			sb.append(it.next());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		System.out.println(sb);
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		Permutation p = new Permutation();
		List<List<Integer>> result = p.Nloop(nums);
		p.printListList(result);
	}
}
