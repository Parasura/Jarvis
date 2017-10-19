package linkedList.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by parasuram on 19/10/17
 */
public class MyLinkedList<T> {

    private Node<T> root;

    private class Node<T> {

        private T value;

        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<T> node = (Node<T>) o;

            return value != null ? value.equals(node.value) : node.value == null;
        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

    public void add(T value) {

        Node<T> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> node = root;

        while (node.next != null)
            node = node.next;

        node.next = newNode;
    }

    public void remove(T value) {

        if (root == null)
            return;

        if (root.value == value) {
            root = root.next;
            return;
        }

        Node<T> previousNode = root;
        Node<T> currentNode = root.next;

        while (currentNode != null) {

            if (currentNode.value == value) {
                previousNode.next = currentNode.next;
                break;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void createLoopBetween(T source, T dest) {

        if (root == null)
            return;

        Node<T> node = root;

        boolean sourceFound = false;
        boolean destFound = false;

        Node<T> sourceNode = null;
        Node<T> destNode = null;

        while (node != null) {

            if (node.value == source) {
                sourceFound = true;
                sourceNode = node;
            }

            if (node.value == dest) {
                destFound = true;
                destNode = node;
            }

            if (sourceFound && destFound)
                break;

            node = node.next;
        }

        if (!sourceFound || !destFound) {
            System.out.println("Source and/or destination not found...");
            return;
        }

        sourceNode.next = destNode;

        System.out.println("Loop created between " + source + " and " + dest);
    }

    public boolean detectLoop() {

        if (root == null)
            return false;

        Set<Node<T>> set = new HashSet<>();

        Node<T> node = root;

        while (node != null) {
            boolean add = set.add(node);

            if (!add)
                return true;

            node = node.next;
        }

        return false;
    }

    public void print() {

        if (root == null) {
            System.out.println("Empty linked list....");
            return;
        }

        //Keeping to avoid infinite loop
        int count = 0;

        Node<T> node = root;

        while (node != null && ++count < 100) {
            System.out.print(node.value + " ");
            node = node.next;
        }

        System.out.println();
    }
}