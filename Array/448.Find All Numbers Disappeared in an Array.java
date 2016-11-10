    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i] % nums.length;
            if(temp == 0){
                temp = nums.length;
            }
            nums[temp-1] += nums.length;
        }
        
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= nums.length){
                result.add(i+1);
            }
        }
        return result;
    }
