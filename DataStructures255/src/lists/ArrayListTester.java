package lists;

import java.util.Iterator;

public class ArrayListTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    UArrayList<Integer> list = new UArrayList<Integer>();
    //list.remove(0);
    list.add(60);
    list.add(43);
    list.add(12);
    list.add(89);
    list.add(90);
    list.removeLast(90); 
    list.addAfter(12, 13);
    list.addAt(4, 15);
    //list.clear();   
    list.add(40);
    list.addToFront(50);
    list.remove(40);
    
    
    //System.out.println(list.first());
    System.out.println(list.contains(89));
    System.out.println(list.indexOf(89));
    
    Integer[] ls = new Integer[list.size()];
    list.toArray(ls);
    
       
    
    Iterator<Integer> it = list.iterator();
    while(it.hasNext()) {
    System.out.println(it.next());
    }
        
    for(int number : list) {
      System.out.println("Number: " + number);
    }
  }

}
