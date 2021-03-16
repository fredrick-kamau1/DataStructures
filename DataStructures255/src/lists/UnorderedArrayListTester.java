package lists;

import java.util.NoSuchElementException;

import exceptions.EmptyCollectionException;

public class UnorderedArrayListTester {

  public static void main(String[] args) {
    // Test the unordered array list

    UArrayList<String> al = new UArrayList<String>();
    System.out.println("List [] : " + al);
    System.out.println(
        "\n****Testing empty exception - should throw exceptions ****");
    testEmptyCollectionException(al);

    System.out.println("\n***Testing Test Observe Methods****");
    testObserverMethods(al);

    addToRearAndFrontTest(al);

    System.out.println(
        "\n****Testing empty exception - should not throw any exceptions ****");
    testEmptyCollectionException2(al);

    // testRemoveMethods(al);

//    addToRearAndFrontTest(al);
    testAddAfter(al);

    testRemoveMethods(al);

    System.out.println(
        "\n*****Testing no such element exception - with error catching****");
    testNoSuchElementException(al);

    System.out.println("\n****Testing add at ******");
    testAddAt(al);

  }

  private static void testObserverMethods(UArrayList<String> al) {
    // test contains(), isEmpty(), size()
    al.clear();
    System.out.println("list is empty [true]: " + al.isEmpty());
    al.add("A");
    al.add("B");
    al.add("C");
    System.out.println("List contains [B] - true: " + al.contains("B"));
    System.out.println("List contains [D] - false: " + al.contains("D"));
    System.out.println("Size[3]: " + al.size());

  }

  public static void testEmptyCollectionException(UArrayList<String> al) {
    // test all methods that would throw the exception
    // including first(), last(), remove(), removeLast(),
    // add your code here
    // al.first();
    // al.last();
    // al.remove("L");

  }

  // Test empty collection with try/catch
  public static void testEmptyCollectionException2(UArrayList<String> al) {
    // test all methods that would throw the exception
    // including first(), last(), remove(), removeLast(),
    // add your code here

    al.clear();
    try {
      al.first();
    } catch (EmptyCollectionException e) {
      System.out.println("Check first element: " + e);
    }
    try {
      al.last();
    } catch (EmptyCollectionException e) {
      System.out.println("Check last element: " + e);
    }
    try {
      al.remove("H");
    } catch (EmptyCollectionException e) {
      System.out.println("Remove element: " + e);
    }
    try {
      al.removeLast("O");
    } catch (EmptyCollectionException e) {
      System.out.println("Remove last element: " + e);
    }
  }

  public static void testNoSuchElementException(UArrayList<String> al) {
    // test all methods that throw the exception
    // add your code here
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
  }

  public static void testAddAfter(UArrayList<String> al) {
    System.out.println("\n****Testing addAfter method****");

    al.clear();
    al.add("J");
    al.add("W");
    al.add("B");
    al.add("A");
    System.out.println("List[J W B A] : " + al);

    al.addAfter("W", "Z");
    System.out.println("List[J W Z B A] : " + al);

    al.addAfter("B", "K");
    System.out.println("List[J W Z B K A] : " + al);

    System.out.println("Size [6]: " + al.size());

    System.out
        .println("\n****Testing addAfter -- should throw exceptions ****");
    // add your code here
    // al.clear();
    // Throws NoSuchElementException since there is no existing element "K"
    // al.addAfter("K", "L");
  }

  private static void testRemoveMethods(UArrayList<String> al) {
    System.out.println("\n****Testing remove methods****");
    // test all remove options, some that work, some that throw exceptions
    // you don't need to test remove from empty list - that should be part of
    // testEmptyCollectionException

    al.remove("Z");
    al.remove("K");
    System.out.println("List[J W B A] : " + al);
    al.removeFirst();
    System.out.println("List[W B A] : " + al);
    System.out.printf("Size[3]: %d, last[A]: %s\n", al.size(), al.last());
    // add your code here

  }

  private static void testAddAt(UArrayList<String> al) {
    // test scenarios that are valid, as well as scenarios that throw the
    // exception
    // add your code here
    al.clear();
    al.addAt(0, "R");
    al.addAt(1, "E");
    al.addAt(2, "D");
    System.out.println("List [R E D ]: " + al);
    al.addAt(3, "O");
    System.out.println("Add D at index 3 [R E D O]: " + al);

  }

}
