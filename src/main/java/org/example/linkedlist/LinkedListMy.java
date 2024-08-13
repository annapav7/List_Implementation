package org.example.linkedlist;

    public class LinkedListMy<T> {
        private Node head;
        private Node last;
        private int size;

        // Node class definition
        private class Node {
            T data;
            Node next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        // Constructor
        public LinkedListMy() {
            this.head = null;
            this.last = null;
            this.size = 0;
        }

        // Method to create or reset the linked list
        public void create() {
            this.head = null;
            this.last = null;
            this.size = 0;
        }

        // Method to create a linked list with given values
        public void create(T[] values) {
            if (values == null) {
                throw new IllegalArgumentException("Values array cannot be null.");
            }

            create();  // Reset the list to empty

            for (T value : values) {
                add(value);
            }
        }

        // Method to add a node at the end
        public void add(T data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        // Method to print the list
        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Main method to test create()
        public static void main(String[] args) {
            LinkedListMy<Integer> list = new LinkedListMy<>();
            Integer[] values = {1, 2, 3, 4, 5};
            list.create(values);
            System.out.println("List after create() with values:");
            list.printList();  // Should print: 1 2 3 4 5
        }
    }
