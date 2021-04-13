package lists;

import java.util.Iterator;

public class ArrayListTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    OArrayList<Integer> list = new OArrayList<Integer>();
    //UArrayList<Integer> list = new UArrayList<Integer>();
    
    //add elements to the ordered list
    list.add(60);
    list.add(43);
    list.add(12);
    list.add(89);
    list.add(90);      
    list.add(40);
    
        
    //Test that elements printed out in the ordered format using toArray
    Integer[] ls = new Integer[list.size()];
    System.out.print("Expected toArray output [12, 40, 43, 60, 89, 90]: ");
    list.toArray(ls);
    
    //Test contains and indexOf
    System.out.println("\nTest contains 12 [true]:" + list.contains(12));
    System.out.println("\nTest indexOf 90 [5]: " + list.indexOf(90));
    System.out.println(); 
    
    //Test iterator
    System.out.println("Test the ierator: ");
    Iterator<Integer> it = list.iterator();
    while(it.hasNext()) {
    System.out.println("Number added: " + it.next());
    }
        
//    for(int number : list) {
//      System.out.println("Number: " + number);
//    }
  }
}
