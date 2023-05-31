package com.example.demo.rule;

public class ListNode<T> {

    protected T data;
    protected ListNode next;
    public ListNode(T data) {
        next = null;
        this.data = data;
    }

    public ListNode(T data, ListNode n) {
        this.data = data;
        next = n;
    }

    public void setLinkNext(ListNode n) {
        next = n;
    }


    public ListNode getLinkNext() {
        return next;
    }


    public void setData(T data) {
        data = data;
    }

    public T getData() {
        return data;
    }
}
