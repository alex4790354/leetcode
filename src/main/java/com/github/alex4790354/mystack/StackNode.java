package com.github.alex4790354.mystack;

import lombok.Getter;

@Getter
class StackNode<T> {

    private final T value;
    private StackNode<T> next;

    StackNode(T value) {
        this.value = value;
    }

    public StackNode<T> next() {
        return next;
    }

    public StackNode<T> withNext(StackNode<T> next) {
        this.next = next;
        return this;
    }

}
