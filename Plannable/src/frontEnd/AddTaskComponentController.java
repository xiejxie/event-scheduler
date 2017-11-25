package frontEnd;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class AddTaskComponentController {
	@FXML
	ChoiceBox<String> cb;
	
	public void initialize() {
		System.out.println("SLDKFJKL");
		addItems();
	}
	
	private void addItems() {
		System.out.println("SLDKFJ");
		cb.setItems(FXCollections.observableArrayList("12AM - 6AM", "6AM - 12PM", "12PM - 6PM", "6PM - 12AM"));
	}

}
