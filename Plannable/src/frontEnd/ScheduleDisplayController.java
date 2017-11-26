package frontEnd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Controller class for calendarDisplay.fxml - the screen where you see your schedule output
 *
 */
public class ScheduleDisplayController extends Controller {
	
	/**
	 * The graphic representation of the grayed out schedule grid
	 */
	@FXML
	BorderPane rootNode;
	
	@FXML
	Button restartButton;
	
	@FXML
	Button printButton;
	
	Node grid;
	
	/**
	 * The code representation of the grayed out schedule grid
	 */
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	/**
	 * Set up the schedule grid
	 */
	@FXML
	public void initialize() {
		grid = MainApp.getScheduleGridDisplay();
		rootNode.setCenter(grid);
		rootNode.setLeft(MainApp.getScheduleGridInformation());
		stampTimes();
		 //rootNode.setCenter(MainApp.getScheduleGridDisplay());
		restartButton.setOnMousePressed((MouseEvent e) -> restart(e));
		printButton.setOnMouseClicked((MouseEvent e) -> print());
	}
	
	private void stampTimes() {
		Set<String> textRepresentation = new HashSet<String>();
		System.out.println("LSKJFLKSDJFLKSDJF"+textRepresentation.size());
		for (Label l : MainApp.getScheduleGridMap().keySet()) {
			for (Region r : MainApp.getScheduleGridMap().get(l)) {
				textRepresentation.add(GridPane.getRowIndex(r) + " " + GridPane.getColumnIndex(r));
			}
			for (Region r : MainApp.getScheduleGridMap().get(l)) {
				if (!textRepresentation.contains((GridPane.getRowIndex(r)-1) + " " + (GridPane.getColumnIndex(r)))) {
					applyStamp(l, GridPane.getRowIndex(r), GridPane.getColumnIndex(r));
				}
			}
			textRepresentation.clear();
		}
	}
	
	private void applyStamp(Label l, int row, int col) {
		ScrollPane sp = (ScrollPane) ((VBox) grid).getChildren().get(1);
		GridPane gridP = (GridPane) sp.getContent();
		VBox box = new VBox();
		box.setStyle("-fx-padding: 7 7 7 7");
		Label label = new Label(l.getText());
		label.setWrapText(true);
		label.setTextAlignment(TextAlignment.JUSTIFY);
		label.getStyleClass().add("fontBold");
		label.getStyleClass().add("whiteText");
		box.getChildren().add(label);
		box.setAlignment(Pos.BASELINE_CENTER);
		gridP.add(box, col, row);
	}
	
	/**
	 * Return a scene object that this class controls
	 */
	public Scene getScene() {
		return this.getScene("./ScheduleDisplay.fxml");
	}
	
	/**
	 * Click back to the schedule select screen
	 * @param e
	 */
	public void restart(MouseEvent e) {
		MainApp.clearScheduleGridMap();
		MainApp.switchScene("AddTask", true);
	}
	
	public void print() {
		WritableImage image = grid.snapshot(new SnapshotParameters(), null);
		FileChooser fc = new FileChooser();
		File sfile = null;
		while(sfile == null) {
			sfile = fc.showSaveDialog(null);
		}
	    try {
	        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", sfile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
