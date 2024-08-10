package com.github.alex4790354.mystack;

import java.util.concurrent.atomic.AtomicReference;

public class LockFreeStack<T> {
    private final AtomicReference<Node<T>> top = new AtomicReference<>();

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> currentTop;
        do {
            currentTop = top.get();
            newNode.next = currentTop;
        } while (!top.compareAndSet(currentTop, newNode));  // Попытка обновления top
    }

    public T pop() {
        Node<T> currentTop;
        Node<T> newTop;
        do {
            currentTop = top.get();
            if (currentTop == null) {
                return null;  // Стек пуст
            }
            newTop = currentTop.next;
        } while (!top.compareAndSet(currentTop, newTop));  // Попытка обновления top
        return currentTop.value;
    }

    public T peek() {
        Node<T> currentTop = top.get();
        return (currentTop != null) ? currentTop.value : null;
    }

    private static class Node<T> {
        final T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    /*public static void main(String[] args) throws InterruptedException {
        LockFreeStack<Integer> stack = new LockFreeStack<>();

        Runnable producer = () -> {
            for (int i = 1; i <= 5; i++) {
                stack.push(i);
                System.out.println("Pushed: " + i);
            }
        };

        Runnable consumer = () -> {
            for (int i = 1; i <= 5; i++) {
                Integer value = stack.pop();
                System.out.println("Popped: " + value);
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("All operations done!");
    }*/
}
