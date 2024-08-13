package org.example.linkedlist;

public class LinkedListTwo {

        private Node first;
        private Node last;

        // Inner Node class
        private class Node {
            int data;
            Node next;
        }


        public LinkedListTwo() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {

            return first == null;
        }

        // Method to insert a node at a specific position
        public void insertAt(int data, int position) {

            Node newNode = new Node();
            newNode.data = data;

            if (position < 0) {
                throw new IllegalArgumentException("Position cannot be negative.");
            }

            if(position == 0) {
                // Insert at the beginning
                newNode.next = first;
                first = newNode;
                if (last == null) {
                    // If the list was empty, update the last reference as well
                    last = newNode;
                }
            } else {
                int index = 0;
                Node current = first;

                // Traverse to the node before the desired position
                while (current != null && index < position - 1) {
                    current = current.next;
                    index++;
                }

                if (current == null) {
                    throw new IndexOutOfBoundsException("Position out of bounds.");
                }

                // Insert new node at the desired position
                newNode.next = current.next;
                current.next = newNode;

                // If inserting at the end, update the last reference
                if (newNode.next == null) {
                    last = newNode;
                }
            }
        }

        // Method to print the list (for testing purposes)
        public void printList() {
            Node current = first;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        public static void main(String[] args) {
            LinkedListTwo list = new LinkedListTwo();
            list.insertAt(1, 0); // Insert 1 at position 0
            list.insertAt(2, 1); // Insert 2 at position 1
            list.insertAt(3, 1); // Insert 3 at position 1
            list.insertAt(4, 3); // Insert 4 at position 3
            list.printList(); // Output should be: 1 -> 3 -> 2 -> 4 -> null
        }
    }

