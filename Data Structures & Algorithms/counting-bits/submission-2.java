class Solution {
    public int[] countBits(int n) {
        int count[] = new int[n+1];

        for(int i = 0; i <= n; i++){
            int num = i;
            while(num != 0){
                num = num & (num-1);
                count[i]++;
            }
        }

        return count;
    }
}
