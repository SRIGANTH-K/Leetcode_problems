class Solution {
    public int maxVowels(String s, int k) {
        int initial = 0;
        for (int i = 0; i < k; i++) if ("aeiou".indexOf(s.charAt(i)) >= 0) initial++;
        return helper(s, k, k, initial, initial);
    }

    private int helper(String s, int k, int idx, int curr, int max) {
        if (idx >= s.length()) return max;
        if ("aeiou".indexOf(s.charAt(idx)) >= 0) curr++;
        if ("aeiou".indexOf(s.charAt(idx - k)) >= 0) curr--;
        return helper(s, k, idx + 1, curr, Math.max(max, curr));
    }
}
