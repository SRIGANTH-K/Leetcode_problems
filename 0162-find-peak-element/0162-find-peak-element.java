class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If the middle element is greater than the next element,
            // a peak must exist on the left side (including mid).
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } 
            // Otherwise, the peak must exist on the right side.
            else {
                left = mid + 1;
            }
        }
        
        // 'left' and 'right' converge to the peak element index.
        return left;
    }
}
