class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map to store the required counts of characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Number of unique characters in t that need to match in the current window
        int requiredMatches = targetMap.size();
        int formedMatches = 0;

        // Map to keep track of characters in the current window of s
        Map<Character, Integer> windowMap = new HashMap<>();

        // Pointers and result trackers
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0; // Tracks the starting index of the best window

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // If the current character match criteria for 't', increment matches
            if (targetMap.containsKey(rightChar) && 
                windowMap.get(rightChar).equals(targetMap.get(rightChar))) {
                formedMatches++;
            }

            // Try to contract the window from the left when a valid window is found
            while (formedMatches == requiredMatches) {
                // Update the minimum window coordinates
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // If removing leftChar breaks the match criteria, decrement matches
                if (targetMap.containsKey(leftChar) && 
                    windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    formedMatches--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}