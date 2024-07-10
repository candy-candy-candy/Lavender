public class VengefulSLList<Item> extends SLList<Item> {
    SLList<Item> deletedItems;

    public VengefulSLList() {
        deletedItems = new SLList<Item>();
    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast(); //父类
        deletedItems.addLast(x);
        return x;
    }

    /** Prints deleted items. */
    public void printLostItems() {
        deletedItems.printList();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vengefulList = new VengefulSLList<>();
        vengefulList.addLast(1);
        vengefulList.addLast(2);
        vengefulList.addLast(3);
        System.out.println("Removed item: " + vengefulList.removeLast());

        // 打印所有已删除的项目
        System.out.println("Lost items:");
        vengefulList.printLostItems();

        vengefulList.addLast(4);
        System.out.println("Removed item: " + vengefulList.removeLast());

        // 打印所有已删除的项目
        System.out.println("Lost items:");
        vengefulList.printLostItems();
    }
}