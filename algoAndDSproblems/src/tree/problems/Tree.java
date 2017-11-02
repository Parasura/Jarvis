package tree.problems;


/**
 * Created by parasuram on 21/10/17
 */
public class Tree {

    private Node root;

    private class Node{

        private Integer value;
        private Node left;
        private Node right;

        private Node(Integer value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }

    public void insert(Integer value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        insert(root, new Node(value));
    }

    private Node insert(Node currentNode, Node node) {

        if (currentNode == null)
            return node;

        if (currentNode.value > node.value)
            currentNode.left = insert(currentNode.left, node);
        else
            currentNode.right = insert(currentNode.right, node);

        return currentNode;
    }

    public void print() {
        if (root == null)
            return;

        printValue(root);
    }

    private void printValue(Node node) {

        System.out.println(node.value);

        if (node.right != null)
            printValue(node.right);

        if (node.left != null)
            printValue(node.left);
    }
}