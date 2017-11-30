package frontEnd;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import api.Api;
import backEnd.WeeklyCalendar;
import backEnd.tasks.StudyTimeTask;
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
import javafx.stage.FileChooser;

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
	
	static Node grid;
	
	static Set<Region> studyTimes = new HashSet<Region>();
	
	/**
	 * The code representation of the grayed out schedule grid
	 */
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	/**
	 * Set up the schedule grid
	 */
	@FXML
	public void initialize() {
		// Node grid = MainApp.getScheduleDisplay();
		// MainApp.ge
		grid = MainApp.getScheduleGridDisplay();
		placeStudy();
		rootNode.setCenter(grid);
		rootNode.setLeft(MainApp.getScheduleGridInformation());
		stampTimes();
		 //rootNode.setCenter(MainApp.getScheduleGridDisplay());
		restartButton.setOnMousePressed((MouseEvent e) -> restart(e));
		printButton.setOnMouseClicked((MouseEvent e) -> print());
		System.out.println(getStudyTimes());
	}
	
	private void stampTimes() {
		Set<String> textRepresentation = new HashSet<String>();
		for (Label l : MainApp.getScheduleGridMap().keySet()) {
			for (Region r : MainApp.getScheduleGridMap().get(l)) {
				if (r.getId().equals("4")) {
					studyTimes.add(r);
				}
				textRepresentation.add(GridPane.getRowIndex(r) + " " + GridPane.getColumnIndex(r));
			}
			for (Region r : MainApp.getScheduleGridMap().get(l)) {
				if (!textRepresentation.contains((GridPane.getRowIndex(r)-1) + " " + (GridPane.getColumnIndex(r)))) {
					if (!r.getId().equals("4")) applyStamp(l, GridPane.getRowIndex(r), GridPane.getColumnIndex(r));
				}
			}
			textRepresentation.clear();
		}
	}
	
	public static Set<Region> getStudyTimes() {
		return studyTimes;
	}
	
	public static void applyStamp(Label l, int row, int col) {
		ScrollPane sp = (ScrollPane) ((VBox) grid).getChildren().get(1);
		GridPane gridP = (GridPane) sp.getContent();
		VBox box = new VBox();
		box.setStyle("-fx-padding: 7 7 7 7");
		Label label = new Label(l.getText());
		label.setWrapText(true);
		label.setTextAlignment(TextAlignment.JUSTIFY);
		label.getStyleClass().add("fontBold");
		//label.getStyleClass().add("whiteText");
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
		studyTimes.clear();
		Api.clearCal();
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
	
	private void placeStudy() {
		WeeklyCalendar w = Api.getCal();
		System.out.println(w.toString());
		Map<Integer, String> record = new HashMap<Integer, String>();
		for(int i = 0; i < w.getStudyTimes().size(); i++) {
			record.clear();
			System.out.println(w.getStudyTimes().get(i));
			for(StudyTimeTask t : w.getStudyTimes().get(i)) {
				LocalTime curr = t.getStartTime();
				Iterator<String> keys = t.getWorkKeys().iterator();
				int hourCount = -1;
				while(curr.isBefore(t.getEndTime()) || t.getEndTime().equals(curr)){
					int row = curr.getHour() * 2;
					row = curr.getMinute() == 0 ? row : row + 1;
					hourCount++;
					System.out.printf("row: %d\t\tcol: %d\n", row, i + 1);
					String prevL = record.get(row-1);
					record.put(row, t.getName());
					//System.out.println("Comparing " + prevL + " and " + t.getName());
					String newName = "";
					if(keys.hasNext() && hourCount % 2 == 0) {
						newName = keys.next();
					}
					if (prevL == null || !prevL.equals(newName)) {
						if(t.getWorkKeys().size() == 0 && hourCount == 0) {
							applyStamp(new Label("Study"), row, i + 1);
						} else if(newName != "") {
							applyStamp(new Label(newName), row, i + 1);
						}
					}
					curr = curr.plusMinutes(30);
				}
			}
		}
	}
}
