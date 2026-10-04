/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int s = 0, e = 0;
        int rooms = 0, maxRooms = 0;

        while(s < intervals.size()){
            if(starts[s] < ends[e]){
                rooms++;
                s++;
            }
            else{
                rooms--;
                e++;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }
}
