public class Sort{
    /** Returns the smallest string in x. 
    * @source Got help with string compares from https://goo.gl/a7yBU5. */
    /*字典里最靠前的*/
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i += 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void Swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /** Sorts strings destructively. */
    public static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        // find the smallest item
        int smallest = findSmallest(x, start);
        // move it to the front
        Swap(x, start, smallest);
        // selection sort the rest (using recursion?)
        sort(x, start + 1);
    }

    public static void main(String[] args){
        String[] input = {"i", "have", "an", "egg"};
        Sort.sort(input,0);
        int i = 0;
        for(i = 0; i < input.length; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}