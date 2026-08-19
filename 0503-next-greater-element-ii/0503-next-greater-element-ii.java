class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ar = new int[nums.length];
        int k = nums.length-1;
        for (int i=nums.length-1; i>=0; i--){
            st.add(nums[i]);
        }
        for (int i=nums.length-1; i>=0; i--){
            if (st.isEmpty()){
                ar[k--]=(-1);
            }
            else{
                while(!st.isEmpty() && st.peek() <= nums[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ar[k--]=(-1);
                }else{
                    ar[k--]=(st.peek());
                }
            }
            st.add(nums[i]);
        }
        //Collections.reverse(ar);
        return ar;
        
    }
}