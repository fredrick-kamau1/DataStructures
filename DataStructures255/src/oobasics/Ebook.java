package oobasics;

/**
 * @author Fredrick Kamau
 *
 */
public class Ebook extends Book implements Downloadable {

  private String format;  
  
  public Ebook(String title, String uniqueId, String author, String publisher, 
      String format) {
    super(title, uniqueId, author, publisher);
    this.format = format;    
  }

  /**
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * @param format the format to set
   */
  public void setFormat(String format) {
    this.format = format;
  }

  @Override
  public String toString(){
    String output = super.toString() + ", Format: " + getFormat();        
    return output; 
  }
  @Override 
  public String getServiceApp() {    
      if(this.format.equalsIgnoreCase("PDF")) {
        System.out.println("PDF Reader");
      }else {
        System.out.println("Ebook Reader");
      }      
      return this.format;
  } 
  
  @Override
  public boolean checkOut() {
    setCheckedOut(true);
    System.out.println("Ebooks are checked out for 3 weeks.");
    super.checkOut();
    return true; 
  }
}
