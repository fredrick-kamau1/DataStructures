package lists;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;

public abstract class AArrayList<T> implements ListADT<T> {
  protected static final int FRONT = 0; // The front position (always 0)
  protected static final int DEFAULT_SIZE = 10; // Default size
  protected T listArray[]; // Array holding list elements
  protected int listSize; // Current # of list items, indicates next open
                          // location in array
  protected int modifiedCount; // Count how many times list has been modified
                               // (add or remove)

  // Constructors
  // Create a new list object with maximum size "size"
  @SuppressWarnings("unchecked") // Generic array allocation
  AArrayList(int size) {
    // maxSize = size;
    listSize = modifiedCount = 0;
    listArray = (T[]) new Object[size]; // Create listArray
  }

  // Create a list with the default capacity
  AArrayList() {
    this(DEFAULT_SIZE); // Just call the other constructor
  }

  // Reset the list -- note that we could also iterate the array and null all
  // values
  public void clear() { // Reinitialize the list
    listSize = modifiedCount = 0; // Simply reinitialize values
  }

  @Override
  // the add method will be different for each subclass
  public abstract boolean add(T element);

  // Increase the size of the array when it becomes full
  protected void growList() {
    // create a larger array newList
    // copy all elements of list into newList array
    // update the list reference to point to newList

    @SuppressWarnings("unchecked")
    T[] newList = (T[]) (new Object[size() + DEFAULT_SIZE]);

    for (int i = 0; i < size(); i++) {
      newList[i] = listArray[i];
    }

    listArray = newList;

  }

  @Override
  public T remove(T element) throws NoSuchElementException {
    // Remove element from the list
    // This method may also throw the EmptyCollectionException - depending on
    // how you code it
    T retElement = null;
    int index = 0;
    if (isEmpty()) {
      throw new EmptyCollectionException("List");
    }
    
    //identify index
    for (int i = 0; i < listSize; ++i) {
      if (listArray[i].equals(element)) {
        index = i;
      }
    }
    
    //shift elements 
    for (int i = index; i < listSize-1; ++i) {
      listArray[i] = listArray[i + 1];
      
    }

    listArray[listSize] = null;
    listSize--;
    modifiedCount++;

    return retElement;

  }

  @Override
  public T removeFirst() {
    // Remove first element from the list
    T retElement;
    if (isEmpty())
      throw new EmptyCollectionException("list");

    retElement = listArray[FRONT];

    // shift elements
    for (int i = 0; i < listSize - 1; ++i) {
      listArray[i] = listArray[i + 1];
    }

    listArray[listSize] = null; // null where the last element used to be
    listSize--;
    modifiedCount++;

    return retElement;
  }

  @Override
  public T removeLast(T element) throws NoSuchElementException {
    // Remove the last element from the list
    // This method may also throw the EmptyCollectionException - depending on
    // how you code it

    T retElement;
    if (isEmpty())
      throw new EmptyCollectionException("list");
    
    if(!listArray[listSize-1].equals(element))
      throw new NoSuchElementException(); 

    retElement = listArray[listSize-1];    
    listSize--; 
    modifiedCount++;
    return retElement;    
  }

  @Override
  public int size() {
    return listSize; // Return list size
  }

  // Tell if the list is empty or not
  public boolean isEmpty() {
    return listSize == 0;
  }

  protected boolean isFull() {
    return (listSize == listArray.length);
  }

  @Override
  public T first() {
    if (isEmpty())
      throw new EmptyCollectionException("list");
    return listArray[FRONT];
  }

  @Override
  public T last() {
    if (isEmpty())
      throw new EmptyCollectionException("list");
    return listArray[listSize - 1];
  }

  @Override
  public boolean contains(T element) {
    if (isEmpty()) {
      throw new EmptyCollectionException("List");
    }
    for (int i = 0; i < listSize; ++i) {
      if (listArray[i].equals(element)) {
        return true; 
      }
    }
    return false;
  }

  @Override
  public int indexOf(T element) {    
    for(int i = 0; i < listSize; ++i) {
      if(listArray[i].equals(element)) {
        return i; 
      }
    }
    return -1;
  }

  @Override
  public void toArray(T[] anArray) {
    if(listSize > anArray.length) {
      throw new ArrayCapacityException("list");
    } else {
      //int index = FRONT; 
      for(int i = 0; i < listSize; ++i) {
        anArray[i] = listArray[i]; 
      }
      System.out.print(Arrays.toString(anArray));
    }

  }

  @Override
  public String toString() {
    String retString = "[";

    for (int i = 0; i < listSize; i++) {
      retString += listArray[i];
      retString += " ";
    }
    retString += "]";
    return retString;
  }

  // You may use this method to shift elements and open an index location to add
  protected void shiftElements(int insertingIndex) {
    // shift elements so that the index location at
    // starting index is open for the new element

    for (int i = size(); i > insertingIndex; i--) {
      listArray[i] = listArray[i - 1];
    }
    listArray[insertingIndex] = null;
  }

  @Override
  public Iterator<T> iterator() {
    // Return an iterator for this list
    return new ArrayListIterator();
  }

  // private iterator class

  private class ArrayListIterator implements Iterator<T> {

    int currentPos;
    int currentModCount;

    public ArrayListIterator() {
      currentPos = 0;
      currentModCount = modifiedCount;

    }

    @Override
    public boolean hasNext() {
      // Indicate if there are elements left to iterate
      if (currentModCount != modifiedCount) {
        throw new ConcurrentModificationException();
      }
      return (currentPos < listSize);
    }

    @Override
    public T next() {
      // Return the next element in the list
      // First time calling next returns the first element in the list

      if (hasNext()) {
        currentPos++;
        return listArray[currentPos - 1];
      } else {
        throw new NoSuchElementException();
      }
    }

  }
}
