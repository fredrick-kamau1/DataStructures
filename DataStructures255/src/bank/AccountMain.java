package bank;

public class AccountMain
{
  public static void main(String[] args)
  {
    //Abstraction
    Account account1 = new Account("Fred", "Kamau", 123456);
    
    System.out.println("LastName: " + account1.getLastName() + " "+ "Acct#:" + account1.getAccountNum());
    account1.setLastName("Muthee");
    account1.setAccountNum(56789);
    
    System.out.println("LastName: " + account1.getLastName()+ " "+ "Acct#:" + account1.getAccountNum());
    System.out.println(account1.toString());
    
    CheckingAccount account2 = new CheckingAccount("Kyrie","Kama", 988765, 36);
    System.out.println(account2.toString());
    //Show checking type and balance
    
    //Show savings type and balance

  }

}
