class Solution {
    public boolean isPalindrome(String s) {
        String s_clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s_clean);
        String s_rev = new StringBuilder(s_clean).reverse().toString();
        System.out.println(s_rev);
        return s_clean.equals(s_rev);
    }
}
