import javafx.application.Application;

/**
*
*   @author Lynn Yip
*/
public class Driver {

   /**
   *   Demonstrates the use of the Note class.
   *   @param args The command line arguments
   */
   public static void main(String[] args) {

      //https://stackoverflow.com/questions/26905717/not-a-sub-class-error
      //Launches UI
      Application.launch(UserInterface.class, args);

      Note tuningNote = new Note(); //A440
      System.out.println(tuningNote);

      Note newNote = new Note("whole", -13); // -13 = G#
      System.out.println(newNote);
      
      Note middleC = new Note("half", -9); //C
      System.out.println(middleC);
      
      //change the tuningNote
      tuningNote.setLength("Eighth");
      tuningNote.setNoteValue(-6); //-6 = D#

      //Print new notes
      System.out.println("New Notes:");
      System.out.println(tuningNote);
      System.out.println(newNote);
      System.out.println(middleC);
      
   } //end of main

}//end of class