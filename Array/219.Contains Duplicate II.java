public class Solution {
    /* O(n) and HashTable */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            } else {
                if( i - map.get(nums[i]) <= k ){
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }
    /*O(n*n)*/
    /*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            int temp = Math.min(nums.length, i + k + 1);
            for(int j = i+1; j < temp; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;   
    }
    */
}
