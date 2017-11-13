package frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Controller class for calendarDisplay.fxml - the screen where you see your schedule output
 *
 */
public class AddTaskController extends Controller {
	
	/**
	 * The graphic representation of the grayed out schedule grid
	 */
	@FXML
	GridPane scheduleGrid;
	
	@FXML
	VBox inputRow;
	
	@FXML
	HBox inputBox;
	
	@FXML
	HBox addNewBox;
	
	@FXML
	Button nextButton;
	
	/**
	 * The code representation of the grayed out schedule grid
	 */
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	
	/**
	 * Set up the schedule grid
	 */
	@FXML
	public void initialize() {
		
	}
	
	/**
	 * Click back to the calendar select screen
	 * @param e
	 */
	public void handleOnMouseClickedBack(MouseEvent e) {
		MainApp.switchScene("CalendarDisplayControllerBack");
	}
}
