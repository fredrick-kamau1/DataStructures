package lists;

public class ListTester {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    AArrayList<String> al = new AArrayList<String>();
    System.out.println("Empty? " + al.isEmpty());
    al.add("One");
    System.out.println("Empty? " + al.isEmpty());
  }

}
