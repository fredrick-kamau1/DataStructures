package queues;

import java.util.Arrays;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;

public class ArrayQueue<T> implements QueueADT<T> {

  private T queueArray[]; // Array holding queue
  private static final int DEFAULT_SIZE = 3;
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
    System.out.println("Enque: " + element);
    size++;
  }

  /*
   * The complexity of the growQueue method is O(n) since there is a loop which
   * will iterate n times to copy the queue to the newly created grown queue
   */
  @SuppressWarnings("unchecked")
  private void growQueue() {
    // grow queue when its full
    int growSize = size + DEFAULT_SIZE;
    T[] newQueue = (T[]) new Object[growSize];
    for (int i = 0; i < queueArray.length; i++) {
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

  /*
   * The contains() function has a loop that checks every element of the array
   * in that case the time complexity is big O(n). Method will iterate n times
   * comparing the element to the queue already in place
   */
  public boolean contains(T element) {
    int index = front;
    for (int i = 0; i < size; i++) {
      index = (index + 1) % queueArray.length;
      if (queueArray[index] == element)
        return true;
    }
    return false;
  }

  /*
   * Same as contains since we need to check all the items already in the queue
   * comparing with the given element means that we will have to loop through n
   * times to check. In this case this will also be big O(n).
   */
  public int indexOf(T element) {
    int index = front;
    for (int i = 0; i < size; i++) {
      index = (index + 1) % queueArray.length;
      if (queueArray[index] == element)
        return index;
    }
    return -1;
  }

  /*
   * A for loop will be used to go through the elements and print out the same.
   * This will be iterations based on n elements so time complexity is big O(n).
   */
  public void toArray(T[] anArray) {

    if (size > anArray.length) {
      throw new ArrayCapacityException("Stack");
    } else {
      int index = front;
      for (int i = 0; i < size; i++) {
        index = (index + 1) % queueArray.length;
        anArray[i] = queueArray[index];
      }
    }
    System.out.println(Arrays.toString(anArray));
  }
}
