package queues;

import exceptions.ArrayCapacityException;

public class QueueTester {

  public static void main(String[] args) {
    LinkedQueue<Integer> lq = new LinkedQueue<Integer>();
    //ArrayQueue<Integer> lq = new ArrayQueue<Integer>();

    // Enque first three elements as initial size of array
    lq.enqueue(4);
    lq.enqueue(5);
    lq.enqueue(6);
    System.out.println("First element before deque: " + lq.first() + "\n");

    // Test enque after the growQueue method is called
    lq.enqueue(7);
    lq.enqueue(8);
    lq.enqueue(9);
    System.out.println("First element after growQueue(): " + lq.first() + "\n");

    // Test enque after the growQueue is called a second time
    lq.enqueue(10);
    lq.enqueue(11);
    System.out.println();

    // Test deque on the first two elements
    System.out.println("Deque[4]: " + lq.dequeue());
    System.out.println("Deque[5]: " + lq.dequeue());

    // check deque worked and there is a new first element
    System.out.println(
        "\nCheck first element after [4] & [5] are dequed : " + lq.first());

    // Test toString to see the queue as it stands
    System.out
        .println("\nThe whole queue currently as it stands: " + lq.toString());

    // Test contains function
    System.out.println("\nCheck if queue contains [15]: " + lq.contains(15));
    System.out.println("Check if queue contains [11]: " + lq.contains(11));

    // Test dequeued elements
    System.out.println(
        "\nCheck if queue contains dequeued element [4]: " + lq.contains(4));
    System.out.println(
        "Check if queue contains dequeued element [5]: " + lq.contains(5));

    // Test index of function
    System.out.println("\nIndex of [6] is 0: " + lq.indexOf(6));
    System.out.println("Index of [8] is 2: " + lq.indexOf(8) + "\n");

    // Test array to print out queue while null. Throws NullPointerException
    Integer[] myInt = null;
    tryToArray(lq, myInt);

    // Test array to print out queue not enough capacity
    Integer[] myInt2 = new Integer[2];
    tryToArray(lq, myInt2);
    System.out.println();

    // Test array to print out queue
    Integer[] myInt3 = new Integer[lq.size()];
    System.out
        .print("Test toArray function to print out all current elements ");
    tryToArray(lq, myInt3);

  }

  /*
   * tryToArray function with try/catch block to catch NullPointer and
   * ArrayCapacity exceptions
   */
  public static void tryToArray(QueueADT<Integer> T, Integer[] anArray) {

    try {
      T.toArray(anArray);
    } catch (NullPointerException e) {
      System.out.println("Try catch to get NullPointerException " + e);
    } catch (ArrayCapacityException e) {
      System.out.println("Try catch to get ArrayCapacityException " + e);
    }

  }

}
