public class Queue {
    private int[] elements;
    private int front;  // always points to elements[0]
    private int rear;   // points to last inserted element
    private int capacity;

    private static final int DEFAULT_CAPACITY = 16;

    /** 
     * Constructors 
     * */
    public Queue(int capacity) {
        this.capacity = capacity;
        elements = new int[this.capacity];
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * place integer e on the rear of the queue 
     * */
    public void enqueue(int e) {
        // If queue is half full create a new queue with double the space
        if (rear >= capacity / 2) {
            copy();
            System.out.println("Queue was extended...");
        }
        elements[rear++] = e;
    }
    
    /**
     * remove and return the object at the front of the queue
     * */
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }

        int dequeuedElement = elements[0];
        shiftQueue();

        return dequeuedElement;
    }

    /**
     * return the integer at the front of the queue without removing it 
     * */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    /**
     * return the size of the queue
     * */
    public int getSize() {
        return rear;
    }

    /**
     * return true if the queue contains no elements, false otherwise
     * */
    public boolean isEmpty() {
        if (front == 0 && rear == 0) {
            return true;
        }
        return false;
    }

    /**
     * return the capacity of the queue
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Probably not the most efficient way to do things, but I wanted to
     * test out StringBuilder
     * */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[" + elements[front]);
        for (int i = 1; i < rear; i++) {
            sb.append(", " + elements[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Create a new array of twice the original size of elements
     */
    private void copy() {
        int[] temp = new int[capacity * 2];

        for (int i = 0; i < rear; i++) {
            temp[i] = elements[i];
        }

        elements = temp;  // overwrite previous array with new dynamically allocated memory
        capacity *= 2;    // update our capacity to prevent a potential stale variable
    }

    /**
     * Shift all elements in the queue to the left by one 
     * recall, 'rear' acts as a '.length' of sorts
     */
    private void shiftQueue() {
        for (int i = 0; i < rear - 1; i++) {
            elements[i] = elements[i + 1];
        }
        --rear; // rear is shifted to the left by one
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        System.out.println(q1.toString());
        System.out.println("Current front element: " + q1.getFront());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println(q1.toString());
        System.out.println("Current front element: " + q1.getFront());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println(q1.toString());
        System.out.println("Dequeued element: " + q1.dequeue());
        System.out.println(q1.toString());
        q1.enqueue(1);
        q1.enqueue(2);
        System.out.println(q1.toString());
        System.out.println("Current front element: " + q1.getFront());
    }
}

