package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> {
  private static final int INIT_CAPACITY = 5;

  private Item[] queueArray;       // queue elements
  private int size;          // number of elements on queue
  private int front;      // index of first element of queue
  private int rear;       // index of next available slot


  /**
   * Initializes an empty queue.
   */
  @SuppressWarnings("unchecked")
  public ResizingArrayQueue() {
      queueArray = (Item[]) new Object[INIT_CAPACITY];
      size = 0;
      front = 0;
      rear = 0;
  }

  /**
   * Is this queue empty?
   * @return true if this queue is empty; false otherwise
   */
  public boolean isEmpty() {
      return size == 0;
  }

  /**
   * Returns the number of items in this queue.
   * @return the number of items in this queue
   */
  public int size() {
      return size;
  }

  // resize the underlying array
  private void resize(int capacity) {
      assert capacity >= size;
      @SuppressWarnings("unchecked")
      Item[] copy = (Item[]) new Object[capacity];
      for (int i = 0; i < size; i++) {
          copy[i] = queueArray[(front + i) % queueArray.length];
      }
      queueArray = copy;
      front = 0;
      rear  = size;
  }

  /**
   * Adds the item to this queue.
   * @param item the item to add
   */
  public void enqueue(Item item) {
      // double size of array if necessary and recopy to front of array
      if (size == queueArray.length) 
        resize(2*queueArray.length);   // double size of array if necessary
      queueArray[rear++] = item;                        // add item
      if (rear == queueArray.length) rear = 0;          // wrap-around
      size++;
  }

  /**
   * Removes and returns the item on this queue that was least recently added.
   * @return the item on this queue that was least recently added
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  public Item dequeue() {
      if (isEmpty()) throw new NoSuchElementException("Queue underflow");
      Item item = queueArray[front];
      queueArray[front] = null;                            // to avoid loitering
      size--;
      front++;
      if (front == queueArray.length) front = 0;           // wrap-around
      // shrink size of array if necessary
      if (size > 0 && size == queueArray.length/4) resize(queueArray.length/2); 
      return item;
  }

  /**
   * Returns the item least recently added to this queue.
   * @return the item least recently added to this queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  public Item peek() {
      if (isEmpty()) throw new NoSuchElementException("Queue underflow");
      return queueArray[front];
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

  /**
   * Returns an iterator that iterates over the items in this queue in FIFO order.
   * @return an iterator that iterates over the items in this queue in FIFO order
   */
  public Iterator<Item> iterator() {
      return new ArrayIterator();
  }

  // an iterator, doesn't implement remove() since it's optional
  private class ArrayIterator implements Iterator<Item> {
      private int i = 0;
      public boolean hasNext()  { return i < size;                               }
      public void remove()      { throw new UnsupportedOperationException();  }

      public Item next() {
          if (!hasNext()) throw new NoSuchElementException();
          Item item = queueArray[(i + front) % queueArray.length];
          i++;
          return item;
      }
  }

}
