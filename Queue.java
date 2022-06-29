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

        elements[rear++] = e;
    }

    /**
     * remove and return the object at the front of the queue
     * */
    public void dequeue() {

    }

    /**
     * return the integer at the front of the queue without removing it 
     * */
    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    /**
     * return the size of the queue
     * */
    public int size() {
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
     * 
     * */
    public String toString() {
        return "IT WORKS!";
    }

    /**
     * Create a new array of twice the original size of elements
     */
    private void copy() {
        int[] temp = new int[capacity * 2];

        for (int i = 0; i < capacity; i++) {
            temp[i] = elements[i];
        }

        elements = temp;
        capacity *= 2;
    }

    /**
     * Shift all elements in the queue to the left by one 
     * recall, 'rear' acts as '.length' so its value is not zero
     * indexed
     */
    private void shiftQueue() {
        for (int i = 0; i < rear - 1; i++) {
            elements[i] = elements[i + 1];
        }
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        System.out.println("Is queue empty: " + q1.isEmpty());
        System.out.println("Size of queue: " + q1.size());
        System.out.println("Front of the queue: " + q1.front());
        q1.enqueue(1);
        System.out.println("Is queue empty: " + q1.isEmpty());
        System.out.println("Size of queue: " + q1.size());
        q1.enqueue(2);
        System.out.println("Is queue empty: " + q1.isEmpty());
        System.out.println("Size of queue: " + q1.size());
        System.out.println("Front of the queue: " + q1.front());
    }
}

