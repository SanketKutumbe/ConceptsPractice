package Java8.MultiThreading;

import java.util.Scanner;

public class Consumer_Producer<A> {

    private A[] collection;
    private int capacity;
    private int head;
    private int tail;

    Consumer_Producer(Object[] collection, int capacity)
    {
        this.collection = (A[]) collection;
        this.capacity = capacity;
        this.head = 0;
        this.tail = this.capacity - 1;
    }

    public void enque(Object data) throws InterruptedException {
        while( head == 0 )
        {
            Thread.currentThread().wait();
        }
        collection[head] = (A) data;
        head--;
    }

    public void deque() throws InterruptedException
    {
        while( tail == capacity )
        {
            Thread.currentThread().wait();
        }
        tail++;
    }

    public static void main(String[] args)  {

        Consumer_Producer<Integer> cp = new Consumer_Producer(new int[][]{new int[]{1, 2, 3, 4, 5, 6}}, 10);

        Thread t1 = new Thread(() -> {
            try {
                cp.enque(new Scanner(System.in));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                cp.deque();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
