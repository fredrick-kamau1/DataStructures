package exceptions;

public class ArrayCapacityException extends ArrayIndexOutOfBoundsException{
    
    public ArrayCapacityException(String collectionName) {
      super("The " + collectionName + " has no capacity");
    }

  }


