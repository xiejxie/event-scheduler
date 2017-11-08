package frontEnd;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Information pop up when user does something wrong
 *
 */
public class PopupAlert {
	Alert alert;
	public PopupAlert(char alertType) {
		if (alertType == 'I') {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Action required");
			alert.setHeaderText(null);
			alert.setContentText("The time block textfield should not be blank. Some cells must be selected.");
		}
	}
	/**
	 * Show the alert
	 */
	public void getAlert() {
		alert.showAndWait();
	}
}
