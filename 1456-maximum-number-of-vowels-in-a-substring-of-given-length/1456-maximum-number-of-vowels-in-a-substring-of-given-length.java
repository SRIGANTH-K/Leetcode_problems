class Solution {
    public int maxVowels(String s, int k) {
        return solve(s, k, 0, 0, 0);
    }

    private int solve(String s, int k, int idx, int curr, int max) {
        if (idx >= s.length()) return max;

        // Add incoming character
        if ("aeiou".indexOf(s.charAt(idx)) >= 0) curr++;
        
        // Remove outgoing character (only after the first window of size k is formed)
        if (idx >= k && "aeiou".indexOf(s.charAt(idx - k)) >= 0) curr--;

        // Track max count once we have a valid window size
        if (idx >= k - 1) max = Math.max(max, curr);

        return solve(s, k, idx + 1, curr, max);
    }
}
