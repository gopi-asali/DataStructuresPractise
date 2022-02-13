import java.util.HashSet;
import java.util.Set;


class BinaryNode {

    BinaryNode left;
    BinaryNode right;
    int key;

    public BinaryNode(int item) {
        key = item;
        left = null;
        right = null;
    }


}

class BinaryTree {


    BinaryNode root = null;

    public void addKey(int key) {
        root = insertLement(root, key);
    }


    public BinaryNode insertLement(BinaryNode root, int element) {

        if (root == null) {
            root = new BinaryNode(element);
            return root;
        }

        if (root.key > element)
            root.left = insertLement(root.left, element);
        else
            root.right = insertLement(root.right, element);

        return root;
    }


    public void print(BinaryNode node) {

        if (node != null) {
            System.out.println(node.key);
            if (node.left != null) {
                print(node.left);
            }
            if (node.right != null) {
                print(node.right);
            }
        }


    }

    public void printElement() {
        print(root);
    }


    public boolean search(BinaryNode node, int ele) {

        if (node == null)
            return false;

        if (node.key == ele) {
            return true;
        }

        return search(node.left, ele) || search(node.right, ele);

    }

    public boolean findElement(int ele) {
        return search(root, ele);
    }


    public void printOrder(BinaryNode root) {

        if (root != null) {

//            if(root.left != null)
            printOrder(root.left);
            System.out.println(root.key);

//            if(root.right != null)
            printOrder(root.right);


        }

    }


    public void order() {


        printOrder(root);


    }


}

public class TreeTest {


//    Set value = new HashSet();


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();


        tree.addKey(5);
        tree.addKey(6);
        tree.addKey(4);
        tree.addKey(7);
        tree.addKey(9);

        tree.printElement();

        System.out.println(tree.findElement(10));
        System.out.println(tree.findElement(4));

        tree.order();

    }


}
