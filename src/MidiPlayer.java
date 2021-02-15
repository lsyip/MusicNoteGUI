import javax.sound.midi.*;

// The MidiPlayer class structure was copied from this YouTube video:
// https://youtu.be/lhcVdnQ_R1U

/**
 * @author Makai Smith (digiplasty on YouTube)
 */

public class MidiPlayer {

    //static int noteValueToPlay = 0;
    static Note note = new Note();
    static Synthesizer synth;
    static int noteValue = note.getNoteValue();

    static {
        try {
            synth = MidiSystem.getSynthesizer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    static MidiChannel[] midiChannel = synth.getChannels();
    //static Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();

    //default constructor
    public MidiPlayer() {
    }

    public static void playTuningNote() throws MidiUnavailableException {
        noteValue = 0;
        note.setNoteValue(noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    public static void playHigher() throws MidiUnavailableException {
        note.setNoteValue(++noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    public static void playLower() throws MidiUnavailableException {
        note.setNoteValue(--noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    public static void playUpFifth() throws MidiUnavailableException {
        noteValue += 7;
        note.setNoteValue(noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    public static void playDownFifth() throws MidiUnavailableException {
        noteValue -= 7;
        note.setNoteValue(noteValue);
        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    public static void stopNote() throws MidiUnavailableException {
        midiChannel[0].allNotesOff();
    }

    public static String getNoteText() {
        return note.computeName(note.getNoteValue()) + String.format("%.2f", note.computeFrequency(note.getNoteValue()));
    }

}
