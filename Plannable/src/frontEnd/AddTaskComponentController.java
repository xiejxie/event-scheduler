package frontEnd;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddTaskComponentController {
	@FXML
	ChoiceBox<String> difficultyCb;
	
	@FXML
	ChoiceBox<String> priority;
	
	@FXML
	TextField weighting;
	
	public void initialize() {
		addItems();
	}
	
	private void addItems() {
		difficultyCb.setItems(FXCollections.observableArrayList("1 (Easy)", "2", "3", "4", "5 (Hard)"));
		priority.setItems(FXCollections.observableArrayList("1 (Low)", "2", "3", "4", "5 (High)"));
		validateTextfields();
	}
	
	private void validateTextfields() {
		weighting.focusedProperty().addListener((arg0, oldVal, newVal) -> {
			if (!newVal) {
				String text = weighting.getText();
				if (!text.matches("\\d+") || Integer.parseInt(text) < 0 || Integer.parseInt(text) > 100) {
					weighting.setText("");
				}
			}
		});
	}

}
