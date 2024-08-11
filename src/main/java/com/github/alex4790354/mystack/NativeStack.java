package com.github.alex4790354.mystack;

/**
 0) Создать Stack без использования коллекций.

 1) написать Unit-тесты методы.

 2) сделать что бы методы push() и pop() - exlusive блокировку, а peck - shared блокировка.
 т.е. метод peeck могут делать одновременно несколько потоков, а push и pop - только один.

 3) так что бы наш NativeStack стал ограниченным блокирующим стеком (в конструкторе добавляем размер),
 push в предельном размере должен заблокироваться и ждать пока освободится место.
 peeck может возвращать null (если уже пусто).

 4) не огранченный, потоко-безпасный, не блокирующий стек.


 Тесты: <a href="https://lp.jetbrains.com/research/concurrent-computing-lab/projects/lincheck/">...</a>
 */

// 1) Stack без использования коллекций.

public class NativeStack<T> {
    private StackNode<T> top;

    public void push(T value) {
        top = new StackNode<>(value).withNext(top);
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T result = top.getValue();
        this.top = top.next();
        return result;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getValue();
    }


    /*public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        NativeStack<Integer> naiveIntStack = new NativeStack<>();

        for (Integer i : arr) {
            naiveIntStack.push(i);
        }

        Integer element;
        int index = arr.length - 1;
        while (index >= 0 && (element = naiveIntStack.pop()) != null) {
            if(!element.equals(arr[index])) {
                throw new IllegalStateException("Expected: [" + arr[index] + "] but got: [" + element + "]");
            }
            index = index - 1;
            System.out.println("Popped element: " + element);
        }

        System.out.println("ALL DONE!");
    }*/

}
