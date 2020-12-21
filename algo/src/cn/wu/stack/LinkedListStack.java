package cn.wu.stack;

public class LinkedListStack {

    private Node head = new Node();

    private static final int MAX_SIZE = Integer.MAX_VALUE;

    int count;

    public boolean push(Object val) {
        if (count < MAX_SIZE) {
            Node node = new Node(val);
            node.next = head.next;
            head.next = node;
            count++;
            return true;
        }
        return false;
    }

    public Object pop() {
        if (count > 0) {
            count--;
            Node curr = head.next;
            return curr.val;
        }
        return null;
    }

    public void clear() {
        head.next = null;
    }

    public int size() {
        return count;
    }

    class Node{
        Object val;
        Node next;

        public Node(Object val) {
            this.val = val;
        }

        public Node() {
        }
    }
}
