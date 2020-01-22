package com.ch.leetcodetest.start0001;

import java.util.Stack;

/**
 * @User: chang
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0232 {

    Stack<Integer> stack;
    Integer head;

    /** Initialize your data structure here. */
    public Test0232() {
        stack=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
        if (stack.size()==1){
            head=x;
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack.size()==0){
            throw new RuntimeException("为空");
        }
        Stack<Integer> tmp = new Stack<>();
        while (stack.size()>0){
            tmp.add(stack.pop());
        }
        int result = tmp.pop();
        if (tmp.size()>0){
            head=tmp.peek();
        }else {
            head=null;
        }
        while (tmp.size()>0){
            stack.push(tmp.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        if (head!=null){
            return head;
        }else {
            throw new RuntimeException("为空");
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

}
