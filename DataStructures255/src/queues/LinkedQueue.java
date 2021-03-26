package queues;

import java.util.Arrays;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;
import support.LNode;

public class LinkedQueue<T> implements QueueADT<T> {

  private LNode<T> front;
  private LNode<T> rear;
  private int size;

  public LinkedQueue() {
    front = null;
    rear = null;
    size = 0;
  }

  @Override
  public void enqueue(T element) {
    // TODO Auto-generated method stub

    LNode<T> newNode = new LNode<T>(element);
    if (isEmpty()) {
      rear = newNode;
      front = newNode;
    } else {
      rear.setNext(newNode);
      rear = newNode;
    }
    System.out.println("Enque: " + element);
    size++;
  }

  @Override
  public T dequeue() {
    // TODO Auto-generated method stub
    T retData;
    if (isEmpty()) {
      throw new EmptyCollectionException("linked queue");
    } else {

      retData = front.getData();
      front = front.getNext();
      size--;
      return retData;
    }
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
    return (size == 0);
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  public String toString() {
    String retString = "[";
    LNode<T> it = front;
    while (it != null) {
      retString += it.getData();
      retString += " ";
      it = it.getNext();
    }
    retString += "]";
    return retString;
  }

  /*
   * A while loop will be used to go through the elements in toArray and print
   * out the same. This will be iterations based on n elements so time
   * complexity is big O(n)
   */

  public void toArray(T[] anArray) {
    LNode<T> newNode = front;
    if (size > anArray.length) {
      throw new ArrayCapacityException("queue");
    }else if(size == 0) {
      throw new NullPointerException();      
    }else {
      for (int i = 0; i < size; i++) {
        anArray[i] = newNode.getData();
        newNode = newNode.getNext();
      }
    }
    System.out.println(Arrays.toString(anArray));
  }

  /*
   * The contains() function has a while loop that checks every node to compare
   * data in that case the time complexity is big O(n). Method will iterate as
   * long as newNode is not null.
   * 
   */
  public boolean contains(T element) {
    LNode<T> newNode = front;
    while (newNode != null) {
      if (newNode.getData() == element)
        return true;
      newNode = newNode.getNext();
    }
    return false;
  }

  /*
   * Same as contains since we need to check all the items already in the
   * linkedQueue comparing with the given element means that we will have to
   * loop through n times to check. In this case this will also be big O(n).
   */
  public int indexOf(T element) {
    int count = 0;
    LNode<T> newNode = front;
    while (newNode != null) {
      if (newNode.getData().equals(element))
        break;
      newNode = newNode.getNext();
      count++;
    }
    return count;
  }
}
