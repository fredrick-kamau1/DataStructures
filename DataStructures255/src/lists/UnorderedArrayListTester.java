package lists;

public class UnorderedArrayListTester {

  public static void main(String[] args) {
    // Test the unordered array list

    UArrayList<String> al = new UArrayList<String>();
    System.out.println("List [] : " + al);
    System.out.println("\n****Testing empty exception - should throw exceptions ****");
    testEmptyCollectionException(al);
    
    System.out.println("\n***Testing Test Observe Methods****");
    testObserverMethods(al);

    addToRearAndFrontTest(al);
    
    System.out.println("\n****Testing empty exception - should not throw any exceptions ****");
    testEmptyCollectionException(al);

    //testRemoveMethods(al);
    
//    addToRearAndFrontTest(al);
    testAddAfter(al);
    testAddAt(al);
    
    testRemoveMethods(al);
    
    System.out.println("\n****Testing empty exception - should throw exceptions ****");
    testEmptyCollectionException(al);
    
    
    

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
    al.add("A");
    System.out.println(al.first()); 


  }
  
  public static void testNoSuchElementException(UArrayList<String> al) {
    // test all methods that throw the exception
    // add your code here
    
  }
  
  public static void addToRearAndFrontTest(UArrayList<String> al) {
    System.out.println("\n****Testing add and addToFront methods - ****");
    System.out.println("List [] : " + al);
    System.out.println("*Add B, then A");
    al.add("B");
    al.add("A");
    System.out.println("List [B A] : " + al);
    //System.out.println("*Add W to front, then add J to front");
    //al.addToFront("W");
    //al.addToFront("J");
    //System.out.println("List[J W B A] : " + al);
  }
  
  public static void testAddAfter(UArrayList<String> al) {
    System.out.println("\n****Testing addAfter method****");

    al.clear();
    al.add("J"); al.add("W"); al.add("B"); al.add("A");
    System.out.println("List[J W B A] : " + al);

    al.addAfter("W", "Z");
    System.out.println("List[J W Z B A] : " + al);

    al.addAfter("B", "K");
    System.out.println("List[J W Z B K A] : " + al);

    System.out.println("Size [6]: " + al.size());

    System.out.println("\n****Testing addAfter -- should throw exceptions ****");
    // add your code here
    
  }
  
  private static void testAddAt(UArrayList<String> al) {
    // test scenarios that are valid, as well as scenarios that throw the exception
    // add your code here
      
  }
  
  private static void testRemoveMethods(UArrayList<String> al) {
    System.out.println("\n****Testing remove methods****");
    // test all remove options, some that work, some that throw exceptions
    // you don't need to test remove from empty list - that should be part of testEmptyCollectionException

    System.out.println("List[J W B A] : " + al);
    al.removeFirst();
    System.out.println("List[W B A] : " + al);
    System.out.printf("Size[3]: %d, last[A]: %s\n" , al.size(), al.last());

    // add your code here
    
  }
  

}
