class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for(int i = 0; i < 32; i++){
            int bit = n & 1; // get rightmost bit

            result = result << 1; //make space for new bit
            result = result | bit; // add the bit

            n = n >>> 1; // drop the bit we just used (rightmost)
        }

        return result;
    }
}
