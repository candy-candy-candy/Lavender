public class SLList1 {
    public class IntNode {
        public String item;
        public IntNode next;
        public IntNode(String i, IntNode n){
            item = i;
            next = n;
        }
    }
    public IntNode first;
    public SLList1(String x){
        first = new IntNode(x, null);
    }
    
    // add a node at the front
    public void addFirst(String x){
        first = new IntNode(x, first);
    }
    
    // print the SLList
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

    // return the size of the SLList(recursive)
    public static int sizeOf (IntNode first){
        if (first == null){
            return 0;
        }
        return 1 + sizeOf(first.next);
    }
    public int size(){
        return sizeOf(first);
    }

    public String get (int x){
        IntNode current = first;
        for (int i = 0; i < x; i++) {
            if (current == null) {
                return null; // index out of bounds
            }
            current = current.next;
        }
        if (current != null) {
            return current.item;
        } else {
            return null; // index out of bounds
        }
    }

    public static String longest(SLList1 list) {
        int maxDex = 0;
        for (int i = 1; i < list.size(); i += 1) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args) {
        // Create a new SLList instance with an initial item
        SLList1 list = new SLList1("Milk");
    
        // Add more items to the front of the list
        list.addFirst("Banana");
        list.addFirst("Water");
    
        // Print the contents of the list
        System.out.print("SLList: ");
        list.printList();
    
        // Get the size of the list
        System.out.println("Size of the list: " + list.size());
    
        // Find the longest string in the list
        String longestString = longest(list);
        if (longestString != null) {
            System.out.println("Longest string in the list: " + longestString);
        } else {
            System.out.println("The list is empty.");
        }
    }
    
}
