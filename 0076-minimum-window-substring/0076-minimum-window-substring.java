class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] targetCounts = new int[128];
        for (char c : t.toCharArray()) {
            targetCounts[c]++;
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredCount = t.length();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If the character is part of 't', decrease our target requirement
            if (targetCounts[rightChar] > 0) {
                requiredCount--;
            }
            targetCounts[rightChar]--; // Becomes negative for non-t characters or excess
            right++;

            // When a valid window is found, shrink from the left
            while (requiredCount == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                targetCounts[leftChar]++;
                
                // If it becomes positive, it means we lack a necessary character for 't'
                if (targetCounts[leftChar] > 0) {
                    requiredCount++;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
