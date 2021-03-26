package linkNodes;

import support.LNode;


public class NodeExample {

  public static void main(String[] args) {
    //example
    //usingString();
    //usingPerson();
    
    LNode<Integer> head = new LNode<Integer>();
    LNode<Integer> shoulders = new LNode<Integer>();
    
    head.setData(20);
    shoulders.setData(50);
    head.setNext(shoulders);
    shoulders.setNext(head);
    System.out.println(head.getData() + shoulders.getData());
    
    
    System.out.println();
    
    String s1 = "Welcome ";
    String s2 = "to ";
    String s3 = "Kansas";
    
    LNode<String> ln1 = new LNode<String>(s1);
    LNode<String> ln2 = new LNode<String>(s2);
    LNode<String> ln3 = new LNode<String>(s3);
    
    ln1.setNext(ln2);
    ln2.setNext(ln3);
    //ln3.setNext(ln1); //circular links
    
    //System.out.println("s1 is: " + s1 + " and ln1 is :" + ln1);
    //System.out.println(ln1.getData());
    
    System.out.println(ln1.getData() + ln2.getData() + ln3.getData());
    
    LNode<String> top = ln1; 
    System.out.println(top.getData() + top.getNext().getData() + top.getNext().getNext().getData());
        //top.getNext().getNext().getNext().getData());
    
    LNode<String> iterator = top; 
    while(iterator != null) {
      System.out.print(iterator.getData());
      iterator = iterator.getNext();
      
    }
  }
  
  public static void usingString() {
    String s1 = "Welcome ";
    String s2 = "to ";
    String s3 = "Kansas";
    
    LNode<String> ln1 = new LNode<String>(s1);
    LNode<String> ln2 = new LNode<String>(s2);
    LNode<String> ln3 = new LNode<String>(s3);
    
    ln1.setNext(ln2);
    ln2.setNext(ln3);
    //ln3.setNext(ln1); circular links
    
    System.out.println("s1 is: " + s1 + " and ln1 is :" + ln1);
    System.out.println(ln1.getData());
    
    System.out.println(ln3.getData() + ln2.getData() + ln1.getData());
    
    s1 = "come"; 
    System.out.println(s1);    
    System.out.println(ln1.getData());
    ln1.setData(s1);
    System.out.println(ln1.getData());
          
  }

}
