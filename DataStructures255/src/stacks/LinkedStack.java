package stacks;

import java.util.Arrays;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;
import support.LNode;

public class LinkedStack<T> implements StackADT<T> {

  private int length; // keeps track of how many elements exist in the stack
  private LNode<T> topNode;

  public LinkedStack() {
    length = 1;
    topNode = null;
  }

  @Override
  public void push(T element) {    
    LNode<T> newNode = new LNode<T>(element);
    newNode.setNext(topNode);
    topNode = newNode;
    length++;
  }

  @Override
  public T pop() {
    if (isEmpty())
      throw new EmptyCollectionException("Stack");

    T retData = topNode.getData();
    topNode = topNode.getNext();
    length--;
    return retData;
  }

  @Override
  public T peek() {
    if (isEmpty())
      throw new EmptyCollectionException("Stack");
    return topNode.getData();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return (topNode == null);
  }

  @Override
  public int length() {
    // Big difference in time complexity if we use a loop for length instead of
    // length++
    int count = 1;
    LNode<T> top = topNode;
    while (top != null) {
      top = top.getNext();
      count++;
    }
    return count;
  }

  public boolean contains(T element) {
    LNode<T> newNode = topNode;
    while (newNode != null) {
      if (newNode.getData() == element)
        return true;
      newNode = newNode.getNext();
    }
    return false;
  }

  // FIXME
  public int search(T element) {
    int count = 0;
    LNode<T> newNode = topNode;
    while (newNode != null) {
      if (newNode.getData().equals(element))
        break;
      newNode = newNode.getNext();
      count++;
    }
    return count;
  }

  public void toArray(T[] anArray) {
    LNode<T> newNode = topNode;
    if (length > anArray.length) {
      throw new ArrayCapacityException("Stack");
    } else {
      for (int i = 0; i < anArray.length; i++) {
        anArray[i] = newNode.getData();
        newNode = newNode.getNext();
      }
    }
    System.out.println(Arrays.toString(anArray));
  }
 
}// end Class
