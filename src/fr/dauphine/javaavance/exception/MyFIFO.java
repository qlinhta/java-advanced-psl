package fr.dauphine.javaavance.exception;
public class MyFIFO {
    private final Object[] queue;
    private int start;
    private int end;
    private int size;

    public MyFIFO(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.queue = new Object[size];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    public void offer(Object o) {
        if (o == null) {
            throw new NullPointerException("Cannot add null to queue");
        }
        if (this.size == this.queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        this.queue[this.end] = o;
        this.end = (this.end + 1) % this.queue.length;
        this.size++;
    }

    public Object poll() {
        if (this.size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Object o = this.queue[this.start];
        this.start = (this.start + 1) % this.queue.length;
        this.size--;
        return o;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = this.start; i < this.start + this.size; i++) {
            sb.append(this.queue[i % this.queue.length]);
            if (i < this.start + this.size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public boolean isEmpty() {
        /*
        Write a method isEmpty that returns true if the queue is empty, false otherwise.
         */
        return this.size == 0;
    }
}
