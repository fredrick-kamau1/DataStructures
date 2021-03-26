package lists;

import java.util.NoSuchElementException;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;

public class UnorderedArrayListTester {

  public static void main(String[] args) {
    // Test the unordered array list

    UArrayList<String> al = new UArrayList<String>();
    System.out.println("List [] : " + al);

    // Test observe methods
    testObserverMethods(al);

    // Test add to rear and front methods
    addToRearAndFrontTest(al);

    // Test empty collection exception with error catching
    testEmptyCollectionException(al);

    // Test add after methods
    testAddAfter(al);

    // Test remove methods
    testRemoveMethods(al);

    // Test no such element exception with error catching
    testNoSuchElementException(al);

    // Test add at method
    testAddAt(al);
    
    //Test toArray
    System.out.println
    ("\n*****Test toArray method - Null Pointer Exception****");
    String[] ls1 = null; 
    testToArray(al, ls1);
    
    System.out.println
    ("\n*****Test toArray method - Array Capacity exception****");
    String[] ls2 = new String[3]; 
    testToArray(al, ls2);
    
    System.out.println
    ("\n*****Test toArray method - working no exception****");
    String[] ls3 = new String[al.size()]; 
    testToArray(al, ls3);
  }

  private static void testObserverMethods(UArrayList<String> al) {
    // test contains(), isEmpty(), size()
    al.clear();
    System.out.println("\n***Testing Test Observe Methods****");
    System.out.println("list is empty [true]: " + al.isEmpty());
    al.add("A");
    al.add("B");
    al.add("C");
    System.out.println("List contains [B] - true: " + al.contains("B"));
    System.out.println("List contains [D] - false: " + al.contains("D"));
    System.out.println("Size[3]: " + al.size());

  }

  // Test empty collection with try/catch
  public static void testEmptyCollectionException(UArrayList<String> al) {
    // test all methods that would throw the exception
    // including first(), last(), remove(), removeLast(),
    // add your code here
    al.clear();
    System.out.println(
        "\n****Testing empty exception - should not throw any exceptions ****");
    System.out.println("Current list is empty: " + al);
    try {
      al.first();
    } catch (EmptyCollectionException e) {
      System.out.println("Check first element when list is empty: " + e);
    }
    try {
      al.last();
    } catch (EmptyCollectionException e) {
      System.out.println("Check last element when list is empty: " + e);
    }
    try {
      al.remove("H");
    } catch (EmptyCollectionException e) {
      System.out.println("Remove element when list is empty: " + e);
    }
    try {
      al.removeLast("O");
    } catch (EmptyCollectionException e) {
      System.out.println("Remove last element when list is empty: " + e);
    }
  }

  public static void testNoSuchElementException(UArrayList<String> al) {
    // test all methods that throw the exception
    // add your code here
    System.out.println(
        "\n*****Testing no such element exception - with error catching****");
    al.clear();
    al.add("F");
    al.add("R");
    al.add("E");
    al.add("D");
    System.out.println("List[F R E D ]: " + al);
    try {
      al.remove("K");
    } catch (NoSuchElementException e) {
      System.out.println("Remove element K: does not exist " + e);
    }
    try {
      al.removeLast("E");
    } catch (NoSuchElementException e) {
      System.out.println("Remove element E: Not last element " + e);
    }
    al.removeLast("D");
    System.out.println("last element D removed [F R E ]: " + al);
  }

  public static void addToRearAndFrontTest(UArrayList<String> al) {
    al.clear();
    System.out.println("\n****Testing add and addToFront methods - ****");
    System.out.println("List [] : " + al);
    System.out.println("*Add B, then A");
    al.add("B");
    al.add("A");
    System.out.println("List [B A] : " + al);
    System.out.println("*Add W to front, then add J to front");
    al.addToFront("W");
    al.addToFront("J");
    System.out.println("List[J W B A] : " + al);
    System.out.println("Add 'K' to rear");
    al.addAfter("A", "K");
    System.out.println("List[J W B A K ] : " + al);
  }

  public static void testAddAfter(UArrayList<String> al) {
    System.out.println("\n****Testing addAfter method****");
    al.clear();
    al.add("J");
    al.add("W");
    al.add("B");
    al.add("A");
    System.out.println("List[J W B A] : " + al);
    System.out.println("Add 'Z' afer 'W'");
    al.addAfter("W", "Z");
    System.out.println("List[J W Z B A] : " + al);
    System.out.println("Add 'K' afer 'B'");
    al.addAfter("B", "K");
    System.out.println("List[J W Z B K A] : " + al);
    System.out.println("Size [6]: " + al.size());
    System.out.println("\n****Testing addAfter when element is non-existent -- "
        + "with error catching ****");
    // add your code here
    // Throws NoSuchElementException since there is no existing element "K"
    try {
      al.addAfter("F", "L");
    } catch (NoSuchElementException e) {
      System.out.println("Trying to add 'L' when 'K' does not exist " + e);
    }
  }

  private static void testRemoveMethods(UArrayList<String> al) {
    System.out.println("\n****Testing remove methods****");
    // test all remove options, some that work, some that throw exceptions
    // you don't need to test remove from empty list - that should be part of
    // testEmptyCollectionException
    System.out.println("Current list [J W Z B K A ]: " + al);
    al.remove("Z");
    al.remove("K");
    System.out.println("Remove 'Z' and 'K' [J W B A] : " + al);
    al.removeFirst();
    System.out.println("Remove first element 'J' [W B A] : " + al);
    System.out.printf("Size[3]: %d, last[A]: %s\n", al.size(), al.last());
    // add your code here
    al.removeLast("A");
    System.out.println("Remove last element 'A' [WB]: " + al);

  }

  private static void testAddAt(UArrayList<String> al) {
    // test scenarios that are valid, as well as scenarios that throw the
    // exception
    // add your code here
    System.out.println("\n****Testing add at ******");
    al.clear();
    al.addAt(0, "R");
    al.addAt(1, "E");
    al.addAt(2, "D");
    System.out.println("List [R E D ]: " + al);
    al.addAt(3, "O");
    System.out.println("Add D at index 3 [R E D O]: " + al);

    // Test error catching index out of bounds
    try {
      System.out.println("Test index addAt index 7: ");
      al.addAt(7, "K");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Index 7 exceeds the current list size " + e);
    }
  }
  
  public static void testToArray(ListADT<String> al, String[] anArray) {  
    
    try {
      al.toArray(anArray);
    }catch(NullPointerException e) {
      System.out.println("The array is null " + e);
    }catch(ArrayCapacityException e) {
      System.out.println("The size is not sufficient " + e);
    }
  }
}
