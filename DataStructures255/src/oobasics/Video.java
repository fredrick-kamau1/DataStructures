package oobasics;

/**
 * @author Fredrick Kamau
 */
public class Video extends LibraryItem {
  private String producer;
  private String studio;

  public Video(String title, String callNumber, String producer,
      String studio) {
    super(title, callNumber);
    this.producer = producer;
    this.studio = studio;
  }

  /**
   * @return the producer
   */
  public String getProducer() {
    return producer;
  }

  /**
   * @param producer the producer to set
   */
  public void setProducer(String producer) {
    this.producer = producer;
  }

  /**
   * @return the studio
   */
  public String getStudio() {
    return studio;
  }

  /**
   * @param studio the studio to set
   */
  public void setStudio(String studio) {
    this.studio = studio;
  }

  @Override
  public String toString() {
    String output = super.toString() + ", Producer: " + getProducer()
        + ", Studio: " + getStudio();
    return output;
  }

  @Override
  public boolean checkOut() {
    setCheckedOut(true);
    System.out.println("Videos are checkout for 2 weeks");
    return true;
  }
}
