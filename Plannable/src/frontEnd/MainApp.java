package frontEnd;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Plannable");

        setUpLayout();
    }

    /**
     * Initializes the root layout.
     * 
     */
    public void setUpLayout() {
        rootLayout = new BorderPane();
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("./calendarSelect.fxml"));
        rootLayout = (BorderPane) loader.load();
        Scene scene = new Scene(rootLayout, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        calendarSelectController csc = new calendarSelectController();
        } catch (IOException e) {
        	e.printStackTrace();
        } 
    }
    
    /**
     * Switch scenes
     */
    public void switchScenes(Scene nextScene) {
    	primaryStage.setScene(nextScene);
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
