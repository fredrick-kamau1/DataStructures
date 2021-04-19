package trees;

public class tester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    BSTree<Integer> tree = new BSTree<Integer>();
    tree.add(10);
    tree.add(20);
    tree.add(30);
    tree.add(40);
    tree.add(50);
    
    Integer[] ar = new Integer[tree.size()];
    tree.toArray(ar);
    
  }
  

}
