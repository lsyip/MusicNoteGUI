import java.util.ArrayList;

public class ComparableDriver {
    public static void main(String[] args) {
        Note note1 = new Note();
        Note note2 = new Note("whole", 1);
        Note note3 = new Note("half", -1);

        //ArrayList of Notes
        ArrayList<Note> noteList = new ArrayList<>();
        noteList.add(note1);
        noteList.add(note2);
        noteList.add(note3);

        for (Note note : noteList) {
            int result = note.compareTo(note1);

            if (result < 0) {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) + " is lower than " + note1.computeName(note1.getNoteValue()) + note1.computeFrequency(note1.getNoteValue()));
            } else if (result > 0) {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) + " is higher than " + note1.computeName(note1.getNoteValue()) + note1.computeFrequency(note1.getNoteValue()));
            }
            else {
                System.out.println(note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue()) + " is equal to " + note1.computeName(note1.getNoteValue()) + note1.computeFrequency(note1.getNoteValue()));
            }
        }

    }
}
