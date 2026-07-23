class Solution {
    public int subarraySum(int[] nums, int k) {
        int psa=0;        
        HashMap<Integer, Integer> hp = new HashMap<>();
        int count = 0;
        hp.put(0,1);
        for (int i = 0; i < nums.length; i++){
            psa+=nums[i];
            
            int a = psa;
            if(hp.containsKey(a-k)){
                count+=hp.get(a-k);
            }
            if(hp.containsKey(a)){
                hp.put(a,hp.get(a)+1);
            }else{
                hp.put(a,1);
            }
            
        }
        return count;
    }
}