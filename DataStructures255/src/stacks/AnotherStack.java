package stacks;

import exceptions.EmptyCollectionException;

public class AnotherStack<T> implements StackADT<T> {
  
  private static final int DEF_SIZE = 5; 
  private int top;
  private T[] stackArray;
  
  
  @SuppressWarnings("unchecked")
  public AnotherStack(int size) {
    top = 0;
    stackArray = (T[]) new Object[size];    
  }
  
  public AnotherStack() {
    this(DEF_SIZE);
  }

  
  @Override
  public void push(T element) {
    // TODO Auto-generated method stub
    if (top >= stackArray.length)
      throw new RuntimeException("stack is full");  // this is here just for testing purposes, we would call growStack() method instead
    stackArray[top] = element;
    top++;
    
  }

  @Override
  public T pop() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T peek() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      throw new EmptyCollectionException("ArrayStack");
    }
    return stackArray[top - 1];
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return (top == 0);
  }

  @Override
  public int length() {
    // TODO Auto-generated method stub
    return 0;
  }

}

