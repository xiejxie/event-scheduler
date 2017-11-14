package frontEnd;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * Base controller class
 *
 */
public abstract class Controller {
	Scene currentScene;
	/**
	 * Produce the Scene object from an FXML file
	 * For child implementation use ONLY
	 * @param location	relative path to the location of the FXML file
	 * @return			the Scene object representation of the FXML
	 */
	protected Scene getScene(String location) {
		try {
			FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(MainApp.class.getResource(location));
        	Scene scene = new Scene(loader.load(), 1000, 600);
        	currentScene = scene;
        	return scene;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Encapsulated version of returning a scene object
	 * @return
	 */
	public abstract Scene getScene();
}
