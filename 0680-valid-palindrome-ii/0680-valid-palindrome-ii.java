class Solution {
    public boolean Palindrome(String s) {
        int i=0, j = s.length()-1;
        while (i<j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }



    public boolean validPalindrome(String s) {
        int i=0, j = s.length()-1;
        while (i<j){
            if (s.charAt(i) != s.charAt(j)){
                String temp = s.substring(0,i)+s.substring(i+1,s.length());
                String temp2 = s.substring(0,j)+s.substring(j+1,s.length());
                if(Palindrome(temp) || Palindrome(temp2)){
                    return true;
                }else return false;
            }
            i++;
            j--;
        }
        return true;
    }
}