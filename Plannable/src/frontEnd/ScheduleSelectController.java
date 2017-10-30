package frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * Controller class for calendarSelect.fxml - the screen where you select your free time inputs
 *
 */
public class ScheduleSelectController extends Controller {
	Set<Region> blockedTimes = new HashSet<Region>(); //Selected times
	final static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	//Code representation of the grayed in cells
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	
	@FXML
	GridPane scheduleGrid; //The grayed in region holding individual time slots
	
	/**
	 * Set up
	 */
	@FXML
	public void initialize() {
		 for (int x = 1 ; x < 8; x++) {
		        for (int y = 1 ; y < 24 ; y++) {
		            Region cell = new Region();
		            scheduleGrid.getChildren().add(cell);
		            cell.getStyleClass().add("inactiveCell");
		            cell.setOnDragDetected((MouseEvent e) -> handleOnDragEntered(e));
		            cell.setOnMousePressed((MouseEvent e) -> handleDragAndClick(e));
		            cell.setOnMouseDragEntered((MouseEvent e) -> handleDragAndClick(e));
		            cell.setOnMouseEntered((MouseEvent e) -> handleMouseEntered(e, this.sortByRows));
		            cell.setOnMouseExited((MouseEvent e) -> handleMouseExited(e, this.sortByRows));
		            
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
	
	// Event handlers
	
	public void handleOnDragEntered(MouseEvent e) {
		Node source = (Node) e.getSource();
        source.startFullDrag();
	}
	
	public static void handleMouseEntered(MouseEvent e, Map<Integer, ArrayList<Region>> sortByRows) {
		Node source = (Node)e.getSource();
		int rowIndex = GridPane.getRowIndex(source);
		ArrayList<Region> row = sortByRows.get(rowIndex);
		for (int i = 0; i < GridPane.getColumnIndex(source); i++) {
			row.get(i).getStyleClass().add("activeRow");
		}
	}
	
	public static void handleMouseExited(MouseEvent e, Map<Integer, ArrayList<Region>> sortByRows) {
		Node source = (Node)e.getSource();
		int rowIndex = GridPane.getRowIndex(source);
		ArrayList<Region> row = sortByRows.get(rowIndex);
		for (int i = 0; i < GridPane.getColumnIndex(source); i++) {
			row.get(i).getStyleClass().remove("activeRow");
		}
	}
	
	public void handleDragAndClick(MouseEvent e) {
		if (e.getButton().toString().equals("PRIMARY")) {
			Node source = (Node)e.getSource();
			((Region) source).getStyleClass().remove("inactiveCell");
			((Region) source).getStyleClass().add("activeCell");
			blockedTimes.add((Region) source);
	        System.out.println(GridPane.getRowIndex(source)+" "+GridPane.getColumnIndex(source));
		} else {
			Node source = (Node)e.getSource();
			((Region) source).getStyleClass().add("inactiveCell");
			((Region) source).getStyleClass().remove("activeCell");
			blockedTimes.remove((Region) source);
	        System.out.println(GridPane.getRowIndex(source)+" "+GridPane.getColumnIndex(source));
		}
	}
	
	public void handleOnMouseClicked(MouseEvent e) {
		MainApp.switchScene("CalendarSelectControllerNext");
	}
}
