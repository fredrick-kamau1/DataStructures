package lists;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(60);
    list.add(43);
    list.add(12);
    list.add(89);
    
    Iterator<Integer> it = list.iterator();
    System.out.println(it.next());
    System.out.println(it.next());
    System.out.println(it.next());
    System.out.println(it.next());
  }

}
