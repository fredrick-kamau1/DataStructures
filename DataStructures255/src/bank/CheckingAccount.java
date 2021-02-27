package bank;

public class CheckingAccount extends Account
{
  private int balance; 
  public CheckingAccount(String firstName, String lastName, int accountNum, int balance)
  {
    super(firstName, lastName, accountNum);
    this.balance = balance;     
  }
  /**
   * @return the balance
   */
  public int getBalance()
  {
    return balance;
  }
  /**
   * @param balance the balance to set
   */
  public void setBalance(int balance)
  {
    this.balance = balance;
  }
  
  @Override
  public String toString()
  {
    String output = super.toString() + "balance: " + getBalance(); 
    return output;
  }
}
