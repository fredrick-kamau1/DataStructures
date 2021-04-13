//package trees;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//import support.BTNode;
//
//public class BSTree<T extends Comparable<T>> implements BinaryTreeADT<T> {
//  
//  BTNode<T> root;
//  int size;
//  
//   public BSTree() {
//     root  = null; 
//     size = 0; 
//   }
//  @Override
//  public void clear() {
//    // TODO Auto-generated method stub
//    
//  }
//
//  @Override
//  public boolean add(T element) {
//    // TODO Auto-generated method stub
//    BTNode<T> newNode = new BTNode<T>();
//    if(isEmpty()) {
//      root = newNode; 
//      size++;      
//    }else
//    {
//      if(element <= root.getData()) {
//        
//      }
//    }
//    return false;
//  }
//
//  @Override
//  public T remove(T element) throws NoSuchElementException {
//    // TODO Auto-generated method stub
//    
//    BTNode<T> node = recRemove(root, element);
//    
//    if(node!= null)
//      return node.getData();
//    return null;
//  }
//  
//   
//  private BTNode<T> recRemove(BTNode<T> node, T element){
//    if(node == null)
//      return null; 
//    
//    else if(element.compareTo(node.getData()) < 0)
//      node.setLeft(recRemove(node.getLeft(), element));
//    else if(element.compareTo(node.getData()) > 0)
//      node.setRight(recRemove(node.getRight()), element);
//    else
//      node = removeNode(node);
//    return node; 
//    
//  }
//
//  
//  private BTNode<T> reomveNode()BTNode
//  @Override
//  public T removeFirst() throws NoSuchElementException {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public T removeLast(T element) throws NoSuchElementException {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public int size() {
//    // TODO Auto-generated method stub
//    return 0;
//  }
//
//  @Override
//  public boolean isEmpty() {
//    // TODO Auto-generated method stub
//    return false;
//  }
//
//  @Override
//  public T first() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public T last() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//
//  @Override
//  public boolean contains(T element) {
//    // TODO Auto-generated method stub
//    return false;
//  }
//
//  @Override
//  public void toArray(T[] anArray) {
//    // TODO Auto-generated method stub
//    
//  }
//
//  @Override
//  public Iterator<T> iterator() {
//    // TODO Auto-generated method stub
//    return null;
//  }
//  
//}