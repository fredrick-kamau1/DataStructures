package oobasics;

/**
 * @author Fredrick Kamau
 */
public class VideoTester {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // Create two video objects
    Video video1 = new Video("ER", "AB501", "Paul Short", "Universal");
    Video video2 = new Video("Hero", "HE6541", "Kiko", "Warner bros");

    // Display value of the created video objects
    System.out.println(video1);
    System.out.println(video2);

    // Set a new producer for each of the objects
    video1.setProducer("Harry Man");
    video2.setProducer("Cecile Paul");
    System.out.println();

    // Display new producer values
    System.out.println("New Producer: " + video1.getProducer());
    System.out.println("New Producer: " + video2.getProducer());

    // Set a new studio for each of the objects
    video1.setStudio("Marvel");
    video2.setStudio("DC");
    System.out.println();

    // Display new studio values
    System.out.println("New Studio: " + video1.getStudio());
    System.out.println("New Studio: " + video2.getStudio());
    System.out.println();

    // Checkout video1
    video1.checkOut();
    System.out.println("Video checkout: " + video1.isCheckedOut());
    System.out.println();

    // Return video1
    video1.returnItem();
    System.out.println("Video checkout: " + video1.isCheckedOut());

  }
}
