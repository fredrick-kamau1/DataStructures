package oobasics;

/**
 * 
 * @author Fredrick Kamau
 *
 */

public abstract class LibraryItem {

  private String title;
  private String callNumber;
  private boolean checkedOut;

  public LibraryItem(String title, String callNumber) {

    this.title = title;
    this.callNumber = callNumber;
  }

  /**
   * @return the checkedOut
   */
  public boolean isCheckedOut() {
    return checkedOut;
  }

  protected void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }

  public abstract boolean checkOut();

  /**
   * @param the checkedOut
   */
  public boolean returnItem() {
    // set checkedOut to false if item is returned
    return this.checkedOut = false;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the callNumber
   */
  public String getCallNumber() {
    return callNumber;
  }

  /**
   * @param callNumber the callNumber to set
   */
  protected void setCallNumber(String callNumber) {
    // validate the callNumber
    this.callNumber = callNumber;
  }

  @Override
  public String toString() {
    String retString = "";

    retString += "Title: " + getTitle();
    retString += ", callNumber: " + getCallNumber();
    return retString;
  }
}
