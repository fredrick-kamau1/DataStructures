package lists;

public interface UnorderedListADT<T> extends ListADT<T> {

  // add element at the front of the list
  public void addToFront(T element);
  
  // add element after an existing element
  // throw noSuchElement
  public void addAfter(T existingElement, T element);

}
