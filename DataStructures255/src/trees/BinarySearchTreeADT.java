package trees;

import java.util.NoSuchElementException;

public interface BinarySearchTreeADT<T> extends Iterable<T> {
    public void clear();
  
    // add element to tree based on ordering, < left, >= right
    public boolean add(T it);

    // Remove and return the element
    public T remove(T element) throws NoSuchElementException;
    
    // Remove and return the minimum element
    public T removeMin() throws NoSuchElementException;

    // Remove and return the maximum element
    public T removeMax() throws NoSuchElementException;

    // Return the number of elements in the list
    public int size();

    // Tell if the list is empty or not
    public boolean isEmpty();
    
    // Return the minimum element in the list
    public T min();
    
    // Return the maximum element in the list
    public T max();
    
    // Tell if the element exists in the list
    public boolean contains (T element);

    
    // Copies the elements of the list onto the parameter array
    public void toArray(T[] anArray);
    
        
}

