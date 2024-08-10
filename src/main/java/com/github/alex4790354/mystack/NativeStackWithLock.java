package com.github.alex4790354.mystack;

import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
2) сделать что бы методы push() и pop() - exlusive блокировку, а peck - shared блокировка.
    т.е. метод peeck могут делать одновременно несколько потоков, а push и pop - только один.
*/

public class NativeStackWithLock<T> {

    private StackNode<T> top;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Метод push использует эксклюзивную блокировку (write lock)
    public void push(T value) {
        lock.writeLock().lock();
        try {
            top = new StackNode<>(value).withNext(top);
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Метод pop использует эксклюзивную блокировку (write lock)
    public T pop() {
        lock.writeLock().lock();
        try {
            if (top == null) {
                return null;
            }
            T result = top.getValue();
            this.top = top.next();
            return result;
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Метод peek использует разделяемую блокировку (read lock)
    public T peek() {
        lock.readLock().lock();
        try {
            if (top == null) {
                return null;
            }
            return top.getValue();
        } finally {
            lock.readLock().unlock();
        }
    }

}
