class Solution {
    public boolean checkAns(int[] arr, int k, int s){
        long time=0;
        for(int i:arr){
            if(i%s != 0){
                time += i/s + 1;
            }else{
                time += i/s;
            }
        }
        return time<=k;
    }
    public int minEatingSpeed(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int i:arr){
            if(i>max) max = i;
        }
        int l = 1,r=max;
        int ans=Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            if(checkAns(arr,k,mid)){
                ans=Math.min(ans,mid);
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}