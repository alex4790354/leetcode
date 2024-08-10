package com.github.alex4790354.mystack;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingStackWithLock<T> {

    private StackNode<T> top;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Condition notFull = lock.writeLock().newCondition();
    private final Condition notEmpty = lock.writeLock().newCondition();
    private int size = 0;
    private final int capacity;

    public BlockingStackWithLock(int capacity) {
        this.capacity = capacity;
    }

    // Метод push использует writeLock, так как это операция записи
    public void push(T value) throws InterruptedException {
        lock.writeLock().lock();
        try {
            while (size == capacity) {
                notFull.await();  // Ожидание, пока не освободится место
            }
            top = new StackNode<>(value).withNext(top);
            size++;
            notEmpty.signal();  // Сигнализируем, что стек теперь непустой
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Метод pop использует writeLock, так как это операция записи
    public T pop() throws InterruptedException {
        lock.writeLock().lock();
        try {
            while (size == 0) {
                notEmpty.await();  // Ожидание, пока стек не станет непустым
            }
            T result = top.getValue();
            top = top.next();
            size--;
            notFull.signal();  // Сигнализируем, что в стеке теперь есть место
            return result;
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Метод peek использует readLock, так как это операция чтения
    public T peek() {
        lock.readLock().lock();
        try {
            if (size == 0) {
                return null;  // Возвращаем null, если стек пуст
            }
            return top.getValue();
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getSize() {
        lock.readLock().lock();
        try {
            return size;
        } finally {
            lock.readLock().unlock();
        }
    }

}
