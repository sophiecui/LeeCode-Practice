public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(a < b){
                    return 1;
                }
                return -1;
            }
        });

        for(int i = 0; i < nums.length; i++ ){
            q.add(nums[i]);
        }
        
        int i = 1;
        while(!q.isEmpty() && i < k){
            q.poll();
            i++;
        }
        return q.peek();  
    }
}
