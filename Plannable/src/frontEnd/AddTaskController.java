package frontEnd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import api.Api;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
		rmButton.setOnMouseClicked((MouseEvent e) -> removeBox(rmButton));
	}
	
	public void removeBox(Button index) {
		Node parent = index.getParent();
		inputRow.getChildren().remove(inputRow.getChildren().indexOf(parent));
	}
	
	/**
	 * Click back to the calendar select screen
	 * @param e
	 */
	public void goNext(MouseEvent e) {
		int size = inputRow.getChildren().size();
		Set<Map<String, String>> allInputs = new HashSet<Map<String, String>>();
		// Extract all information and put it inside a map
		for(int i = 0; i < size; i++) {
			Map<String, String> inputCollection = new HashMap<String, String>();
			setValue("#taskName", i, inputCollection);
			setValue("#dueDate", i, inputCollection);
			setValue("#priority", i, inputCollection);
			setValue("#estHours", i, inputCollection);
			setValue("#difficulty", i, inputCollection);
			setValue("#weighting", i, inputCollection);
			for (String input : inputCollection.values()) {
				if (input == null || input.isEmpty()) {
					return;
				}
			}
			allInputs.add(inputCollection);
		}
		// Check that no fields are blank
		for (Map<String, String> input : allInputs) {
		Api.sendTODOToCal(
				input.get("#taskName"), 
				input.get("#dueDate"), 
				Integer.parseInt(input.get("#priority")), 
				Integer.parseInt(input.get("#estHours")), 
				Integer.parseInt(input.get("#difficulty")), 
				Integer.parseInt(input.get("#weighting")));
		}
		MainApp.switchScene("ScheduleSelect", false);
	}
	
	/**
	 * Extract information from the javafx fields
	 * @param id			the identifying information
	 * @param row			the row number of inputRow
	 * @param collection	the map to add it to
	 * @return
	 */
	private void setValue(String id, int row, Map<String, String> collection) {
		Node node = inputRow.getChildren().get(row).lookup(id);
		String result = null;
		if (node instanceof TextField) {
			result = ((TextField) node).getText();
		} else if (node instanceof ChoiceBox) {
			ChoiceBox<String> cb = (ChoiceBox<String>) node;
			result = cb.getValue() == null ? cb.getValue() : cb.getValue().substring(0, 1);
		} else if (node instanceof DatePicker) {
			result = ((TextField)((DatePicker) node).getChildrenUnmodifiable().get(1)).getText();
		}
		collection.put(id, result);
	}

	@Override
	public Scene getScene() {
		return this.getScene("./AddTask.fxml");
	}
}
