class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null; // A node's next should always be null when created
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

    /** 
     * Gotcha 1: Always check index < 0 or index >= size for out-of-bounds access 
     */
    public int get(int index) {
        if (index < 0 || index >= this.size) { // Prevents out-of-bounds access
            return -1;
        }
        ListNode temp = head;
        for (int i = 0; i < index; i++) { // Traverse to the correct index
            temp = temp.next;
        }
        return temp.val;
    }

    /** 
     * Gotcha 2: When inserting into an empty list, update both head and tail 
     */
    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        if (this.head == null) { // Special case: First node being inserted
            this.head = newNode;
            this.tail = newNode; // Both head and tail should point to the new node
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    /** 
     * Gotcha 3: Ensure `tail` is correctly updated when inserting at the tail
     */
    public void insertTail(int val) {
        ListNode newNode = new ListNode(val);
        if (this.head == null) { // Special case: If list is empty
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode; // Attach new node to the tail
            this.tail = newNode; // Update tail pointer
        }
        this.size++;
    }

    /** 
     * Gotcha 4: When removing, always check if it's the last node and update `tail`
     * Gotcha 5: If list becomes empty, set both `head` and `tail` to null
     * Gotcha 6: Don't update `tail` too early inside the loop, update it after finding the node
     */
    public boolean remove(int index) {
        if (index < 0 || index >= this.size) { // Prevents invalid index removal
            return false;
        }

        if (index == 0) { // Special case: Removing the head
            this.head = this.head.next; // Move head to the next node
            if (this.head == null) { // If list is now empty, also update tail
                this.tail = null;
            }
            this.size--;
            return true;
        }

        ListNode temp = head;
        for (int i = 0; i < index - 1; i++) { // Stop at the node before the one being removed
            temp = temp.next;
        }

        if (temp.next == tail) { // If removing last node, update tail properly
            this.tail = temp;
        }

        temp.next = temp.next.next; // Remove the node by bypassing it
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
