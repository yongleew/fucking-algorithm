package cn.wu.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListAlgo {

    public Node reverse(Node list) {

        Node p = list;
        Node head = new Node();
        while (p != null) {
            p.next = head.next;
            head.next = p;
            p = p.next;
        }
        list = head.next;
        head.next = null;
        return list;
    }

    //true 存在环
    public boolean checkCircle(Node list) {
        Set<Node> nodes = new HashSet<>();
        Node p = list;
        while (p != null) {
            boolean add = nodes.add(p);
            if (!add) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    //

    /**
     * 快慢指针
     * 在环中，同一方向，速度不同，两者必会相遇.
     */
    public boolean checkCircleDoublePointer(Node list) {
        if (list == null) {
            return false;
        }
        Node slow = list;
        Node fast = list.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //O(n)
    public Node merge(Node list1, Node list2) {
        Node head = new Node();
        Node p = head;
        while (list1 != null && list2 != null) {
            int list1Key = (int) list1.key;
            int list2Key = (int) list2.key;
            if (list1Key < list2Key) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        Node list = head.next;
        head.next = null;
        return list;
    }

    public Node deleteLastN(Node list, int n) {
        Node head = new Node();
        head.next = list;
        Node p = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
            if (p == null) {
                throw new IllegalStateException("n 大于链表长度");
            }
        }
        Node pre = head;
        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }
        //删除
        pre.next = pre.next.next;

        head.next = null;
        return list;
    }

    /**
     * 快慢指针 快指针速度是慢指针的两倍
     *  快指针到底终点时，慢指针只走了快指针一般的距离，即中点
     */
    public Node middleNode(Node list) {
        Node pre = list;
        Node p = list;
        while (p != null && pre.next != null) {
            p = p.next.next;
            pre = pre.next;
        }
        return pre;
    }
}
