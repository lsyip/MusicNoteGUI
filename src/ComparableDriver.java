import java.util.ArrayList;
import java.util.Collections;

public class ComparableDriver {
    public static void main(String[] args) {
        Note note1 = new Note();
        Note note2 = new Note("whole", 1);
        Note note3 = new Note("half", -1);
        Note note4 = new Note("half", 2);

        //ArrayList of Notes
        ArrayList<Note> noteList = new ArrayList<>();
        noteList.add(note1);
        noteList.add(note2);
        noteList.add(note3);
        noteList.add(note4);

        System.out.println("Unsorted List");
        for (Note note : noteList) {
            System.out.println(note.computeName(note.getNoteValue()) + ", " + note.getLength() + " note");
        }
        System.out.println();

        System.out.println("Comparable Demo");
        for (Note note : noteList) {
            int result = note.compareTo(note1);

            if (result < 0) {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) +
                        " is lower than " + note1.computeName(note1.getNoteValue()) +
                        note1.computeFrequency(note1.getNoteValue()));
            } else if (result > 0) {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) +
                        " is higher than " + note1.computeName(note1.getNoteValue()) +
                        note1.computeFrequency(note1.getNoteValue()));
            }
            else {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) +
                        " is equal to " + note1.computeName(note1.getNoteValue()) +
                        note1.computeFrequency(note1.getNoteValue()));
            }
        }
        System.out.println();

        System.out.println("Sorted List");
        Collections.sort(noteList);

        for(Note note : noteList) {
            System.out.println(note.computeName(note.getNoteValue()) + ", " + note.getLength() + " note");
        }
        System.out.println();

        //Fancy demo sorts by note length
        System.out.println("Comparable Fancy Demo");
        for (Note note : noteList) {
            int result = note.compareTo(note1);

            if (result < 0) {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) +
                        " is lower than " + note1.computeName(note1.getNoteValue()) +
                        note1.computeFrequency(note1.getNoteValue()));
            } else if (result > 0) {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) +
                        " is higher than " + note1.computeName(note1.getNoteValue()) +
                        note1.computeFrequency(note1.getNoteValue()));
            }
            else {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) +
                        " is equal to " + note1.computeName(note1.getNoteValue()) +
                        note1.computeFrequency(note1.getNoteValue()));

            }
        }
    }
}
