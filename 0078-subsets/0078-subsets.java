class Solution { 
    public List<List<Integer>> subsets(int[] nums) { 
        List<List<Integer>> ar = new ArrayList<>(); 
        int n = nums.length; 
        
        for (int k = 0; k < (1 << n); k++) { 
            List<Integer> temp = new ArrayList<>(); 
            for (int i = 0; i < n; i++) { 
                if ((k & (1 << i)) != 0) { 
                    temp.add(nums[i]); 
                } 
            } 
            ar.add(temp); 
        } 
        return ar; 
    } 
}
