/* use the for method*/
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        k = k % nums.length;
        if(k == 0){
            return;
        }
        int mid = nums.length - k - 1; 
        int[] array1 = new int[nums.length - k];
        for (int i = 0; i < nums.length - k; i++){
            array1[i] = nums[i];
        }
        int j = 0;
        for(int i = mid + 1; i< nums.length; i++){
            nums[j] = nums[i];
            j++;
        }
        for(int i = 0;j< nums.length;j++){
            nums[j] = array1[i];
            i++;
        }
        return;
        
    }
}
