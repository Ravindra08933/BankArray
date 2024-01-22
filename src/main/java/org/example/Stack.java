package org.example;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
public class Stack {
    LinkedList<Integer> list = new LinkedList<>();
    void push(int data)
    {
        list.push(data);
    }
    int pop()
    {
        return list.pop();
    }
    int top()
    {
        return list.peek();
    }
    void display()
    {
        ListIterator iterator = list.listIterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
        System.out.println(stack.top());
    }

}
