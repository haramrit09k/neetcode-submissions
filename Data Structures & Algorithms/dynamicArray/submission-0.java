class DynamicArray {

    int[] arr;
    int capacity;
    int size;
    
    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(this.size == this.capacity) {
            resize();
        }
        this.arr[size] = n;
        this.size++;
    }

    public int popback() {
        this.size -= 1;
        return this.arr[this.size];
    }

    private void resize() {
        int[] arr_new = new int[2*this.capacity];
        for(int i = 0; i<this.capacity; i++){
            arr_new[i] = this.arr[i];
        }
        this.arr = arr_new;
        this.capacity = 2*this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
