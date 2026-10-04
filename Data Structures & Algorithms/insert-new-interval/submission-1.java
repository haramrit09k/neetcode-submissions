class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> outputs = new ArrayList<>();
        int i = 0;

        // insert everything before newInterval
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            outputs.add(intervals[i]);
            i++;
        }

        //merge overlapping intervals with newInterval
        while(i < intervals.length && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // after loop ends and overlapping are all merged
        outputs.add(newInterval);

        //insert everything after newInterval
        while(i < intervals.length && intervals[i][0] > newInterval[1]){
            outputs.add(intervals[i]);
            i++;
        }

        return outputs.toArray(new int[outputs.size()][2]);
    }
}
