package com.github.alex4790354.mystack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NativeStackTest {

    private NativeStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new NativeStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    @DisplayName("Проверяем что pop выдает корректное число (3)")
    void testPush() {
        assertEquals(3, stack.pop());
    }

    @Test
    @DisplayName("Проверяем что pop() на пустом Stack")
    void testPopOnEmptyStack() {
        stack.pop();
        stack.pop();
        stack.pop();
        assertNull(stack.pop(), "Pop operation on an empty stack should return null.");
    }


    @Test
    @DisplayName("Проверяем peek() на пустом Stack")
    void testPeekOnEmptyStack() {
        stack.pop();
        stack.pop();
        stack.pop();
        assertNull(stack.peek(), "Peek operation on an empty stack should return null.");
    }


    @Test
    @DisplayName("Проверяем peek()")
    void testPeek() {
        assertEquals(3, stack.peek(), "Peek should return the last pushed value.");
        assertEquals(3, stack.peek(), "Peek should not remove the value.");
    }

    @Test
    @DisplayName("Проверяем совместно push, peek & pop")
    void testPushPopPeekConsistency() {
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.peek(), "Peek should return the last pushed value.");
        assertEquals(20, stack.pop(), "Pop should return the last pushed value.");
        assertEquals(10, stack.peek(), "After pop, peek should return the next last pushed value.");
    }

    @Test
    @DisplayName("Проверяем совместно push, peek & pop")
    void testMultiplePushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());

        stack.push(5);
        stack.push(6);

        assertEquals(6, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    @DisplayName("Проверяем вставку null")
    void testPushNull() {
        stack.push(null);
        assertNull(stack.peek(), "Pop should return null if null was pushed.");
        assertNull(stack.pop(), "Pop should return null if null was pushed.");
    }

}