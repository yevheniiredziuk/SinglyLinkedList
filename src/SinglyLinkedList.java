import java.util.NoSuchElementException;

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
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    public void addLast(T info) {
        Node<T> newNode = new Node<>(info);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public void add(T info) {
       addLast(info);
    }

    public void add(int index, T info) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(info);
            return;
        }
        if (index == size) {
            addLast(info);
            return;
        }
        Node<T> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node<T> newNode = new Node<>(info);
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
            throw new NoSuchElementException("List is empty");
        }
        T info = head.info;
        head = head.next;
        size--;
        if (head == null) { // список став порожнім
            tail = null;
        }
        return info;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (head == tail) { // лише 1 елемент
            return removeFirst();
        }
        Node<T> prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        T info = tail.info;
        tail = prev;
        tail.next = null;
        size--;
        return info;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<T> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        T info = prev.next.info;
        prev.next = prev.next.next;
        size--;
        return info;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> node = head;
        while (node != null) {
            sb.append(node.info);
            if (node.next != null) sb.append(", ");
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
