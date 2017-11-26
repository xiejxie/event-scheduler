package frontEnd;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddTaskComponentController {
	@FXML
	ChoiceBox<String> difficultyCb;
	
	@FXML
	TextField dueHour;
	
	@FXML
	TextField priority;
	
	public void initialize() {
		addItems();
	}
	
	private void addItems() {
		difficultyCb.setItems(FXCollections.observableArrayList("1 (Easy)", "2", "3", "4", "5 (Hard)"));
		validateTextfields();
	}
	
	private void validateTextfields() {
		dueHour.focusedProperty().addListener((arg0, oldVal, newVal) -> {
			if (!newVal) {
				String text = dueHour.getText();
				if (!text.matches("\\d+") || Integer.parseInt(text) < 0 || Integer.parseInt(text) > 23) {
					dueHour.setText("");
				}
			}
		});
		priority.focusedProperty().addListener((arg0, oldVal, newVal) -> {
			if (!newVal) {
				String text = priority.getText();
				if (!text.matches("\\d+") || Integer.parseInt(text) < 0 || Integer.parseInt(text) > 100) {
					priority.setText("");
				}
			}
		});
	}

}
