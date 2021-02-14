import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage stage) {
        String message = "Hello, World!";
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Button button = new Button("Click me!");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                l.setText(message);
            }
        });
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 640, 480);
        pane.getChildren().add(l);
        pane.getChildren().add(button);
        button.setTranslateY(40);

        stage.setScene(scene);
        stage.show();
    }
}

