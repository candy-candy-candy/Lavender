public class DLList{
    public class IntNode{
        public int item;
        public IntNode prev;
        public IntNode next;
        public IntNode (int i){
            this.item = i;
            this.prev = null;
            this.next = null;
        }
    }
    IntNode head;
    IntNode tail;
    public DLList(){
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int i){
        IntNode newNode = new IntNode (i);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int i){
        IntNode newNode = new IntNode (i);
        if (tail == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printForward(){
        IntNode current = head;
        while(current != null){
            System.out.print(current.item);
            if(current.next != null){
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward(){
        IntNode current = tail;
        while(current != null){
            System.out.print(current.item);
            if(current.prev != null){
                System.out.print("->");
            }
            current = current.prev;
        }
        System.out.println();
    }

    public void removeAt(int pos){
        if (head == null) {
            System.out.println("链表为空，无法删除元素。");
            return;
        }
        if (pos < 1) {
            System.out.println("无效的位置。");
            return;
        }
        IntNode current = head;
        int count = 1;
        while (current != null && count < pos){
            current = current.next;
            count = count + 1;
        }
        if (current == null) {
            System.out.println("位置超出链表长度。");
        }
        if (current == head && current == tail) {
            // Case 1: Single node in the list
            head = null;
            tail = null;
        }
        else if (current == head) {
            // Case 2: Deleting the head node
            head = current.next;
            head.prev = null;
        }
        else if (current == tail) {
            // Case 3: Deleting the tail node
            tail = current.prev;
            tail.next = null;
        }
        else {
            // Case 4: Deleting a node in the middle
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println("成功删除位置 " + pos + " 的元素。");
    }

    public static void main(String[] args) {
        DLList L = new DLList();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        System.out.print("正向打印链表： ");
        L.printForward();
        System.out.print("反向打印链表： ");
        L.printBackward();
        L.removeAt(3);
        System.out.println("删除元素后链表：");
        L.printForward();
    }
}