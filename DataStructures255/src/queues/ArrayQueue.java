package queues;

public class ArrayQueue<T> implements QueueADT<T> {

  private T queueArray[]; // Array holding stack
  private static final int DEFAULT_SIZE = 5;
  private int front; // Maximum size of stack
  private int rear; // First free position at top
  private int maxSize; // Maximum size of queue
  
  
  @SuppressWarnings("unchecked")
  public ArrayQueue(int size) {
    maxSize = size+1;
    front = -1;
    rear = 0; 
    queueArray = (T[]) new Object[size];
  }
  
  public ArrayQueue() {
    this(DEFAULT_SIZE); 
  }
  
  @Override
  public void enqueue(T element) {
    // TODO Auto-generated method stub
    if (((rear+2) % maxSize) == front) isFull();  // Full
    rear = (rear+1) % maxSize; // Circular increment
    queueArray[rear] = it;
  }

  @Override
  public T dequeue() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T first() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }
  
  public boolean isFull() {
    return false;
  }

  @Override
  public int length() {
    // TODO Auto-generated method stub
    return 0;
  }

}
