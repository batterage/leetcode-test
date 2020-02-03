package com.ch.leetcodetest.start0001;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @User: chang
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Test0206 {
    //本地反转,迭代
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = cur.next;
        while (cur!=null&&cur.next!=null){
            cur.next=pre;
            pre = cur;
            cur=next;
            next = next.next;
        }
        //最后一个
        cur.next = pre;
        return cur;
    }

    //递归
    public ListNode reverseList1(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        System.out.println("============本地翻转================");
        //ListNode listNode = reverseList(l1);
        //System.out.println(JSON.toJSONString(listNode));

        System.out.println("============递归================");
        ListNode listNode = reverseList1(l1);
        System.out.println(JSON.toJSONString(listNode));
    }
}
