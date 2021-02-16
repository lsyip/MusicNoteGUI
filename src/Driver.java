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

<<<<<<< HEAD
      //Reference for UserInterface.class: https://stackoverflow.com/questions/26905717/not-a-sub-class-error
      Application.launch(UserInterface.class, args); //launches UI
=======
      //https://stackoverflow.com/questions/26905717/not-a-sub-class-error
      //Launches UI
      Application.launch(UserInterface.class, args); //call the launch method from the application class, feed it the UserInterface class command line args.
>>>>>>> ae67ef3f673d4ed1e03f779b56ede5ceca51de4b

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