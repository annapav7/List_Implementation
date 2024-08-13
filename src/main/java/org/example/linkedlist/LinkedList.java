package org.example.linkedlist;

public class LinkedList<T> {
    public String data;
    public Node next;
    private Node head;
    private Node last;
    private Node first;

    private class Node<T> {
        T data;
        LinkedList.Node next;
    }


//    public LinkedList() {
//        head = null;
//        last = null;
//    }

Node newNode = new Node();

    private Object[] list;
    private int size;

    private final int DEFAULT_SIZE = 25;

    // create list
    public LinkedList() {
        list = new Object[DEFAULT_SIZE];
    }

    public int size() {
        return size;
    }




    public void addNode(T data, int index){
        Node newNode = new Node();
        newNode.data = data;

        Object[] _list;

        if (index < 0) {
            throw new IllegalArgumentException("Position cannot be negative.");
        }

        if(index== 0) {
            // Insert at the beginning
            newNode.next = head;
            head = newNode;

        } else {

            int inx = 0;
            LinkedList.Node current = head;

            // Traverse to the node before the desired position
            while (current != null && inx < index - 1) {
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
//            Object[] _list;
//
//            int inx = 0;
//            Node current = head;
//
//            if (size == list.length) {
//                _list = new Object[list.length + DEFAULT_SIZE];
//
//                // Insert new node at the desired position
//                while (current != null && inx < index - 1) {
//                    current = current.next;
//                    index++;
//                }
//
//                if (current == null) {
//                    throw new IndexOutOfBoundsException("Position out of bounds.");
//                }
//
//                newNode.next = current.next;
//                current.next = newNode;
//
//                // If inserting at the end, update the last reference
//                if (newNode.next == null) {
//                    last = newNode;
//                }
//
//                } else {
//                _list = list;
//
//                // Insert new node at the desired position
//                while (current != null && inx < index - 1) {
//                    current = current.next;
//                    index++;
//                }
//
////                    if (current == null) {
////                        throw new IndexOutOfBoundsException("Position out of bounds.");
////                    }
//
//
//
//                newNode.next = current.next;
//                current.next = newNode;
//
//                // If inserting at the end, update the last reference
//                if (newNode.next == null) {
//                    last = newNode;
//                }
//            }
//            System.arraycopy(list, 0, _list, 1, size);
//            _list[0] = data;
//            size++;
//            list = _list;
//
//
//
////            // If inserting at the end, update the last reference
////            if (newNode.next == null) {
////                last = newNode;
////            }
        }
    }

//    public T getItemList(int index){
//
//        return (T) list[index];
//    }

//    / Method to print the list
//    public void printList() {
//        Node current = first;
//        while (current != null) {
//            System.out.print(current.data + " ");
//            current = current.next;
//        }
//        System.out.println(); // To move to the next line after printing the list



//    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.addNode(1, 0); // Insert 1 at position 0
//        list.addNode(2, 1); // Insert 2 at position 1
//        list.addNode(3, 1); // Insert 3 at position 1
//        list.addNode(4, 3); // Insert 4 at position 3
////        list.printList(); // Output should be: 1 -> 3 -> 2 -> 4 -> null
//
//        System.out.println(list);
//    }


