package support;

public class LNode<T> {
  private LNode<T> next; 
  private T data; 

  //Constructors
  public LNode(T data, LNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public LNode(T data) {
    this.next = null;
    this.data = data;    
  }
  
  public LNode(LNode<T> next) {
    data = null;
    this.next = next; 
  }
  
  public LNode() {
    this.next = null;
    this.data = null;
  }

  public T getData() { // Return the data field
    return data;
  }

  public void setData(T data) { // Set the data field
    this.data = data;
  }

  public LNode<T> getNext() { // Return the next field
    return next;
  }

  public void setNext(LNode<T> next) { // Set the next field
    this.next = next;
  }

}
