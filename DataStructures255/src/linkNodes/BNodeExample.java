package linkNodes;

import support.BTNode;

public class BNodeExample {

  public static void main(String[] args) {
    
    BTNode<Integer> node1 = new BTNode<Integer>(1); 
    BTNode<Integer> node2 = new BTNode<Integer>(2); 
    BTNode<Integer> node3 = new BTNode<Integer>(3); 
    BTNode<Integer> node4 = new BTNode<Integer>(4); 
    
    node1.setLeft(node2);
    node1.setRight(node3);
    node3.setLeft(node4);
    
  }
}
