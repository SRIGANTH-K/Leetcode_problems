class Solution {
    public int maxVowels(String s, int k) {
        // Count vowels in the first window of size k
        int initialCount = countVowels(s, 0, k);
        // Find the maximum recursively for the rest of the windows
        return helper(s, k, k, initialCount, initialCount);
    }
    
    // Helper function to count vowels in a specific range [start, end)
    private int countVowels(String s, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    
    // Recursive sliding window function
    private int helper(String s, int k, int index, int currentCount, int maxCount) {
        // Base case: if the window has slid past the end of the string
        if (index >= s.length()) {
            return maxCount;
        }
        
        // Slide window: add incoming character, remove outgoing character
        if (isVowel(s.charAt(index))) {
            currentCount++;
        }
        if (isVowel(s.charAt(index - k))) {
            currentCount--;
        }
        
        // Update max count
        maxCount = Math.max(maxCount, currentCount);
        
        // Recurse for the next index
        return helper(s, k, index + 1, currentCount, maxCount);
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
