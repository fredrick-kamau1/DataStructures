package trees;

import java.util.NoSuchElementException;

public class BSTreeTester {

  public static void main(String[] args) {

    BSTree<Integer> aTree = new BSTree<Integer>();
    //testOne(aTree);
    testMax(aTree); 
    removeMin(aTree); 
    removeMax(aTree);    
    testSize(aTree); 
    testIsEmpty(aTree); 
    
    //Test toArray
    System.out.println
    ("\n*****Test toArray method - Null Pointer Exception****");
    Integer[] aT = null; 
    testToArray(aTree, aT);
    
    System.out.println
    ("\n*****Test toArray method - Array Capacity exception****");
    Integer[] aT2 = new Integer[1]; 
    testToArray(aTree, aT2);
    
    System.out.println
    ("\n*****Test toArray method - working no exception****");
    Integer[] aT3 = new Integer[aTree.size()]; 
    testToArray(aTree, aT3);
    
    testOne(aTree);
  }

  public static void testMax(BSTree<Integer> aTree) {
    System.out.println("*****Test Max of the Tree*****");
    aTree.add(85);
    aTree.add(20);
    aTree.add(25);
    aTree.add(10);
    aTree.add(100);
    System.out.println("Max of the tree[100]: " + aTree.max());
    aTree.add(150);
    System.out.println("New max added[150]: " + aTree.max());
    System.out.println();
  }
  
  public static void removeMin(BSTree<Integer> aTree) {
    System.out.println("******Test removeMin*****");
    aTree.clear();
    try {
      aTree.removeMin();
    }catch (NoSuchElementException e) {
      System.out.println("Tree is empty " + e);
    }
    aTree.add(85);
    System.out.println("Remove with only the root[85]: " + aTree.removeMin());
    System.out.println(aTree);
    System.out.println("Add elements");
    aTree.add(20);
    aTree.add(25);
    aTree.add(10);
    aTree.add(100);
    System.out.println(aTree);
    System.out.println("Remove min[10]: " + aTree.removeMin());
    System.out.println("Remove min[20]: " + aTree.removeMin());
    System.out.println(aTree);
    System.out.println();
  }
  
  public static void removeMax(BSTree<Integer> aTree) {
    System.out.println("******Test removeMax*****");
    aTree.clear();
    try {
      aTree.removeMax();
    }catch (NoSuchElementException e) {
      System.out.println("Tree is empty " + e);
    }
    aTree.add(85);
    System.out.println("Remove with only the root[85]: " + aTree.removeMax());
    System.out.println(aTree);
    System.out.println("Add elements");
    aTree.add(20);
    aTree.add(25);
    aTree.add(10);
    aTree.add(100);
    System.out.println(aTree);
    System.out.println("Remove max[100]: " + aTree.removeMax());
    System.out.println("Remove max[25]: " + aTree.removeMax());
    System.out.println(aTree);
    System.out.println();  
  }
  
  public static void testSize(BSTree<Integer> aTree) {
    System.out.println("*****Test size of the Tree*****");
    aTree.clear();
    aTree.add(85);
    aTree.add(20);
    aTree.add(25);
    aTree.add(10);
    aTree.add(100);
    System.out.println(aTree);
    System.out.println("Size of the tree[5]: " + aTree.size());
    aTree.add(150);
    System.out.println(aTree);
    System.out.println("Add one more element, new size[6]: " + aTree.size());
    System.out.println();
  }
  
  public static void testIsEmpty(BSTree<Integer> aTree) {
    System.out.println("*****Test if Tree isEmpty*****");
    aTree.clear();
    System.out.println(aTree);
    System.out.println("Is tree empty? [true]: " + aTree.isEmpty()); 
    aTree.add(85);
    aTree.add(20);
    aTree.add(25);
    aTree.add(10);
    aTree.add(100);
    System.out.println(aTree);
    System.out.println("Is tree empty? [false]: " + aTree.isEmpty());    
  }
  
  public static void testToArray(BinarySearchTreeADT<Integer> aTree, Integer[] anArray) {      
    aTree.clear();
    aTree.add(70);
    aTree.add(40);
    aTree.add(20);
    aTree.add(30);
    aTree.add(40);
    aTree.add(50);
    
    try {
      aTree.toArray(anArray);
    }catch(NullPointerException e) {
      System.out.println("The array is null " + e);
    }catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("The size is not sufficient " + e);
    }
  }
  
  public static void testOne(BSTree<Integer> aTree) {
    aTree.clear();
    
    //Add elements
    aTree.add(50);
    aTree.add(30);
    aTree.add(40);
    aTree.add(35);
    aTree.add(40);
    aTree.add(80);
    aTree.add(85);
    aTree.add(20);
    aTree.add(25);
    aTree.add(10);
    aTree.add(100);
    aTree.add(5);    
    System.out.println();
    System.out.println("*****Remove a non-existent node******");     
    try {
      System.out.println("Remove 8: " + aTree.remove(8));
    } catch (NoSuchElementException e) {
      System.out.println("Element not found: " + e.getMessage());
    }
    System.out.println("\nRemove node with one right child");
    System.out.println("Remove 80: " + aTree.remove(80));
    System.out.println(aTree);
    System.out.println("85 should be rc of 50");

    System.out.println("\nRemove node with two children");
    System.out.println("Remove 30: " + aTree.remove(30));
    System.out.println(aTree);
    System.out.println("25 should be lc of 50");

    System.out.println("\nRemove node with one left child");
    System.out.println("Remove 20: " + aTree.remove(20));
    System.out.println(aTree);
    System.out.println("10 should be lc of 25");
  }
}
