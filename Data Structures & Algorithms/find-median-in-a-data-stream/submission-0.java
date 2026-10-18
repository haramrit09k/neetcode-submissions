class MedianFinder {
    PriorityQueue<Integer> small; // max heap
    PriorityQueue<Integer> large; // min heap

    public MedianFinder() {
        small = new PriorityQueue<>(Comparator.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        if (small.size() - large.size() > 1) {
            int move = small.poll();
            large.offer(move);
        }

        if (large.size() - small.size() > 1) {
            int move = large.poll();
            small.offer(move);
        }
    }

    public double findMedian() {
        int totalLen = small.size() + large.size();
        double median;
        if (totalLen % 2 == 0) { // even
            median = ((double)(small.peek() + large.peek())) / 2.0;
        } else {
            median = small.size() > large.size() ? small.peek() : large.peek();
        }
        return median;
    }
}
