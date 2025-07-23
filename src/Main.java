public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> ints = new SinglyLinkedList<>();
        ints.add(1);
        ints.add(2);
        ints.addFirst(0);// 2
        ints.addLast(3);
        ints.remove(1);
        System.out.println("remove first: " + ints.removeFirst());
        System.out.println("remove last: " + ints.removeLast());
        System.out.println(ints);
        System.out.println(ints.size());
    }
}