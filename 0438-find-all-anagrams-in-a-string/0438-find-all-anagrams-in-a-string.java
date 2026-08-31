import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        
        // Edge case: if s is shorter than p, an anagram is impossible
        if (sLen < pLen) {
            return result;
        }
        
        // Frequency counts for string p and the sliding window in s
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Populate the frequency map for p and the first window of s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Check if the very first window is an anagram
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }
        
        // Slide the window across string s
        for (int i = pLen; i < sLen; i++) {
            // Add the new character entering the window
            sCount[s.charAt(i) - 'a']++;
            
            // Remove the character that is leaving the window
            sCount[s.charAt(i - pLen) - 'a']--;
            
            // If the frequencies match, we found an anagram starting at index (i - pLen + 1)
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
}
