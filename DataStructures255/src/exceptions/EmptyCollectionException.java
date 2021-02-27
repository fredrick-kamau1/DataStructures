package exceptions;

public class EmptyCollectionException extends RuntimeException{  
    
    public EmptyCollectionException(String collectionName) {
      super("The " + collectionName + " is empty");
    }

  }


