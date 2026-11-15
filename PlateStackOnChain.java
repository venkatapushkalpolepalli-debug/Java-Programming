
import java.util.Scanner;

public class PlateStackOnChain {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        Node top;
        int size = 0;

        void push(String plate) {
            Node newNode = new Node(plate);
            newNode.next = top;
            top = newNode;
            size++;
        }

        String pop() {
            if (isEmpty()) {
                return null;
            }

            String plate = top.data;
            top = top.next;
            size--;

            return plate;
        }

        String peek() {
            if (isEmpty()) {
                return null;
            }

            return top.data;
        }

        boolean isEmpty() {
            return top == null;
        }

        int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack stack = new Stack();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            if (operation.startsWith("push")) {
                String plate = operation.substring(
                    operation.indexOf('(') + 1,
                    operation.indexOf(')')
                );

                stack.push(plate);

                System.out.println("push " + plate + " -> top "
                        + stack.peek() + ", size " + stack.getSize());

            } else if (operation.equals("pop()")) {
                String plate = stack.pop();

                if (plate == null) {
                    System.out.println("pop -> stack is empty");
                } else {
                    System.out.println("pop -> " + plate
                            + ", size " + stack.getSize());
                }

            } else if (operation.equals("peek()")) {
                String plate = stack.peek();

                if (plate == null) {
                    System.out.println("peek -> stack is empty");
                } else {
                    System.out.println("peek -> " + plate);
                }

            } else if (operation.equals("isEmpty()")) {
                System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }

        sc.close();
    }
}
