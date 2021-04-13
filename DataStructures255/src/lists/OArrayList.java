package lists;

import exceptions.EmptyCollectionException;

public class OArrayList<T extends Comparable<T>> extends AArrayList<T> {

  @SuppressWarnings("unchecked") // Generic array allocation
  public OArrayList(int size) {
    listSize = modifiedCount = 0;
    listArray = (T[]) new Comparable[size]; // Create listArray
  }

  public OArrayList() {
    this(DEFAULT_SIZE); // Just call the other constructor
  }

  @SuppressWarnings("unchecked") // Generic array allocation
  protected void growList() {
    // create a larger array newList
    // copy all elements of list into newList array
    // update the list reference to point to newList

    T[] newList = (T[]) (new Comparable[size() + DEFAULT_SIZE]);

    for (int i = 0; i < size(); i++) {
      newList[i] = listArray[i];
    }

    listArray = newList;

  }

  @Override
  public boolean add(T element) {
    // TODO Auto-generated method stub
    int index = 0;
    if (isFull()) {
      growList();
    }

    // this is a linear search
    // change to a binary search
//    while (index < size() && (listArray[index].compareTo(element) < 0)) {
//        index++;

    //finding index using iterative binary search
    //index = binaryFind(listArray, elements);
    
    //finding index using recursive binary search    
    index = recBinaryFind(listArray, element, index, listSize - 1);

    shiftElements(index);
    listArray[index] = element;
    listSize++;
    modifiedCount++;
    return true;
  }

  //Iterative binary search
  public int binaryFind(T[] data, T element) {

    int low = 0;
    int high = listSize - 1;
    ;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (data[mid].compareTo(element) < 0)
        low = mid + 1;
      else if (data[mid].compareTo(element) > 0)
        high = mid - 1;
      else
        return mid;
    }
    return low;
  }
  
  //Recursive binary search
  private int recBinaryFind(T[] data, T element, int low, int high) {

    if (low > high)
      return low;

    int mid = (low + high) / 2;

    if (data[mid].compareTo(element) < 0)
      return recBinaryFind(data, element, mid + 1, high);
    else if (data[mid].compareTo(element) > 0)
      return recBinaryFind(data, element, low, mid - 1);
    else
      return mid;
  }
  
  //IndexOf method using iterative binary search
  public int indexOf(T element) {
    int index = binaryFind(listArray, element);
    if(listArray[index].equals(element)) {
     return index; 
    }else    
    return -1; 
  }
  
  //Contains method using iterative binary search
  public boolean contains(T element) {
    if (isEmpty()) {
      throw new EmptyCollectionException("List");
    }
    return (listArray[binaryFind(listArray, element)].equals(element));   
  }
}

