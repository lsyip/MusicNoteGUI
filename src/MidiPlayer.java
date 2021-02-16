import javax.sound.midi.*;

// The MidiPlayer class structure was copied from this YouTube video by Makai Smith (digiplasty on YouTube):
// https://youtu.be/lhcVdnQ_R1U

/**
 * @author Makai Smith (digiplasty on YouTube)
 * @author Lynn Yip
 */
public class MidiPlayer {

    static Note note = new Note();
    static Synthesizer synth;

    //TryCatch outside a method reference (StackOverflow): https://tinyurl.com/b5437kvm
    static { //static initializer block used for synth because it throws an exception
        try {
            synth = MidiSystem.getSynthesizer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    static int noteValue = note.getNoteValue();

    static MidiChannel[] midiChannel = synth.getChannels(); //create midi channel to play notes

    //default constructor

    /**
     * Class constructor
     */
    public MidiPlayer() {
    }

    /**
     * Plays A440, the standard string orchestral tuning note.
     */
    public static void playTuningNote() {
        noteValue = 0;
        note.setNoteValue(noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    /**
     * Plays the note a half step higher than the current note.
     */
    public static void playHigher() {
        note.setNoteValue(++noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    /**
     * Plays the note a half step lower than the current note.
     */
    public static void playLower() {
        note.setNoteValue(--noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    /**
     * Plays the note a perfect fifth above the current note.
     */
    public static void playUpFifth() {
        noteValue += 7;
        note.setNoteValue(noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    /**
     * Plays the note a perfect fifth below the current note.
     */
    public static void playDownFifth() {
        noteValue -= 7;
        note.setNoteValue(noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    /**
     * Stops all currently playing notes.
     */
    public static void stopNote() {
        midiChannel[0].allNotesOff();
    }

    /**
     * Returns a string with the current note name and frequency.
     * @return The note name and frequency as a string.
     */
    public static String getNoteText() {
        return note.computeName(note.getNoteValue()) + String.format("%.2f", note.computeFrequency(note.getNoteValue()));
    }

}
