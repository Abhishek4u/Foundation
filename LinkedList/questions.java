package LinkedList;

import java.util.LinkedList;

public class questions {

    public static void main(String[] args) {

    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node() {
        };
    }

    static Node head;
    static Node tail;
    int size;
    // Add last
    // https://www.pepcoding.com/resources/online-java-foundation/linked-lists/

    public void addLast(int val) {
        // Write your code here
        Node temp = new Node(val);

        if (tail != null) {
            tail.next = temp;
        } else {
            head = temp;
        }
        tail = temp;
        this.size++;
    }

    // Display

    public void display() {
        // write code here
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Remove First In Linkedlist
    // https://www.pepcoding.com/resources/online-java-foundation/linked-lists/remove-first-linked-list-official/ojquestion#
    // ********Amazon(4)**Facebook(5)**Bloomberg(2)**CapitalOne(2)**PureStorage(10)****

    public void removeFirst() {
        // write your code here
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        head = head.next;

        temp.next = null;// disconnect from list
        this.size--;
    }

    // GET in ll
    // https://www.pepcoding.com/resources/online-java-foundation/linked-lists/get-in-linked-list-official/ojquestion#
    public int getFirst() {
        // write your code here
        if (this.size == 0) {
            System.out.println("List is empty");
            return -1;

        } else
            return this.head.data;
    }

    public int getLast() {
        // write your code here
        if (this.size == 0) {
            System.out.println("List is empty");
            return -1;

        } else
            return this.tail.data;
    }

    public int getAt(int idx) {
        // write your code here
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;

        } else if (this.size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            int i = 0;
            Node temp = head;
            while (i++ < idx) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    // ADD FIRST
    public void addFirst(int val) {
        // write your code here
        Node temp = new Node();
        temp.data = val;

        if (this.size == 0) {
            this.head = temp;
            this.tail = temp;
            this.size++;

        } else {
            temp.next = head;

            head = temp;
            this.size++;
        }
    }

    // ADD at
    public void addAt(int idx, int val) {
        // write your code here
        if (idx < 0 || idx > this.size) {
            System.out.println("Invalid arguments");

        } else if (idx == 0) {
            addFirst(val);

        } else if (idx == this.size) {
            addLast(val);

        } else {

            Node temp = new Node();
            temp.data = val;

            Node curr = head;
            int i = 0;
            while (i++ < idx - 1) {
                curr = curr.next;
            }

            temp.next = curr.next;
            curr.next = temp;
            this.size++;
        }
    }

    // Remove Last
    public void removeLast() {
        // write your code here
        if (this.size == 0) {
            System.out.println("List is empty");

        } else if (head == tail) {
            head = tail = null;
            this.size--;

        } else {
            Node node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            node.next = null;
            tail = node;
            this.size--;
        }
    }

    // REmove At
    public void removeAt(int idx) {
        // write your code here
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            size--;
        }
    }

    // Reverse linked list data iterative

    // APPROACH : USE ARRAY REVERSE TECHNIQUE BY USING GETNODEAT FUNCTION
    private Node getNodeAt(int idx) {
        Node temp = head;

        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void reverseDI() {
        // write your code here
        int si = 0, end = this.size - 1;

        while (si < end) {
            Node left = getNodeAt(si);
            Node right = getNodeAt(end);

            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            si++;
            end--;
        }
    }

    // REVERSE POINTER ITERATIVE
    public void reversePI() {
        // write your code here

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node fwd = curr.next;

            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        tail = head;
        head = prev;
    }

    // RETURN K FROM LAST (K IS 0 BASED INDEX)

    public int kthFromLast(int k) {
        // write your code here

        int idx = this.size - k - 1;
        int i = 0;

        Node node = head;
        while (i++ != idx) {
            node = node.next;
        }

        return node.data;
    }

    // ANOTHER APPROACH WOULD BE BY MAKINK A GAP OF K BETWEEN 2 NODES AND TAVERSE
    // UNTIL LENGTH

    public int kthFromLast2(int k) {
        // write your code here

        Node c1 = head;
        Node c2 = head;

        while (k-- >= 0)
            c2 = c2.next;

        while (c2 != null) {
            c1 = c1.next;
            c2 = c2.next;
        }

        return c1.data;
    }

    // FIND MID OF LIST
    // TORTOISE METHOD

    public int mid() {
        // write your code here
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // MERGE TWO SORTED LISTS

    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        // write your code hered

        Node c1 = l1.head;
        Node c2 = l2.head;

        LinkedList<> ans = new LinkedList<>();

        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                ans.addLast(c1.data);
                c1 = c1.next;
            } else {
                ans.addLast(c2.data);
                c2 = c2.next;
            }

        }

        while (c1 != null) {
            ans.addLast(c1.data);
            c1 = c1.next;
        }
        while (c2 != null) {
            ans.addLast(c2.data);
            c2 = c2.next;
        }

        return ans;
    }

    // MERGE-SORT 2 LINKEDLIST

    // APPROACH : FIND MID AND THEN DO MERGESORT RECURSIVELY AND THEN MERGE2SORTED LL

    public static Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = tail;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static LinkedList mergeSort(Node head, Node tail) {
        // write your code here

        if (head == tail) {
            LinkedList ans = new LinkedList();
            ans.addLast(head.data);
            return ans;
        }

        Node mid = midNode(head, tail);

        LinkedList left = mergeSort(head, mid);
        LinkedList right = mergeSort(mid.next, tail);

        return mergeTwoSortedLists(left, right);
    }

}