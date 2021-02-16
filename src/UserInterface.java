import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.midi.MidiUnavailableException;

// YouTube tutorial used for JavaFX help: https://youtu.be/9MfRPVxTde8
// JavaFX 12 Tutorial by Kody Simpson

/**
 * @author Kody Simpson - setting up JavaFX stage and button action event code
 */
public class UserInterface extends Application {

    /**
     * Opens a synthesizer before the app opens.
     * @throws MidiUnavailableException if midi component cannot be opened
     */
    @Override
    public void init() throws MidiUnavailableException { //This method is used to load images or any other materials before the app is launched
        MidiPlayer.synth.open(); //loads up the synth before the app is opened so we only have to open it once
    }

    /**
     * Sets up the JavaFX window
     */
    @Override
    public void start(Stage stage) { //sets up JavaFX GUI
        stage.setTitle("Music Note Picker"); //sets window title

        Label l = new Label("Notes"); //label to display note name and frequency
        l.setFont(new Font("Times New Roman", 32));
        l.setTranslateX(50);
        l.setTranslateY(75);

        //buttons
        Button tuningNote = new Button("Tuning Note");
        Button buttonHi = new Button("Higher");
        Button buttonLow = new Button("Lower");
        Button buttonUpFifth = new Button("Perfect Fifth Up");
        Button buttonDownFifth = new Button("Perfect Fifth Down");

        //moving things around
        tuningNote.setTranslateX(300);
        buttonHi.setTranslateX(300);
        buttonLow.setTranslateX(300);
        buttonUpFifth.setTranslateX(300);
        buttonDownFifth.setTranslateX(300);

        tuningNote.setOnAction(actionEvent -> {  //EventHandler replaced with lambda
            try {
                MidiPlayer.stopNote();
                MidiPlayer.playTuningNote();
                l.setText(MidiPlayer.getNoteText());
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        });

        buttonHi.setOnAction(actionEvent -> {
            try {
                MidiPlayer.stopNote();
                MidiPlayer.playHigher();
                l.setText(MidiPlayer.getNoteText());
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        });

        buttonLow.setOnAction(actionEvent -> {
            try {
                MidiPlayer.stopNote();
                MidiPlayer.playLower();
                l.setText(MidiPlayer.getNoteText());
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        });

        buttonUpFifth.setOnAction(actionEvent -> {
            try {
                MidiPlayer.stopNote();
                MidiPlayer.playUpFifth();
                l.setText(MidiPlayer.getNoteText());
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        });

        buttonDownFifth.setOnAction(actionEvent -> {
            try {
                MidiPlayer.stopNote();
                MidiPlayer.playDownFifth();
                l.setText(MidiPlayer.getNoteText());
            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }
        });
        VBox root = new VBox(); //VBox root displays elements vertically
        Scene scene = new Scene(root, 500, 250); //set Vbox as root of the scene
        root.getChildren().addAll(l, tuningNote, buttonHi, buttonLow, buttonUpFifth, buttonDownFifth); //add buttons and labels

        stage.setScene(scene); //put it all together
        stage.show(); //make it visible
    }

    /**
     * Closes synthesizer when application is closed.
     */
    @Override
    public void stop() { //Runs after the app is closed
        MidiPlayer.synth.close();
    }
}

