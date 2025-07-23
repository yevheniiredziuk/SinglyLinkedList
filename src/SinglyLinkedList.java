public class SinglyLinkedList<T> {

    private static class Node<T> {
        T info;
        Node<T> next;
        private Node(T info) {
            this.info = info;
        }
        private T getInfo() {
            return info;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(T info) {
        Node<T> newNode = new Node<>(info);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void addLast(T info) {
        Node<T> newNode = new Node<>(info);
        if (head == null) {
            addFirst(info);
            return;
        }
        Node<T> prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = newNode;
        tail = newNode;
        size++;
    }
    public void add(int index, T info) {
        if(isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(info);
        if (index == 0) {
            addFirst(info);
        }
        if (index == size - 1) {
            addLast(info);
        }
        Node<T> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.info;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null; // or size == 0, but we can forget to update size somewhere :)
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.info;
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.info;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> node = head;
        head = head.next;
        size--;
        return node.info;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> node = tail;
        tail = tail.next;
        size--;
        return node.info;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node<T> current = node.next;
        node.next = current.next;
        size--;
        return current.info;
    }
}
