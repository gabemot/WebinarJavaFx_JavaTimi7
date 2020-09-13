package ro.sda;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Starting app");

        // helloJavaFx(stage);
        // twoColumns(stage);
        // gridPaneExample(stage);
        // textPropertiesBidiBind(stage);
        // slidingLabels(stage);

        VBox root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);


        stage.show(); // lift curtain
    }

    private void slidingLabels(Stage stage) {
        Slider slider = new Slider();
        Label label = new Label("ceva");
        Label anotherLabel = new Label("altceva");

        VBox vbox = new VBox();
        vbox.getChildren().add(slider);
        vbox.getChildren().add(label);
        vbox.getChildren().add(anotherLabel);

        vbox.spacingProperty().bind(slider.valueProperty());

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);
    }

    private void textPropertiesBidiBind(Stage stage) {
        TextField textField = new TextField();
        Label label = new Label();
        textField.textProperty().bindBidirectional(label.textProperty());

        VBox vBox = new VBox();
        vBox.getChildren().add(textField);
        vBox.getChildren().add(label);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
    }

    private void gridPaneExample(Stage stage) {
        GridPane root = new GridPane();
        root.add(new Label("Element 1,1"), 0 ,0);
        root.add(new TextField("Element 1,2"), 1, 0);
        root.add(new TextField("Element 2,1"), 0, 1);
        root.add(new Label("Element 2,2"), 1, 1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void twoColumns(Stage stage) {
        VBox column1 = new VBox();
        column1.getChildren().add(new Label("Element 1,1"));
        column1.getChildren().add(new TextField("Element 1,2"));

        VBox column2 = new VBox();
        column2.getChildren().add(new TextField("Element 2,1"));
        column2.getChildren().add(new Label("Element 2,2"));

        HBox root = new HBox();
        root.getChildren().add(column1);
        root.getChildren().add(column2);
        root.setSpacing(10);

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void helloJavaFx(Stage stage) {
        VBox vBox = new VBox();
        Label label = new Label("Hello JavaFX!");
        vBox.getChildren().add(label);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(); // start lifecycle
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stopping app");
    }

    @Override
    public void init() throws Exception {
        System.out.println("Initializing app");
    }
}
