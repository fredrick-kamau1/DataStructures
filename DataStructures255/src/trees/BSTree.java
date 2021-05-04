package trees;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lists.UArrayList;
import support.BTNode;

public class BSTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

  BTNode<T> root;
  int size;
  public int modifiedCount; 


  public BSTree() {
    root = null;
    //  size = 0;
  }

  @Override
  public void clear() {
    root = null;
    //  size = 0;

  }

  @Override
  public boolean add(T element) {
    // implement add with recursive call
    root = recAdd(root, element);
    return true;
  }

  private BTNode<T> recAdd(BTNode<T> node, T element) {

    if (node == null) {
      BTNode<T> newNode = new BTNode<T>(element);
      return newNode;
    }

    else if (element.compareTo(node.getData()) < 0) {
      node.setLeft(recAdd(node.getLeft(), element));
    }
    else {
      // same process as above but split into two lines
      // hold on to the node returned from recAdd and then 
      // set it as the right child of this node
      BTNode<T> aNode = recAdd(node.getRight(),element);
      node.setRight(aNode);
    }

    return node;

  }

  @Override
  public T remove(T element) throws NoSuchElementException {
    // TODO Auto-generated method stub

    T temp = recContains(root, element);

    if (temp != null) {
      root = recRemove(root, element);
      return temp;
    }

    throw new NoSuchElementException();
  }


  private BTNode<T> recRemove(BTNode<T> node, T element) {

    if (node == null) {
      return null;
    }
    else if (element.compareTo(node.getData()) < 0) 
      node.setLeft(recRemove(node.getLeft(), element));
    else if (element.compareTo(node.getData()) > 0)
      node.setRight(recRemove(node.getRight(), element));
    else // we found it
      node = removeNode(node);

    return node;
  }

  private BTNode<T> removeNode(BTNode<T> node)  {
    T data;

    if (node.getLeft() == null)
      return node.getRight();
    else if (node.getRight() == null)
      return node.getLeft();
    else {
      // this means it has both children;
      data = getPredecessor(node);
      node.setData(data);
      node.setLeft(recRemove(node.getLeft(),data));
      return node;

      // data = getSuccessor(node);
      // node.setData(data);
      // node.setRight(recRemove(node.getRight(), data));
      // return node;
    }
  }

  private T getPredecessor(BTNode<T> node) {
    node = node.getLeft();
    while (node.getRight() != null) 
      node = node.getRight();
    return node.getData();
  }


  @SuppressWarnings("unused")
  private T getSuccessor(BTNode<T> node) {
    node = node.getRight();
    while (node.getLeft() != null)
      node = node.getLeft();

    return node.getData();
  }

  @Override
  public T removeMin() throws NoSuchElementException {
    // LabWork         
  if(isEmpty())
    throw new NoSuchElementException();
  return remove(min()); 
  }  

  @Override
  public T removeMax() throws NoSuchElementException {
    // LabWork
    if(isEmpty())
      throw new NoSuchElementException();
    return remove(max()); 
  }

  @Override
  public int size() {
    // LabWork
    // use a recursive process to calculate the size of the tree
    if(isEmpty())
      return 0; 
    return recSize(root);
  }
  
  private int recSize(BTNode<T> node) {
    int leftCount = 0;
    int rightCount = 0; 
     
    if(isEmpty())
      return 0; 
    
     if(node.getLeft() != null) {
        leftCount = recSize(node.getLeft());
      }
     if(node.getRight() != null) {
       rightCount = recSize(node.getRight());
     }
    return leftCount + 1 + rightCount;  
  }

  @Override
  public boolean isEmpty() {
    // LabWork
    return (root == null);
  }

  @Override
  public T min() {
    // method would probably be min()
    return recMin(root);
  }

  private T recMin(BTNode<T> node) {
    T retData;
    if (node == null)
      return null;

    retData = recMin(node.getLeft());
    if (retData == null) {
      retData = node.getData(); 
    }
    return retData;
  }

  
  @Override
  public T max() {
    // LabWork
    // use the example of min to develop the max method
    // return the largest element in the BST
    // create a recursive helper method    
    return recMax(root);
  }
  
  private T recMax(BTNode<T> node) {
    T retData;
    if(node == null)
      return null; 
    retData = recMax(node.getRight());
    if(retData == null) {
      retData = node.getData();
    }
    return retData; 
  }

  @Override
  public boolean contains(T element) {
    // check if element is in tree
    return (recContains(root, element) != null);
  }

  private T recContains(BTNode<T> node, T element) {

    if (node == null)
      return null;
    else if (element.compareTo(node.getData()) == 0)
      return node.getData();
    else if (element.compareTo(node.getData()) < 0)
      return recContains(node.getLeft(), element);
    else 
      return recContains(node.getRight(), element);
  }

  // Lab assignment
  @Override
  public void toArray(T[] anArray) {
    // use a recursive approach to return an array of the elements
    // in an inorder traversal   
    if(isEmpty())
      throw new NullPointerException(); 
    
    if(anArray.length > size()) {
      throw new ArrayIndexOutOfBoundsException();
    }
   recToArray(root, anArray, 0);        
  }

  private void recToArray(BTNode<T> node, T[] anArray, int index) {  
    T data; 
    if(node == null)        
       return;      
    recToArray(node.getLeft(), anArray, index);
    data = anArray[index++] = node.getData();
    System.out.print(data + " ");
    recToArray(node.getRight(), anArray, index);     
  }
  
  public void balance() {
    @SuppressWarnings("unchecked")
    T[] anArray = (T[]) new Comparable[size()];
    toArray(anArray);
    clear();
    int low = 0;
    int high = anArray.length - 1;
    buildTree(anArray, low, high);
    
     
  }
  private void buildTree(T[] anArray, int low, int high) {
    int mid = 0;
    if(low == high) {
      add(anArray[low]);
    } else if(low + 1 == high) {
      add(anArray[low]);
      add(anArray[high]); 
    }else {
      mid = (high + low) / 2;
      add(anArray[mid]); 
      
      buildTree(anArray, low, mid -1);
      buildTree(anArray, mid + 1, high);
    }      
  }

  public int height() {     
    return treeHeight(root);      
  }

  private int treeHeight(BTNode<T> node) {      
    if (node == null)
      return -1;       
    return Math.max(treeHeight(node.getLeft()), treeHeight(node.getRight())) + 1;   
  }
  
  
  @Override
  public String toString() {
    String retString = "[";
    retString = recToString(root, retString);
    retString += "]";
    return retString;

  }

  public String recToString(BTNode<T> node, String retString) {

    if (node == null) {
      return retString;
    }
    else {
      retString = recToString(node.getLeft(), retString);
      retString += node.getData();
      retString += " ";
      retString = recToString(node.getRight(), retString);      
    }
    return retString;
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return inOrderIterator();
  }
  
  public Iterator<T> inOrderIterator() {
    // TODO Auto-generated method stub

    UArrayList<T> eList = new UArrayList<T>();
    inOrder(root, eList);

    return new TreeIterator(eList.iterator());

  }

  private void inOrder(BTNode<T> node, UArrayList<T> eList) {

    if (node != null) {
      inOrder(node.getLeft(), eList);
      eList.add(node.getData());
      inOrder(node.getRight(), eList);
    }

  }

  private class TreeIterator implements Iterator<T> {

    private Iterator<T> treeIterator;
    private int currentModifiedCount;

    public TreeIterator(Iterator<T> listIterator) {

      treeIterator = listIterator;
      currentModifiedCount = modifiedCount;
    }

    @Override
    public boolean hasNext() throws ConcurrentModificationException {
      // 

      if (currentModifiedCount != modifiedCount)
        throw new ConcurrentModificationException();

      return (treeIterator.hasNext());

    }

    @Override
    public T next() {
      // 

      if (hasNext()) 
        return treeIterator.next();
      else
        throw new NoSuchElementException();
    }

  }
  
  protected T root() {
    return root.getData();
    
  }
}
