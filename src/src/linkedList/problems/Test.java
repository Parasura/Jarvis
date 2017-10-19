package linkedList.problems;

/**
 * Created by parasuram on 19/10/17
 */
public class Test {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        myLinkedList.print();

        myLinkedList.createLoopBetween(5, 2);

        myLinkedList.print();
    }
}
