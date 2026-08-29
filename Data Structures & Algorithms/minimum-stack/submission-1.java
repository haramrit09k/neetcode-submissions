class Entry{
    int val;
    int minSoFar;

    Entry(int val, int minSoFar){
        this.val = val;
        this.minSoFar = minSoFar;
    }

    public int getVal(){
        return val;
    }

    public int getMinSoFar(){
        return minSoFar;
    }
}

class MinStack {

    Stack<Entry> stack;
    
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = Math.min(val, stack.isEmpty() ? val: getMin());
        Entry e = new Entry(val, min);
        stack.push(e);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getVal();
    }
    
    public int getMin() {
        return stack.peek().getMinSoFar();
    }
}
