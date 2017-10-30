package frontEnd;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	/**
	 * The window for the application
	 */
    private static Stage primaryStage;
    /**
     * Maps a key (currently of the format: <<NameofCallingClass>>+<<NameofButtonBeingCalled>>)
     * to a Scene object. It's objective is to organize the paths between different scenes.
     */
    private static Map<String, Scene> sceneOrderings = new HashMap<String, Scene>();
    
    /**
     * Start the application
     */
    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        MainApp.primaryStage.setTitle("Plannable");
        setUpLayout();
    }

    /**
     * Initializes the map and sets the initial scene
     */
    public void setUpLayout() {
        ScheduleSelectController csc = new ScheduleSelectController();
        ScheduleDisplayController cdc = new ScheduleDisplayController();
        sceneOrderings.put("CalendarSelectControllerNext", cdc.getScene("./ScheduleDisplay.fxml"));
        
        Scene startScene = csc.getScene("./ScheduleSelect.fxml");
        sceneOrderings.put("CalendarDisplayControllerBack", startScene);
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    /**
     * Change from one scene to the next
     * @param key	the key to the sceneOrderings dictionary to return a Scene object
     */
    public static void switchScene(String key) {
    	Scene nextScene = sceneOrderings.get(key);
    	primaryStage.setScene(nextScene);
    }
    
    /**
     * Launch
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
