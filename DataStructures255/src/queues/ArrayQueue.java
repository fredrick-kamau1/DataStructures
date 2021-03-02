package queues;

import exceptions.EmptyCollectionException;

public class ArrayQueue<T> implements QueueADT<T> {

  private T queueArray[]; // Array holding queue
  private static final int DEFAULT_SIZE = 5;
  private int front; // position of element at the front of the queue
  private int rear; // First free position at rear of the queue
  private int size; // number of elements in the queue

  @SuppressWarnings("unchecked")
  public ArrayQueue(int initialSize) {
    front = -1;
    rear = 0;
    queueArray = (T[]) new Object[initialSize];
  }

  public ArrayQueue() {
    this(DEFAULT_SIZE);
  }

  @Override
  public void enqueue(T element) {    
    if (isFull()) {
      growQueue();
    }

    if (isEmpty()) {
      front = (front + 1) % queueArray.length;
    }

    queueArray[rear] = element;
    rear = (rear + 1) % queueArray.length;
    size++;

  }

  @SuppressWarnings("unchecked")
  private void growQueue() {    
    //grow queue when its full 
    int growSize = size + DEFAULT_SIZE;    
    T[] newQueue = (T[]) new Object[growSize];
    for(int i = 0; i < queueArray.length; i++) {
      newQueue[i] = queueArray[(front + i) % queueArray.length];      
    }
    queueArray = newQueue; 
    front = 0;
    rear = size;    
    
  }

  @Override
  public T dequeue() {    
    if (isEmpty()) {
      throw new EmptyCollectionException("array queue");
    }
    T retElement = queueArray[front];
    queueArray[front] = null;
    front = (front + 1) % queueArray.length;
    size--;
    return retElement;
  }

  @Override
  public T first() {
    if (isEmpty()) {
      throw new EmptyCollectionException("array queue");
    }
    return queueArray[front];
  }

  @Override
  public boolean isEmpty() {
    return (size == 0);
  }

  private boolean isFull() {
    return (size == queueArray.length);
  }

  @Override
  public int size() {

    return size;
  }

  public String toString() {
    String retString = "[";
    int index = front;

    for (int c = 0; c < size; c++) {
      retString += queueArray[index];
      index = (index + 1) % queueArray.length;
      retString += " ";
    }
    retString += "]";
    return retString;
  }

}
