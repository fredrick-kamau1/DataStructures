package stacks;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;

public class LinkedStackTester {

  public static void main(String[] args) {
   
    LinkedStack<Integer> myStack = new LinkedStack<Integer>();
    //ArrayStack<Integer> myStack = new ArrayStack<Integer>();
    
    //Peek when stack is empty
    tryPeek(myStack);
    
    //Push and peek elements
    myStack.push(10);
    System.out.println(myStack.peek());
    myStack.push(20);
    System.out.println(myStack.peek());
    myStack.push(30);
    System.out.println(myStack.peek());
    myStack.push(40);
    System.out.println(myStack.peek());
    myStack.push(50);
    System.out.println(myStack.peek());
    System.out.println();
    myStack.push(60);
    
    //Test contains method    
    System.out.println(myStack.contains(10));
    System.out.println(myStack.contains(11));
    System.out.println();
    
    //Test search function
    System.out.println(myStack.search(50));
    System.out.println(myStack.search(30));    
    System.out.println(myStack.search(10));
    
    //length of the stack
    System.out.println("\nLength of Stack: " + myStack.length());
    System.out.println();
    
    //Test array to print out stack while null. Throws NullPointerException
    Integer[] myInt = null;
    tryToArray(myStack,myInt);
    System.out.println();
    
    //Test array to print out stack not enough capacity
    Integer[] myInt2 = new Integer[2];
    tryToArray(myStack,myInt2);
    
    //Test array to print out stack 
    Integer[] myInt3 = new Integer[5];
    tryToArray(myStack,myInt3);
    
    
  }
  
  /*tryToArray function with try/catch block to catch NullPointer and ArrayCapacity 
    exceptions*/
  public static void tryToArray(LinkedStack<Integer> T, Integer[] anArray) {
        
    try {
      T.toArray(anArray);
    } catch (NullPointerException e) {      
      System.out.println(e);
    } catch (ArrayCapacityException e) {      
      System.out.println(e);
    }
  }

  public static void tryPeek(LinkedStack<Integer> T) {
    try {
      System.out.println(T.peek());
    } catch (EmptyCollectionException e) {
      System.out.println(e);
    }
  }
}
