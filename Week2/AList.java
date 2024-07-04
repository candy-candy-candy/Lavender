/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/
public class AList{
    public int items[];
    public int size;

     /** Creates an empty list. */
     public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];        
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i - 1];        
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;        
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size = size - 1;
        return x;
    }

    public void addItem(int i){
        int[] a = new int[size + 1];
        System.arraycopy(items, 0, a, 0, size);
        a[size] = i;
        items = a;
        size = size + 1;
        System.out.println(i);
    }

    public static void main(String[] args){
        AList L = new AList();
        L.addLast(5);
        L.addLast(10);
        L.addLast(15);
        int x = L.getLast(); //15
        int y = L.get(2); //10
        int z = L.removeLast(); //15
        int s1 = L.size(); //2
        System.out.println(x+ " " + y + " " + z + " " + s1);
        L.addItem(20); //20
        int s2 = L.size();
        System.out.println(s2); //3 
        //the array doesn't actually change size, we are just making a new one that has a bigger size
    }
}