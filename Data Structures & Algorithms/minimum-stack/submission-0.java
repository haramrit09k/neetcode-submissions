class MinStack {

    List<Integer> stack;
    int top;
    public MinStack() {
        this.stack = new ArrayList<Integer>();
        this.top = -1;
    }
    
    public void push(int val) {
        this.stack.add(val);
        this.top++;
    }
    
    public void pop() {
        this.stack.remove(this.top);
        this.top--;
    }
    
    public int top() {
        return this.stack.get(this.top);        
    }
    
    public int getMin() {
        return Collections.min(this.stack);
    }
}
