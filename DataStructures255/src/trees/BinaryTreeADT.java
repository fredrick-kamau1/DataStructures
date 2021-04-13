package trees;

import java.util.NoSuchElementException;

public interface BinaryTreeADT<T> extends Iterable<T> {
  
    public void clear();
    // Append "it" at the end of the list for unordered lists
    // Add at appropriate position for ordered lists
    // The list must ensure that the list's capacity is not exceeded
    public boolean add(T element);

    // Remove and return the current element
    public T remove(T element) throws NoSuchElementException;
    
    // Remove and return the first element
    public T removeFirst() throws NoSuchElementException;

    // Remove and return the last element
    public T removeLast(T element) throws NoSuchElementException;

    // Return the number of elements in the list
    public int size();

    // Tell if the list is empty or not
    public boolean isEmpty();
    
    // Return the first element in the list
    public T first();
    
    // Return the last element in the list
    public T last();
    
    // Tell if the element exists in the list
    public boolean contains (T element);
   
    // Copies the elements of the list onto the parameter array
    public void toArray(T[] anArray);
    
    
    /*  Unused methods below
     * 
    // Insert "it" at the current location
    // The list must ensure that the list's capacity is not exceeded
    public boolean addAtCurrent(T it);

    // Remove and return the current element
    public T removeCurrent() throws NoSuchElementException;
     
    // Return the position of the current element
    public int currPos();

    // Set the current position to "pos"
    public boolean moveToPos(int pos);

    // Return true if current position is at end of the list
    public boolean isAtEnd();

    // Return the current element
    public T getCurrentValue() throws NoSuchElementException;

    // Set the current position to the start of the list
    public void moveToStart();

    // Set the current position to the end of the list
    public void moveToEnd();

    // Move the current position one step left, no change if already at beginning
    public void prev();

    // Move the current position one step right, no change if already at end
    public void next();
     
     *  End of unused methods
     */
    
}

