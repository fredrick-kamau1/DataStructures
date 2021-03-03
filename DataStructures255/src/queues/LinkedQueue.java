package queues;

import java.util.Arrays;

import exceptions.ArrayCapacityException;
import exceptions.EmptyCollectionException;
import support.LNode;

public class LinkedQueue<T> implements QueueADT<T> {

	private LNode<T> front;
	private LNode<T> rear;
	private int size;
	
	public LinkedQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
		LNode<T> newNode = new LNode<T>(element);
		if (isEmpty()) {
			rear = newNode;
			front = newNode;
		}
		else {
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T retData;
		if (isEmpty()) {
			throw new EmptyCollectionException("linked queue");
		}
		else {
		
			retData = front.getData();
			front = front.getNext();
			size--;
			return retData;
		}
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("linked queue");
		}
		else {
		
			return front.getData();
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String toString() {
		String retString = "[";
		LNode<T> it = front;
		while (it != null) {
			retString += it.getData();
			retString += " ";
			it = it.getNext();
		}
		retString += "]";
		return retString;
	}

	public void toArray(T[] anArray) {
    LNode<T> newNode = front;
    if (size > anArray.length) {
      throw new ArrayCapacityException("Stack");
    } else {
      for (int i = 0; i < anArray.length; i++) {
        anArray[i] = newNode.getData();
        newNode = newNode.getNext();
      }
    }
    System.out.println(Arrays.toString(anArray));
	}
	
	public boolean contains(T element) {
    LNode<T> newNode = front;
    while (newNode != null) {
      if (newNode.getData() == element)
        return true;
      newNode = newNode.getNext();
    }
    return false;
  }
	
	public int search(T element) {
    int count = 1;
    LNode<T> newNode = front;
    while (newNode != null) {
      if (newNode.getData() == element)
        break;
      newNode = newNode.getNext();
      count++;
    }
    return count;
  }
}
