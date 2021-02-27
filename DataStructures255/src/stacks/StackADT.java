package stacks;

public interface StackADT<T> {
  
  public void push(T element);
  
  public T pop();
  
  public T peek();
  
  public boolean isEmpty();
  
  public int length();
  
  public String toString();

}