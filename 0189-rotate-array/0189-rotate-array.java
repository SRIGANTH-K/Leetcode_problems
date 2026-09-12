class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k = k%n;
        int i = 0;
        int j = n-1;
        //rotate array
        while(i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        //rotate first k elements
        int b = k;
        for (int a=0;a<b;a++){
            int temp = nums[a];
            nums[a] = nums[b-1];
            nums[b-1] = temp;
            b--;
        }
        //rotate other elements
        int c = k;
        int d = n-1;
        while(c<d){
            int temp = nums[c];
            nums[c]=nums[d];
            nums[d]=temp;
            c++;
            d--;
        }
        return;
    }
}