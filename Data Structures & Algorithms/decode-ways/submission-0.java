class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1]; //num of ways of decoding first 'i' chars

        dp[0] = 1; //empty string

        if(s.charAt(0) != '0'){
            dp[1] = 1;
        }

        for(int i = 2; i <= n; i++){
            int num = s.charAt(i-1) - '0'; // last digit (before i) 
            if(num >= 1 && num <= 9){
                dp[i] += dp[i-1];
            }

            int num2 = Integer.parseInt(s.substring(i-2, i)); // last 2 digits (before i)
            if(num2 >= 10 && num2 <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
