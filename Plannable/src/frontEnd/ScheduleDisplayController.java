package frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

/**
 * Controller class for calendarDisplay.fxml - the screen where you see your schedule output
 *
 */
public class ScheduleDisplayController extends Controller {
	
	/**
	 * The graphic representation of the grayed out schedule grid
	 */
	@FXML
	BorderPane rootNode;
	
	@FXML
	Button restartButton;
	
	/**
	 * The code representation of the grayed out schedule grid
	 */
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	Node root;
	/**
	 * Set up the schedule grid
	 */
	@FXML
	public void initialize() {
		rootNode.setCenter(MainApp.getScheduleGridDisplay());
		 //rootNode.setCenter(MainApp.getScheduleGridDisplay());
		restartButton.setOnMousePressed((MouseEvent e) -> restart(e));
	}
	
	/**
	 * Return a scene object that this class controls
	 */
	public Scene getScene() {
		return this.getScene("./ScheduleDisplay.fxml");
	}
	
	/**
	 * Click back to the schedule select screen
	 * @param e
	 */
	public void restart(MouseEvent e) {
		MainApp.switchScene("ScheduleSelect");
	}
}
