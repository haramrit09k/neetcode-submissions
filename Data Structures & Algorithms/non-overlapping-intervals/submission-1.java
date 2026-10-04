class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> outputs = new ArrayList<>();
        outputs.add(intervals[0]);

        int count = 0;

        for(int i = 1; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            int lastEnd = outputs.get(outputs.size() - 1)[1];
            
            if(start < lastEnd){
                count++;
                if(end < lastEnd){
                    outputs.set(outputs.size() - 1, new int[]{start, end});
                }
            }
            else{
                outputs.add(new int[]{start, end});
            }
        }

        return count;

    }
}
