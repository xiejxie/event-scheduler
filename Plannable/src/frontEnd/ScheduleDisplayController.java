package frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * Controller class for calendarDisplay.fxml - the screen where you see your schedule output
 *
 */
public class ScheduleDisplayController extends Controller {
	
	/**
	 * The graphic representation of the grayed out schedule grid
	 */
	@FXML
	GridPane scheduleGrid;
	
	/**
	 * The code representation of the grayed out schedule grid
	 */
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	
	/**
	 * Set up the schedule grid
	 */
	@FXML
	public void initialize() {
		 for (int x = 1 ; x < 8; x++) {
		        for (int y = 1 ; y < 48 ; y++) {
		            Region cell = new Region();
		            scheduleGrid.getChildren().add(cell);
		            cell.getStyleClass().add("inactiveCell");
		            cell.setOnMouseEntered((MouseEvent e) -> ScheduleSelectController.handleMouseEntered(e, this.sortByRows));
		            cell.setOnMouseExited((MouseEvent e) -> ScheduleSelectController.handleMouseExited(e, this.sortByRows));
		            
		            if (sortByRows.containsKey(y)) {
		            	sortByRows.get(y).add(cell);
		            } else {
		            	ArrayList<Region> newList = new ArrayList<Region>();
		            	newList.add(cell);
		            	sortByRows.put(y, newList);
		            }		            
		            GridPane.setColumnIndex(cell, x);
		            GridPane.setRowIndex(cell, y);
		        }
		    }
	}
	
	/**
	 * Click back to the calendar select screen
	 * @param e
	 */
	public void handleOnMouseClickedBack(MouseEvent e) {
		MainApp.switchScene("CalendarDisplayControllerBack");
	}
}
