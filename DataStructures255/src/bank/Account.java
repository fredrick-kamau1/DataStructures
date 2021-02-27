/**
 * 
 */
package bank;
/**
 * @author Fredrick Kamau */
public class Account
{
  private String firstName;
  private String lastName;
  private int accountNum; 
  
  public Account(String firstName, String lastName, int accountNum)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.accountNum = accountNum; 
  }

  /**
   * @return the firstName
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  /**
   * @return the accountNum
   */
  public int getAccountNum()
  {
    return accountNum;
  }

  /**
   * @param accountNum the accountNum to set
   */
  public void setAccountNum(int accountNum)
  {
    this.accountNum = accountNum;
  }
  
  @Override  
  public String toString()
  {
    String output = "Full name: " + getFirstName() + " " +getLastName() + 
        " Account number: " + getAccountNum(); 
    return output; 
    
//    String output = "";
//    output += "Full name:" + getFirstName() + " " +getLastName();
//    output += " Account number: " + getAccountNum(); 
//    return output; 
  }
  
 }
