// DP solution
class Solution {
    public int[] countBits(int n) {
        int[] count = new int[n+1];

        count[0] = 0;

        for(int i = 1; i <= n; i++){
        // trick is (answer in half) + (check if last bit is 1)
            count[i] = (count[i >> 1]) + (i & 1);
        }

        return count;
    }
}
