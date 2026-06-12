class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        // min-heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for(int key: map.keySet()){
            heap.add(key);
            if(heap.size() > k){
                heap.poll(); // remove element with lowest frequency
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }

        return res;
    }
}
