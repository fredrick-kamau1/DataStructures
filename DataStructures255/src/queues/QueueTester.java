package queues;

public class QueueTester {

  public static void main(String[] args) {
    //LinkedQueue<Integer> lq = new LinkedQueue<Integer>();
    ArrayQueue<Integer> lq= new ArrayQueue<Integer>();
    //ResizingArrayQueue<Integer> lq = new ResizingArrayQueue<Integer>();
    lq.enqueue(4);
    //System.out.println("First: " + lq.first());
    lq.enqueue(5);
    lq.enqueue(6);
    lq.enqueue(7);
    lq.enqueue(8);
    lq.enqueue(9);
    lq.enqueue(10);
    lq.enqueue(11);
    lq.enqueue(12);
    lq.dequeue();
    lq.dequeue();
    lq.enqueue(13);
    lq.enqueue(14);
    lq.dequeue();
    
    
    System.out.println("Queue: " + lq.toString());
    
    
    
    
  }

}
