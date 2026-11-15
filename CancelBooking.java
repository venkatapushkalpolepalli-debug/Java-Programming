
import java.util.Scanner;

public class CancelBooking {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.data.equals(booking)) {
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node head = null;
        Node tail = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String booking = sc.next();

            Node newNode = new Node(booking);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String cancel = sc.next();

        head = removeFirst(head, cancel);

        display(head);

        sc.close();
    }
}
