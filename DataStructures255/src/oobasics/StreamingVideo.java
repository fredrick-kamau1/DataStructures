package oobasics;

/**
 * 
 * @author Fredrick Kamau
 *
 */

public class StreamingVideo extends Video implements Downloadable {

  private String format;

  public StreamingVideo(String title, String callNumber, String producer,
      String studio, String format) {
    super(title, callNumber, producer, studio);
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
  public String getServiceApp() {
    if (this.format.equalsIgnoreCase("MP4")) {
      System.out.println("Download VLC");
      ;
    } else {
      System.out.println("Windows media player will do!");
      ;
    }
    return this.format;
  }
  
  @Override
  public boolean checkOut() {
    setCheckedOut(true);
    System.out.println("Streamimg videos are checkout for 48hrs");
    super.checkOut();
    return true;
  }
}
