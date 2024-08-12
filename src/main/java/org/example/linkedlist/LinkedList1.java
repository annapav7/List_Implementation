package org.example.linkedlist;

public class LinkedList1 {
        private Node first;
        private Node last;

    // Inner Node class for the singly linked list
    private class Node {
        int data;
        Node next;
    }
        public LinkedList1() {
            // Initialize an empty list
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        // Method to insert a node either at the beginning or at the end
        public void insert(int data, boolean atBeginning) {
            Node newNode = new Node();
            newNode.data = data;

            if (atBeginning) {
                // Insert at the beginning
                newNode.next = first;
                first = newNode;
                if (last == null) {
                    // If the list was empty, update the last reference as well
                    last = newNode;
                }
            } else {
                // Insert at the end
                if (isEmpty()) {
                    // If the list is empty, insert at the beginning (same as at the end)
                    first = newNode;
                    last = newNode;
                } else {
                    Node current = first;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                    last = newNode;
                }
            }
        }

        // Additional method to get the last node
        public Node getLast() {
            return last;
        }


    }
