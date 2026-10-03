class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> outputs = new ArrayList<>();
        outputs.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int lastEnd = outputs.get(outputs.size() - 1)[1];

            if(start <= lastEnd){
                outputs.get(outputs.size() - 1)[1] = Math.max(end, lastEnd);
            }
            else{
                outputs.add(new int[]{start, end});
            }
        }

        return outputs.toArray(new int[outputs.size()][2]);
    }
}
