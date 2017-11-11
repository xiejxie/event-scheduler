package frontEnd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Node;
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
    private static Map<String, Controller> sceneOrderings = new HashMap<String, Controller>();
    private static Node scheduleGridDisplay;
    private static Set<Controller> controllers = new HashSet<Controller>();
    
    /**
     * Start the application
     */
    @Override
    public void start(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
        MainApp.primaryStage.setTitle("Plannable");
        setUpLayout();
    }
    
    private void newController(Controller c, String name) {
    	controllers.add(c);
    	sceneOrderings.put(name, c);
    }

    /**
     * Initializes the map and sets the initial scene
     */
    public void setUpLayout() {
        ScheduleSelectController csc = new ScheduleSelectController();
        newController(csc, "ScheduleSelect");
        ScheduleDisplayController cdc = new ScheduleDisplayController();
        newController(cdc, "ScheduleDisplay");
        Scene startScene = csc.getScene("./ScheduleSelect.fxml");
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    /**
     * Change from one scene to the next
     * @param key	the key to the sceneOrderings dictionary to return a Scene object
     */
    public static void switchScene(String key) {
    	Controller ctrlr = sceneOrderings.get(key);
    	primaryStage.setScene(ctrlr.getScene());
    }
    
    /**
     * Update the state of the shared schedule grid
     * @param sg	the shared schedule grid
     */
    public static void setScheduleGridDisplay(Node sg) {
    	scheduleGridDisplay = sg;
    }
    
    /**
     * @return	the shared schedule grid
     */
    public static Node getScheduleGridDisplay() {
    	return scheduleGridDisplay;
    }
    
    /**
     * Launch
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
