class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            n = n & (n-1); //main formula - removes the lowest/rightmost set bit.
            count++;
        }

        return count;
    }
}
