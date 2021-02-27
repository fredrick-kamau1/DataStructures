package oobasics;

/**
 * @author Fredrick Kamau
 */
public class LibraryItemTester {
  /**
   * @param args
   */
  public static void main(String[] args) {

    // System.out.println("***Test the Library Item***\n");
    // LibraryItem is now abstract comment out code
    /*
     * LibraryItem item1 = new LibraryItem("Hop on Pop", "BK001");
     * System.out.println("item1 toString: " + item1);
     * System.out.println("Title: " + item1.getTitle());
     * item1.setTitle("Green Eggs and Ham");
     * System.out.println("TEST: Change title to green eggs and ham");
     * System.out.println("Title after test: " + item1.getTitle());
     */

    // Test the Book class
    System.out.println("\n***Test Book class***\n");
    Book book1 = new Book("Hop on Pop", "BK002", "Dr. Seuss", "Randall House");
    System.out.println(
        "book1 title: " + book1.getTitle() + " , author: " + book1.getAuthor());
    // Implement toString method
    System.out.println(book1);

    // Test abstract methods
    System.out.println("\n***Test abstract methods***\n");
    book1.checkOut();
    System.out.println("Book checkout? " + book1.isCheckedOut());
    book1.returnItem();
    System.out.println("Book returned? " + book1.isCheckedOut());

    // Test the Ebook class with interface
    System.out.println("\n***Test Ebook class with interface***\n");
    Ebook ebook1 = new Ebook("Pila", "EN1098", "Ricky", "HBS", "PDF");
    System.out.println(ebook1);
    ebook1.getServiceApp();
    System.out.println();
    System.out.println(ebook1.checkOut());

    // Test the Streaming video class with interface
    System.out.println("\n***Test Streaming video class with interface***\n");
    StreamingVideo video1 = new StreamingVideo("Vuze", "VW0987", "Bilbao", "WB",
        "MP4");
    System.out.println(video1);
    video1.getServiceApp();
    System.out.println();
    System.out.println(video1.checkOut());
  }
}
