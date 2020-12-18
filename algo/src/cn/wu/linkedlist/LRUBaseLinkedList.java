package cn.wu.linkedlist;

public class LRUBaseLinkedList<K,V> {

    private static final int DEFAULT_MAX = 10;

    private final int max;

    private int count = 0;

    private final Node head = new Node();

    public LRUBaseLinkedList(int max) {
        this.max = max;
    }

    public LRUBaseLinkedList() {
        this(DEFAULT_MAX);
    }

    public synchronized V get(K key) {
        Node preNode = findPre(key);
        Node p = preNode.next;
        if (p == null) {
            return null;
        } else {
            V v = (V) p.value;
            moveNodeFirst(preNode);
            return v;
        }
    }

    private void moveNodeFirst(Node preNode) {
        if (preNode != head) {
            //从原来的位置移除
            Node newFirst = preNode.next;
            preNode.next = newFirst.next;
            //添加到头部
            /*Node oldFirst = head.next;
            head.next = newFirst;
            newFirst.next = oldFirst;*/
            newFirst.next = head.next;
            head.next = newFirst;
        }
    }

    public synchronized void put(K key, V value) {
        Node pre = findPre(key);
        Node p = pre.next;
        if (p == null) {
            //此时pre为最后的一个节点
            if (count == max) {
                pre = removeLast();
            } else {
                count++;
            }
            pre.next = new Node(key, value);
        } else {
            moveNodeFirst(pre);
        }
    }



    private Node removeLast() {
        if (head.next == null) {
            return head;
        }

        Node pre = head;
        Node p = pre.next;
        while (p.next != null) {
            pre = p;
            p = p.next;
        }
        pre.next = null;
        p = null;
        return pre;
    }

    private Node findPre(K key) {
        Node pre = head;
        Node p = pre.next;
        while (p != null && !p.key.equals(key)) {
            pre = p;
            p = p.next;
        }
        return pre;
    }

}
