package org.example;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class Llist
{
    Node root = null;

    void insert(int data)
    {
        Node node = new Node(data);
        if(root==null)
        {
            root = node;
        }
        else
        {
            Node temp = root;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    void delete(int data)
    {
        Node ptr = root;
        Node temp = null;
        while(ptr.data != data)
        {
            temp = ptr;
            ptr = ptr.next;
        }
        temp.next = ptr.next;
    }
    void display()
    {
        Node ptr = root;
        while(ptr!=null)
        {
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Llist list = new Llist();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display();
        list.delete(3);
        list.display();
    }
}