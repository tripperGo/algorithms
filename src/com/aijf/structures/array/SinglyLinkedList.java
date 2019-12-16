package com.aijf.structures.array;

/**
 * @author : zhaochuanzhen
 * @description : 单链表
 * @date : 2019/12/16 10:15
 */
public class SinglyLinkedList {

    private Node head = null;

    public void insertToHead(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public void insertToTail(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    public void insertAfter(Node node, int value) {
        if (head == null) {
            return;
        }

        Node target = new Node(value);
        Node temp = head;
        while (temp != null && temp.getValue() != node.getValue()) {
            temp = temp.getNext();
        }

        if (temp != null) {
            target.setNext(temp.getNext());
            temp.setNext(target);
        }
    }

    public void insertBefore(Node node, int value) {
        if (head == null) {
            return;
        }

        Node target = new Node(value);
        if (head.getValue() == node.getValue()) {
            insertToHead(value);
            return;
        }

        Node temp = head;
        while (temp.getNext() != null && temp.getNext().getValue() != node.getValue()) {
            temp = temp.getNext();
        }

        if (temp.getNext() != null) {
            target.setNext(temp.getNext());
            temp.setNext(target);
        }
    }

    public void printAll() {
        Node node = head;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertToHead(1);
        singlyLinkedList.insertToHead(2);
        singlyLinkedList.insertToHead(3);
        singlyLinkedList.insertToHead(4);
//        singlyLinkedList.insertToTail(5);
//        singlyLinkedList.insertToTail(6);
//        singlyLinkedList.insertAfter(new Node(1), 2);
//        singlyLinkedList.insertAfter(new Node(6), 7);
//        singlyLinkedList.insertAfter(new Node(16), 7);
        singlyLinkedList.insertBefore(new Node(5), 6);
        singlyLinkedList.printAll();
    }
}

class Node {
    private Node next;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}