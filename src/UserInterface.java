import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.midi.MidiUnavailableException;

public class UserInterface extends Application {

    @Override
    public void init() { //This method is used to load images or any other materials before the app is launched
        System.out.println("Before");
    }
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello, Music");

        String message = "";
        Label l = new Label("Play the tuning note!");
        Button button = new Button("Click me!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    MidiPlayer.playNote();
                    l.setText(MidiPlayer.getNoteText());
                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
        VBox root = new VBox();
        Scene scene = new Scene(root, 500, 500);
        root.getChildren().addAll(l, button);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() { //Runs after the app is closed
        System.out.println("After");
    }
}

