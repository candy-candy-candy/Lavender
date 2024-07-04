public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    public IntNode first;
    public SLList(int x){
        first = new IntNode(x, null);
    }

    // add a node at the front
    public void addFirst(int x){
        first = new IntNode(x, first);
    }

    // ptint the SLList
    public void printList(){
        IntNode current = this.first; //a pointer
        while (current != null){
            System.out.print(current.item);
            if (current.next != null){
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    // add an item to the end of the list
    /* It's ok to create a special node that is always there, which we will call a sentinel node*/
    public void addLast(int x){
        if (first == null){
            first = new IntNode(x, null);
            return; // end this method
        }
        IntNode current = first;
        while (current.next != null){
            current = current.next;
        }
        current.next = new IntNode(x, null);
    }

    // renturn the size of the SLList(recursive)
    public static int sizeOf (IntNode first){
        if (first == null){
            return 0;
        }
        return 1 + sizeOf(first.next);
    }
    public int size(){
        return sizeOf(first);
    }

    // iterative
    public int sizeIterative() {
        int count = 0;
        IntNode current = first;
        while (current != null) {
            count++;
            current = current.next; 
        }
        return count;
    }
    

    public static void main(String[] args){
        SLList A = new SLList(15); // create a new SLList
        A.addFirst(10);
        A.addFirst(5);
        A.addLast(20);
        A.printList(); // 5->10->15->20
        int x = A.size();
        System.out.println(x); //4
        int y = A.sizeIterative();
        System.out.println(y); //4
    }
}