package oobasics;

public class Book extends LibraryItem {

  private String author;
  private String publisher;

  public Book(String title, String uniqueId, String author, String publisher) {
    super(title, uniqueId);

    this.author = author;
    this.publisher = publisher;
  }

  /**
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @return the publisher
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * @param publisher the publisher to set
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String toString() {

    String retString = super.toString();
    retString += ", author: " + getAuthor() + ", Publisher: " + getPublisher();
    return retString;
  }

  @Override
  public boolean checkOut() {
    setCheckedOut(true);
    System.out.println("Books are checkout for 2 weeks");
    return true;
  }
}
