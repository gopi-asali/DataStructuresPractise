class Node {

    int value;
    Node next = null;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

}

class LinkedList {

    Node node = null;


    public Node addElement(Node node, Node element) {

        if (node == null) {
            node = element;
            return node;
        } else
            node.next = addElement(node.next, element);
        return node;

    }

    public void addElement(int value) {
        node = addElement(node, new Node(value));
    }


    boolean isEleEx(Node node, int ele) {

        if (node == null) {
            return false;
        }
        if (node.value == ele)
            return true;
        else return isEleEx(node.next, ele);
    }

    boolean isElementExists(int value) {
        return isEleEx(node, value);
    }


    Node removeEle(Node node, int ele) {

        if (node == null) {
            return null;
        } else if (node.value == ele) {
            node = node.next;
            return node;
        } else {
            node.next = removeEle(node.next, ele);
            return node;
        }


    }

    int size(Node node, int value) {
        if (node != null) {
            return size(node.next, value + 1);
        } else
            return value;

    }


    boolean remove(int value) {

        int initSize = size(node, 0);

        if (node.value == value) {
            node = node.next;
            return true;
        } else {
            node.next = removeEle(node.next, value);
        }

        int finalsize = size(node, 0);
        return initSize != finalsize;

    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();

        if (node != null) {
            s.append(node.value);

            Node temp = node.next;
            while (temp != null) {
                s.append(" ,").append(temp.value);
                temp = temp.next;
            }


        }


        return "LinkedList{" +
                "" + s +
                '}';
    }
}


public class LinkedListTest {


    public static void main(String[] args) {


        LinkedList list = new LinkedList();

        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        System.out.println(list.isElementExists(2));
        System.out.println(list.isElementExists(5));
        System.out.println(list.remove(2));
        System.out.println(list.remove(10));
        System.out.println(list);


    }


}



