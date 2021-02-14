import javax.sound.midi.*;

// The MidiPlayer class structure was copied from this YouTube video from a former CIS111B student
// https://youtu.be/lhcVdnQ_R1U

public class MidiPlayer {

    //static int noteValueToPlay = 0;
    static Note note = new Note();

    public static void playNote() throws MidiUnavailableException {
        Synthesizer synth = MidiSystem.getSynthesizer();
        long startTime = System.nanoTime();
        synth.open();
        long estimatedTime = System.nanoTime() - startTime;

        MidiChannel[] midiChannel = synth.getChannels();
        Instrument[] instrument = synth.getDefaultSoundbank().getInstruments();
        boolean successLoadingInstrument = synth.loadInstrument(instrument[0]);

        //note.setNoteValue(noteValueToPlay);

        midiChannel[0].noteOn(note.getMidiNoteNumber(note.getNoteValue()), 100);
    }

    public static String getNoteText() {
        return note.computeName(note.getNoteValue()) + note.computeFrequency(note.getNoteValue());
    }
}
