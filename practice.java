/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
	
	public TreeNode reconstruct(int[] pre) {
    	// Write your solution here
		if (pre == null || pre.length < 1) {
			return null;
		}
		return reconstruct(pre, 0, pre.length - 1);
	}

	public TreeNode reconstruct(int[] pre, int start, int end) {
		if (start > end) {
  		//here is the leaf node
			return null;
		}
  		//new a root node
		TreeNode newRoot = new TreeNode(pre[start]);
  		//find x
		int x = start + 1;
		while (x <= end && pre[x] < pre[start]){
			x++;
		}
  		//recursion
		newRoot.left = reconstruct(pre, start + 1, x - 1);
		newRoot.right = reconstruct(pre, x, end);
		return newRoot;
	}
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		if (n == 0 || k == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		int[] nums = new int[n];
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
		}
		List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();
		List<Integer> cur = new ArrayList<>();
		addCombine(result, cur, 0, nums, k);
		return result;
	}

	public void addCombine(List<List<Integer>> result, List<Integer> cur, int index, int[] nums, int k) {
		if (cur.size() == k) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			addCombine(result, cur, i + 1, nums, k);
			cur.remove(cur.size() - 1);
		}
	}
}



