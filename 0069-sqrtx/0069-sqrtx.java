class Solution {
    public int mySqrt(int x) {
        long i = 1, j = x;
        while(i<=j){
            long mid = (i+j)/2;
            if(mid*mid == x){
                return (int)mid;
            }else if (mid*mid >x){
                j = mid -1;
            }else{
                i = mid+1;
            }
        }
    return (int) i-1;    
    }
}