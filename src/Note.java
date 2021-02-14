import java.lang.Math; //for pow() and log() methods
import java.util.ArrayList;
import java.util.Arrays; //for binarySearch() method

/**
*   
* @author Lynn Yip
*/
public class Note {
   
   //DATA
   private String length; //the duration of the note
   private int noteValue; //the integer conversion of the note (A440 = 0)
   
   //array of note names is used in the computeName method.
   private static final ArrayList<String> CHROMATIC_SCALE = new ArrayList<>(Arrays.asList("A", "A#", "B", "C",
                                                                                          "C#", "D", "D#", "E",
                                                                                          "F", "F#", "G", "G#"));
                                                  
   //METHODS
   //constructors
   
   /**
   *   Class constructor.
   */
   public Note() { //default: A440 quarter note
      this.length = "quarter";
      this.noteValue = 0;
   }
   
   /**
   *   Class constructor specifying the note length and note value.
   *   @param length The note duration
   *   @param noteValue The integer note conversion where A440 = 0
   */
   // Learned IllegalArgumentException from this video: https://youtu.be/JJL2gFV_CrY
   public Note(String length, int noteValue) {
      String temp = length.toLowerCase();
      ArrayList<String> noteLengths = new ArrayList<>(Arrays.asList("whole", "half", "quarter", "eighth", "sixteenth"));
      if (!noteLengths.contains(temp)){
         throw new IllegalArgumentException("Length can be whole, half, quarter, eighth, or sixteenth.");
      }
      if (noteValue > 44 || noteValue < -44) {
         throw new IllegalArgumentException("Note value should be between -44 and 44");
      }
      this.length = length;
      this.noteValue = noteValue;
   }
   
   //getters
   /**
   *   Retrieves the note length
   *   @return The duration of the note.
   */
   public String getLength () {
      return length;
   }
   
   /**
   *   Retrieves the note value
   *   @return The integer conversion of the note, where A440 = 0.
   */
   public int getNoteValue() {
      return noteValue;
   }

   //setters
   /**
   *   Sets the note duration
   *   @param length The duration of the note.
   */
   public void setLength(String length) {
      String temp = length.toLowerCase();
      ArrayList<String> noteLengths = new ArrayList<>(Arrays.asList("whole", "half", "quarter", "eighth", "sixteenth"));
      if (!noteLengths.contains(temp)){
         throw new IllegalArgumentException("Length can be whole, half, quarter, eighth, or sixteenth.");
      }
         this.length = temp;
   }
   
   /**
   *   Sets the note value
   *   @param noteValue The integer conversion of the note, where A440 = 0.
   */
   public void setNoteValue(int noteValue) {
      if(noteValue > 44 || noteValue < -44) {
         throw new IllegalArgumentException("Note value should be value between -44 and 44");
      }
      this.noteValue = noteValue;
   }
   
   //toString
   /**
   *   Prints the note data to the console. 
   *   @return A string describing the note.
   */
   public String toString() {
      return "This note is " + computeName(noteValue) + String.format("%.2f", computeFrequency(noteValue)) + ". It is a "
              + length + " note and a " + computeStatus(noteValue)+ ". " +
              "Its integer value is " + noteValue;
   }
   
   //other methods
   /**
   *   Determines the letter name of the note given an integer note value.
   *   @param noteValue The integer note value
   *   @return The letter name of the note.
   */
   public String computeName(int noteValue) {
      int index; 
      if(noteValue >= 0) { //if positive integer
         index = noteValue % 12; //find the remainder when divided by 12 (number of scale notes)
         return CHROMATIC_SCALE.get(index); //returns letter name from the array
      }
      else { //if negative integer
         index = noteValue;
         while(index < 0) { //while int is negative, increment by 12
            index += 12;
         }
         return CHROMATIC_SCALE.get(index % 12); //return letter name from array
      }
   }
   
   /**
   *   Computes the frequency of the note given the integer note value.
   *   @param noteValue The integer note value
   *   @return The frequency in hz.
   */
   public double computeFrequency(int noteValue) {
      //The formula for frequency in hz is 440 * 2^(n/12)
      // where n is equal to the integer note conversion A440 = 0.
      return 440 * Math.pow(2.0, (noteValue/12.0));
   }
   
   /**
   *   Determines if the note is on a black or white key. 
   *   @param noteValue The integer note value
   *   @return A string describing the note status.
   */
   public String computeStatus(int noteValue) {
      int index;
      //This array contains the index at which the keys in a chromatic scale fall 
      // on a black key. 
      final int[] blackKeyIndex = new int[]{1, 4, 6, 9, 11};

      if (noteValue >= 0) {
         index = noteValue % 12;
      }
      else { //if negative
         int tempValue = noteValue;
         while (tempValue < 0){
            tempValue += 12;
         }
         index = tempValue % 12;
      }

      if (Arrays.binarySearch(blackKeyIndex,index) >= 0) {
         return "sharp/black key";
      }
      else {
         return "natural/white key";
      }
   }
} //end of class