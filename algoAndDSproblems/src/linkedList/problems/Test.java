package linkedList.problems;

/**
 * Created by parasuram on 19/10/17
 */
public class Test {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.print();

        list.detectLoop();

        list.createLoopBetween(5, 4);

        list.detectLoop();

        list.print();
    }
}