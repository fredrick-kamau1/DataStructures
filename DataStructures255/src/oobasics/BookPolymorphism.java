package oobasics;

public class BookPolymorphism {

  public static void main(String[] args) {

    //Instantiate Book and Ebook objects and print
    Book book1 = new Book("Good boy", "BK0122", "Peter K", "BD house");
    Ebook ebook2 = new Ebook("Breeze","EB01245","Ronan H","Howdy","PDF");
    System.out.println(book1);    
    System.out.println(ebook2);
    
    //Display checkOut method for book and EBook
    System.out.println("***Checkout***\n");
    ebook2.checkOut();
    System.out.println();
    book1.checkOut();
    System.out.println();
    
    //Instantiate Video and StreamingVideo objects and print
    Video video1 = new Video("Happy","VD5478","Kilo R","Webster");
    StreamingVideo sVideo2 = new StreamingVideo("Ali","SV789","Stugart","Starz"
        ,"MP4");
    System.out.println(video1);
    System.out.println(sVideo2);
    System.out.println(video1.getProducer());
    System.out.println(sVideo2.getFormat());
    
    //Display checkOut method for Video and StreamingVideo
    System.out.println("***Checkout***\n");
    video1.checkOut();
    System.out.println();
    sVideo2.checkOut();
    System.out.println();
    
    //Create different declared and actual types
    Book newEbook = new Ebook("The Catch","BK3652","Helid O","Lighthouse","PDF");
    System.out.println(newEbook);
    
    //Test methods to show only declared type 
    System.out.println(newEbook.getClass());
    System.out.println(newEbook.getPublisher());
    System.out.println(newEbook.getAuthor());
    newEbook.checkOut(); 
  }
}
