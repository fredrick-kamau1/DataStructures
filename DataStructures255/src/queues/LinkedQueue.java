package queues;

import exceptions.EmptyCollectionException;
import support.LNode;

public class LinkedQueue<T> implements QueueADT<T> {

  // figure out front and rear
  private LNode<T> front;
  private LNode<T> rear;
  private int length;

  public LinkedQueue() {
    front = null;
    rear = null;
    length = 0;
  }

  @Override
  public void enqueue(T element) {
    LNode<T> newNode = new LNode<T>(element);
    if (isEmpty()) {
      rear = newNode;
      front = newNode;
    } else {
      rear.setNext(newNode);
      rear = newNode;
    }
    length++;
  }

  @Override
  public T dequeue() {
    // TODO Auto-generated method stub

    return null;
  }

  @Override
  public T first() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      throw new EmptyCollectionException("linked queue");
    } else {
      return front.getData();
    }
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return (length == 0);
  }

  @Override
  public int length() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  
}
