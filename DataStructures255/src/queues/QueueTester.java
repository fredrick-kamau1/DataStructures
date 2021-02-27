package queues;

public class QueueTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LinkedQueue<Integer> lq = new LinkedQueue<Integer>();
    lq.enqueue(4);
    System.out.println("First: " + lq.first());
    lq.enqueue(5);
    lq.enqueue(6);
    lq.enqueue(7);
    
    
  }

}
