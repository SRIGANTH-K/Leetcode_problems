class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> ans = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (char c : s.toCharArray()){
            ans.put(c, ans.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()){
            ans.put(c, ans.getOrDefault(c,0) - 1);
        }
        for (int i : ans.values()){
            if (i!=0) return false;
        }
        return true;
    }
}