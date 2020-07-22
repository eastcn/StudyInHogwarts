package JavaDemo;

import java.util.Stack;

/**
 * @Classname StackDemo
 * @Description 栈数据结构demo
 * @Date 2020/7/9 6:00 下午
 * @Created by East
 */
public class StackDemo {
    public static void push(Stack<Integer> intStack, int num) {
        intStack.push(num);
        System.out.println("add:" + intStack.add(1));
        intStack.push(2);
        intStack.addElement(3);
        System.out.println("stack:" + intStack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        push(stack, 0);
    }
}
