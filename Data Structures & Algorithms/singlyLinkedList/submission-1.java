class ListNode {

    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {

    ListNode head;
    ListNode tail;
    int size;
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if(index >= this.size){
            return -1;
        }
        ListNode temp = head;
        for(int i = 0; i < index; i ++){
            temp = temp.next;
        }
        return temp.val;
    }

    public void insertHead(int val) {
        ListNode temp = new ListNode(val);
        if(this.head == null) {
            this.head = temp;
            this.tail = temp;
        }
        else{
            temp.next = head;
            head = temp;
        }
        this.size++;
    }

    public void insertTail(int val) {
        ListNode temp = new ListNode(val);
        if(this.tail == null){
            this.head = temp;
            this.tail = temp;
        }
        else{
            this.tail.next = temp;
        }
        this.size++;
    }

    public boolean remove(int index) {
        if(index > this.size){
            return false;
        }
        ListNode temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        this.size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ListNode temp = head;
        ArrayList<Integer> vals = new ArrayList<Integer>();
        for(int i = 0; i < this.size; i++){
            vals.add(temp.val);
            temp = temp.next;
        }
        return vals;
    }
}
