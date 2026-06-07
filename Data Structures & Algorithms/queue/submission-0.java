class Node{
    int val;
    Node next;
    Node prev;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    public Node(int val, Node prev, Node next){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class Deque {

    Node front;
    Node back;
    
    public Deque() {
        this.front = null; //beginning pointer
        this.back = null; //end pointer
    }

    public boolean isEmpty() {
        return this.front == null && this.back == null;
    }

    public void append(int value) {
       Node newNode = new Node(value);
       if(isEmpty()){
        this.front = newNode;
        this.back = newNode;
       }
       else{
           newNode.next = this.back;
           this.back.prev = newNode;
           this.back = newNode;
       }
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            this.front = newNode;
            this.back = newNode;
        }
        else {
            newNode.prev = this.front;
            this.front.next = newNode;
            this.front = newNode;
        }
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        int poppedVal = this.back.val;
        if(this.front == this.back){
            this.front = null;
            this.back = null;
        }
        else if(this.back != null){
            this.back = this.back.next;
        }
        return poppedVal;
    }

    public int popleft() {
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        int poppedVal = this.front.val;
        if(this.front == this.back){
            this.front = null;
            this.back = null;
        }
        else if(this.front != null){
            this.front = this.front.prev;
        }
        return poppedVal;
    }
}
