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

    public void detectLoop() {

        if (root == null || root.next == null || root.next.next == null)
            return ;

        Node<T> tortoise = root;
        Node<T> rabbit = root.next.next;

        while (tortoise != null && rabbit != null && rabbit.next != null && rabbit.next.next != null) {

            if (tortoise.value == rabbit.value) {

                System.out.println("Loop detected...");
                removeLoop(tortoise.value);
                System.out.println(".....and removed");
                return ;
            }

            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
        }

        System.out.println("No loops.............");
    }

    private void removeLoop(T meetingPoint) {

        Node<T> node = root;

        Node<T> ptr1 = null;

        while (node != null) {

            if (node.value == meetingPoint) {
                ptr1 = node;
                break;
            }

            node = node.next;
        }

        int loopLength = 1;

        Node<T> ptr2 = ptr1.next;

        while (ptr2.value != meetingPoint) {
            loopLength++;
            ptr2 = ptr2.next;
        }

        System.out.println("Loop length "+ loopLength);

        Node<T> fPtr1 = root;
        Node<T> fptr2 = fPtr1;

        for (int i = 0 ; i < loopLength; i++)
            fptr2 = fptr2.next;

        System.out.println("fptr2 is at "+ fptr2.value);

        while (fPtr1.value != fptr2.value) {
            fPtr1 = fPtr1.next;
            fptr2 = fptr2.next;
        }

        Node<T> startingOfLoop = fPtr1;
        Node<T> endOfLoop = fPtr1;

        System.out.println("Starting of loop = "+ startingOfLoop.value);

        for (int i = 0; i < loopLength - 1; i++)
            endOfLoop = endOfLoop.next;

        System.out.println("End of loop = "+ endOfLoop.value);

        endOfLoop.next = null;
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