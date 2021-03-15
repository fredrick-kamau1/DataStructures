/* 
 * Unsorted array list
 * This subclass of AArrayList implements the methods to add to an unsorted/indexed list
 */
package lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class UArrayList<T> extends AArrayList<T> implements UnorderedListADT<T> {

  // Append element to list  (at the end)
  // allocate larger array when list is full
  @Override
  public boolean add(T element) {
    if (isFull())       // list is full
      growList();
    
    listArray[listSize++] = element;
    modifiedCount++;
    return true;
  }

  // Add element to front of the list
  // allocate larger array when list is full
  @Override
  public void addToFront(T element) {    
      if (isFull())
      growList();
      
      shiftElements(FRONT);
      listArray[FRONT] = element; 
      listSize++; 
      modifiedCount++;
  }

  // Add element after an existing element in the list
  // Throw NoSuchElementException if existingElement is not found in the list
  @Override
  public void addAfter(T existingElement, T element) throws NoSuchElementException  {
    int index = 0;
    for(int i = 0; i < listSize; ++i) {
      if(listArray[i].equals(existingElement)) {
         index = i+1;
      }
    }
   shiftElements(index);
   listArray[index] = element;
   listSize++; 
   modifiedCount++; 
  }
  
  // Add element at specified index location
  // Throw IndexOutOfBoundsException if index is invalid
  public void addAt(int index, T element) throws IndexOutOfBoundsException {
    if(index > listSize) {
      throw new IndexOutOfBoundsException();
    }
    shiftElements(index);
    listArray[index] = element; 
    listSize++;
    modifiedCount++; 
  }
}

