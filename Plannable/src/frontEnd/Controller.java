package frontEnd;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Base controller class
 *
 */
public abstract class Controller {
	
	/**
	 * Produce the Scene object from an FXML file
	 * @param location	relative path to the location of the FXML file
	 * @return			the Scene object representation of the FXML
	 */
	public Scene getScene(String location) {
		try {
			FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(MainApp.class.getResource(location));
        	Scene scene = new Scene(loader.load(), 1200, 800);
        	return scene;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}