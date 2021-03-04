package stacks;

import exceptions.EmptyCollectionException;

public class ArrayStackTester {

  public static void main(String[] args) {

    ArrayStack<Integer> myStack = new ArrayStack<Integer>();

    try {
      myStack.peek();
    } catch (EmptyCollectionException e) {
      // e.printStackTrace();
      System.out.println(e.getMessage());
    }

    // Test first push
    System.out.println("Push number 4");
    myStack.push(4);
    System.out.println("Test peek [4]. Method returned: " + myStack.peek());

    // Test new item at top after a second push
    System.out.println("Push number 5");
    myStack.push(5);
    System.out.println("Test peek [5]. Method returned: " + myStack.peek());

    // Test new item at top after a third push
    System.out.println("Push number 6");
    myStack.push(6);
    System.out.println("Test peek [6]. Method returned: " + myStack.peek());

    /*
     * Test new item at top after a fourth and final push before the stackArray
     * is full
     */
    System.out.println("Push number 7");
    myStack.push(7);
    System.out.println("Test peek [7]. Method returned: " + myStack.peek());

    // Testing the new boundary
    /* First push after stackArray is full and growStack() has been called */
    System.out.println(
        "\ngrowthStack() called for the first time to double the array");
    System.out.println("Push number 8");
    myStack.push(8);
    System.out.println("Test peek [8]. Method returned: " + myStack.peek());

    /* Second push after growStack() */
    System.out.println("Push number 9");
    myStack.push(9);
    System.out.println("Test peek [9]. Method returned: " + myStack.peek());

    /* Third push after growStack() */
    System.out.println("Push number 10");
    myStack.push(10);
    System.out.println("Test peek [10]. Method returned: " + myStack.peek());

    /* Fourth push after growStack() */
    System.out.println("Push number 11");
    myStack.push(11);
    System.out.println("Test peek [11]. Method returned: " + myStack.peek());

    // Testing boundary for the second time showing the stack has no boundary
    System.out
        .println("\ngrowthStack() called a second time to double the array");
    System.out.println("Push number 20");
    myStack.push(20);
    System.out.println("Test peek [20]. Method returned: " + myStack.peek());

    // Second push in the second growth
    System.out.println("Push number 30");
    myStack.push(30);
    System.out.println("Test peek [30]. Method returned: " + myStack.peek());

    // Test clear method
    // myStack.clear();
    // System.out.println(myStack.peek());

    // pop all but two items
    myStack.pop();
    myStack.pop();
    myStack.pop();
    myStack.pop();
    myStack.pop();
    myStack.pop();
    myStack.pop();
    myStack.pop();

    System.out.println("\nPeek after 8 elements have been popped and 2 remain");
    System.out.println("Test peek [5] " + myStack.peek() + ". Stack Length: "
        + myStack.length());

    // Check the current size of the array
    System.out.print("\nCurrent size of the array: ");
    myStack.arraySize();

    /*
     * Making the ArrayStack unbounded makes the code inefficient since in the
     * worst case as we expand the array by doubling the size, the total time to
     * insert n elements will be O(n)
     */
    
    System.out.println("\nDoes stack contain [8]: " + myStack.contains(8));
    System.out.println("Does stack contain [4]: " + myStack.contains(4) + "\n");
    System.out.println("Current stack: " + myStack.toString());
    System.out.println("\nElement on top [5] index 1: " + myStack.search(5));
    System.out.println();
  }
}
