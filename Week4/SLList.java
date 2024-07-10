import java.util.NoSuchElementException;

public class SLList<Item> implements List61B<Item> {
    private Node<Item> first; // 头结点
    private int size; // 单链表的大小

    // 节点类
    private static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void addFirst(Item x) {
        Node<Item> newNode = new Node<>(x, first);
        first = newNode;
        size++;
    }

    @Override
    public void addLast(Item x) {
        Node<Item> newNode = new Node<>(x, null);
        if (first == null) {
            first = newNode;
        } else {
            Node<Item> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public Item getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.item;
    }

    @Override
    public Item getLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node<Item> current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printList(){
        Node<Item> current = this.first; //a pointer
        while (current != null){
            System.out.print(current.item);
            if (current.next != null){
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public Item removeLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }

        // Case 1: Only one element in the list
        if (first.next == null) {
            Item removedItem = first.item;
            first = null;
            size--;
            return removedItem;
        }

        // Case 2: More than one element in the list
        Node<Item> current = first;
        while (current.next.next != null) {
            current = current.next;
        }

        Item removedItem = current.next.item;
        current.next = null; // Remove the last node

        size--;
        return removedItem;
    }


    public static void main(String[] args) {
        SLList<Integer> list = new SLList<>();

        // 添加元素
        list.addFirst(3);
        list.addFirst(5);
        list.addLast(7);

        // 测试获取第一个和最后一个元素
        System.out.println("First element: " + list.getFirst());  // 应该输出 5
        System.out.println("Last element: " + list.getLast());    // 应该输出 7

        // 测试链表大小
        System.out.println("Size of the list: " + list.size());// 应该输出 3
        list.printList();
    }
}
