 package support;

public class BTNode<T> {
  
  T data;
  BTNode<T> left;
  BTNode<T> right;
  
  //constructors
  public BTNode() {
    left = right = null;
    data = null; 
  }
  
  public BTNode(T data) {
    this.data = data;
    left = right = null; 
  }
  
  
  /**
   * @return the data
   */
  public T getData() {
    return data;
  }
  /**
   * @param data the data to set
   */
  public void setData(T data) {
    this.data = data;
  }
  /**
   * @return the left
   */
  public BTNode<T> getLeft() {
    return left;
  }
  /**
   * @param left the left to set
   */
  public void setLeft(BTNode<T> left) {
    this.left = left;
  }
  /**
   * @return the right
   */
  public BTNode<T> getRight() {
    return right;
  }
  /**
   * @param right the right to set
   */
  public void setRight(BTNode<T> right) {
    this.right = right;
  }
  
  

}
