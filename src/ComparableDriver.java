public class ComparableDriver {
    public static void main(String[] args) {
        Note note1 = new Note();
        Note note2 = new Note("whole", 0);

        int result = note1.compareTo(note2);

        if (result < 0) {
            System.out.println(note1.computeName(note1.getNoteValue()) + note1.computeFrequency(note1.getNoteValue()) + " is lower than " + note2.computeName(note2.getNoteValue()) + note2.computeFrequency(note2.getNoteValue()));
        } else if (result > 0) {
            System.out.println(note1.computeName(note1.getNoteValue()) + note1.computeFrequency(note1.getNoteValue()) + " is higher than " + note2.computeName(note2.getNoteValue()) + note2.computeFrequency(note2.getNoteValue()));
        }
        else {
            System.out.println(note1.computeName(note1.getNoteValue()) + note1.computeFrequency(note1.getNoteValue()) + " is equal to " + note2.computeName(note2.getNoteValue()) + note2.computeFrequency(note2.getNoteValue()));
        }
    }
}
