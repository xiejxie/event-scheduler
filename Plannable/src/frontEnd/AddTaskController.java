package frontEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	
	@FXML
	TextField addNewTextField;
	
	@FXML
	Button addNew;
	
	/**
	 * The code representation of the grayed out schedule grid
	 */
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	
	/**
	 * Set up the schedule grid
	 */
	@FXML
	public void initialize() {
		nextButton.setOnMouseClicked((MouseEvent e) -> goNext(e));
		addNew.setOnMouseClicked((MouseEvent e) -> addBox());
		addBox();
	}
	
	public void addBox() {
		HBox component = null;
		try {
			FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(MainApp.class.getResource("./AddTaskComponent.fxml"));
        	component = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		inputRow.getChildren().add(component);
		Button rmButton = (Button) component.getChildren().get(component.getChildren().size()-1);
		int index = inputRow.getChildren().indexOf(component);
		rmButton.setOnMouseClicked((MouseEvent e) -> removeBox(index));
	}
	
	public void removeBox(int index) {
		inputRow.getChildren().remove(index);
	}
	
	/**
	 * Click back to the calendar select screen
	 * @param e
	 */
	public void goNext(MouseEvent e) {
		MainApp.switchScene("ScheduleSelect", false);
	}

	@Override
	public Scene getScene() {
		return this.getScene("./AddTask.fxml");
	}
}
