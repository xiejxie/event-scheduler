package frontEnd;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import api.Api;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
		
		for(int i = 0; i < size; i++) {
			String name = ((TextField)((VBox)(((HBox)inputRow.getChildren().get(i)).getChildren().get(0))).getChildren().get(1)).getText();
			String date = ((TextField)((DatePicker)((VBox)(((HBox)inputRow.getChildren().get(i)).getChildren().get(1))).getChildren().get(1)).getChildrenUnmodifiable().get(1)).getText();
			String hour = ((TextField)((VBox)(((HBox)inputRow.getChildren().get(i)).getChildren().get(2))).getChildren().get(1)).getText();
			String toFinish = ((TextField)((VBox)(((HBox)inputRow.getChildren().get(i)).getChildren().get(3))).getChildren().get(1)).getText();
			String difficulty = ((Label)((ChoiceBox)(((VBox)(((HBox)inputRow.getChildren().get(i)).getChildren().get(4))).getChildren().get(1))).getChildrenUnmodifiable().get(0)).getText();
			String weight = ((TextField)((VBox)(((HBox)inputRow.getChildren().get(i)).getChildren().get(5))).getChildren().get(1)).getText();
			
			difficulty = difficulty.substring(0, 1);
			
			Api.sendTODOToCal(
					name, 
					date, 
					Integer.parseInt(hour), 
					Integer.parseInt(toFinish), 
					Integer.parseInt(difficulty), 
					Integer.parseInt(weight));
		}
		
		MainApp.switchScene("ScheduleSelect", false);
	}

	@Override
	public Scene getScene() {
		return this.getScene("./AddTask.fxml");
	}
}
