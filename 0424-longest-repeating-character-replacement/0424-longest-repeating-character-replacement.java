class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26]; // To store frequencies of 'A' through 'Z'
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Include the current character in our window count
            int rightCharIndex = s.charAt(right) - 'A';
            counts[rightCharIndex]++;
            
            // Update the maximum frequency found in any window so far
            maxFreq = Math.max(maxFreq, counts[rightCharIndex]);
            
            // Current window size = right - left + 1
            // If the remaining characters to replace exceed k, shrink the window
            if ((right - left + 1) - maxFreq > k) {
                int leftCharIndex = s.charAt(left) - 'A';
                counts[leftCharIndex]--;
                left++; // Move left pointer to shrink window
            }
            
            // The valid window size can grow or maintain its max historical size
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
