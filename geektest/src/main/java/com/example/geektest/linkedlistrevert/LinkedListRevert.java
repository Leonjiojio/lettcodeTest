package com.example.geektest.linkedlistrevert;

/**
 * Created by  on 2021/4/20.
 **/
class LinkedListRevert {
    public static void main(String[] args) {

        Node head=getTestData();
//        Node result=reverseListByLocal(head);
//        printNode(result);

        boolean result=isLoop(head);
        System.out.println("is loop="+result);

    }

    public static Node reverseListByInsert(Node head){

        Node resultList = new Node(-1);
        //循环节点 insert head
        Node p = head;
        while(p!= null){
            //保存插入点之后的数据
            Node tempList = p.next;
            p.next = resultList.next;
            resultList.next = p;
            p = tempList;
        }
        return resultList.next;
    }

    //就地反转:
    public static Node reverseListByLocal(Node head){
        Node resultList = new Node(-1);
        resultList.next= head;
        Node p = head;
        Node pNext = p.next;
        while (pNext!=null){
            p.next = pNext.next;
            pNext.next = resultList.next;
            resultList.next = pNext;
            pNext=p.next;
        }
        return resultList.next;
    }


    private static  Boolean isLoop(Node head){
        if (head==null)return false;

        Node slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)return true;
        }
        return false;
    }

    private static  Node revert(Node head){
        Node pre=null;
        Node cur=head;
        Node next;
        while (cur!=null){
            next=cur.next;
            cur.next=pre;

            pre=cur;
            cur=next;
        }
        return  pre;
    }
    private  static void printNode(Node head){
        if (head!=null){
            while (head.next!=null){
                System.out.println("value="+head.value);
                head=head.next;
            }
        }
    }

    private static Node getLoopTestData(){
        Node head=new Node(0);
        Node pre=head;
        Node temp=null;
        for (int i = 1; i < 10; i++) {
            temp=new Node(i);
            pre.next=temp;
            pre=temp;
        }
        temp.next=head;

        return  head;
    }
    private static Node getTestData(){
        Node head=new Node(0);
        Node pre=head;
        for (int i = 1; i < 10; i++) {
            Node node=new Node(i);
            pre.next=node;
            pre=node;
        }
        return  head;
    }
}