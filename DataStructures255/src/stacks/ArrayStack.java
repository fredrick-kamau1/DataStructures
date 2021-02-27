package stacks;

import java.util.Arrays;

import exceptions.ArrayCapacityException;
import support.LNode;

public class ArrayStack<E> implements StackADT<E> {

  private E stackArray[]; // Array holding stack
  private static final int DEFAULT_SIZE = 3;
  private int maxSize; // Maximum size of stack
  private int top; // First free position at top
  private int size; // Tally the ArrayStack unbounded

  // Constructors
  @SuppressWarnings("unchecked") // Generic array allocation
  public ArrayStack(int size) {
    maxSize = size;
    top = 0;
    stackArray = (E[]) new Object[size]; // Create stackArray
  }

  public ArrayStack() {
    this(DEFAULT_SIZE);
  }

  // Modify this method
  // so that it all elements are null
  public void clear() {
    for (int i = 0; i < stackArray.length; i++) {
      stackArray[i] = null;
      /*
       * Time complexity before the change was constant time O(1) since top was
       * being assigned to 0/null. With this change however, time complexity
       * changes to O(n) since the loop has to iterate n number of times to
       * assign null to all elements
       */
    }
  } // Reinitialize stack

  // Push "element" onto stack
  // Changed return type of method to void
  public void push(E element) {
    /*
     * This method initially had a complexity of O(1) since it was assigning
     * elements everytime push is called. After the growStack() method is called
     * it will be O(n) since we will be doubling the size of the array n number
     * of times
     */

    // calling is full method to see if stack is full
    if (isFull())
      // if stack is full, increase capacity.
      growStack();
    // no changes after this
    stackArray[top++] = element;
  }

  // Remove and return top element
  public E pop() {
    if (top == 0)
      return null;
    return stackArray[--top];
  }

  public E peek() { // Return top element
    if (top == 0)
      return null;
    return stackArray[top - 1];
  }

  public int length() {
    return top;
  } // Return stack size

  public boolean isEmpty() {
    return top == 0;
  } // Tell if the stack is empty

  // check if the stack is full.
  public boolean isFull() {
    return (top >= maxSize) ? true : false;

    /*
     * Complexity of this method is O(1) since in the worst case scenario there
     * will only be one assignment either true or false and in that case it will
     * be constant O(1)
     */
  }

  // add new method growStack()
  // growStack() that returns void
  // 1. create a new local array, call it newStack (see the constructor for an
  // example)
  // 2. set the size of the new array to stackArray.length + DEFAULT_SIZE
  // 3. copy all the elements from stackArray to newStack (for loop is perfect)
  // 4. set stackArray to reference the newStack

  @SuppressWarnings("unchecked")
  public void growStack() {
    size = stackArray.length + DEFAULT_SIZE;
    E[] newStack = (E[]) new Object[size];
    for (int i = 0; i < stackArray.length; i++) {
      newStack[i] = stackArray[i];
    }
    stackArray = newStack;

    /*
     * The complexity of the growthStack method is O(n) since there is a loop
     * which will iterate n times to copy the full stack to the newly created
     * stack
     */
  }

  // Method arraySize to check the size of the array at any given time
  protected void arraySize() {
    System.out.println(size);
  }

  public boolean contains(E element) {
    for (int i = 0; i < stackArray.length; i++) {
      if (stackArray[i] == element)
        return true;
    }
    return false;
  }

  public int search(E element) {
    int count = 1;
    for (int i = 0; i < stackArray.length; i++) {
      if (stackArray[i] == element) 
        break;
       count++;
    }
    return count;
  }

  public void toArray(E[] anArray) {

    if (maxSize > anArray.length) {
      throw new ArrayCapacityException("Stack");
    } else {
      for (int i = 0; i < anArray.length; i++) {
        anArray[i] = stackArray[i];

      }
    }
    System.out.println(Arrays.toString(anArray));
  }
}// end class
