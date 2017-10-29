package frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

public class calendarSelectController {
	MainApp over = new MainApp();
	Set<Region> blockedTimes = new HashSet<Region>();
	final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	
	@FXML
	GridPane calendarGrid;
	
	@FXML
	ColumnConstraints monday;
	
	@FXML
	Label titleThin;
	
	@FXML
	public void initialize() {
		Font thinFont = Font.loadFont(calendarSelectController.class.getResourceAsStream("./fonts/SF-UI-Text-Light.otf"), 16);
		System.out.println(thinFont);
		titleThin.setFont(thinFont);
		 for (int x = 1 ; x < 8; x++) {
		        for (int y = 1 ; y < 24 ; y++) {
		            Region cell = new Region();
		            calendarGrid.getChildren().add(cell);
		            cell.setStyle("-fx-background-color: #fcfcfc");
		            System.out.println(cell.getStyleClass());
		            cell.setOnDragDetected((MouseEvent e) -> handleOnDragEntered(e));
		            cell.setOnMousePressed((MouseEvent e) -> handleDragAndClick(e));
		            cell.setOnMouseDragEntered((MouseEvent e) -> handleDragAndClick(e));
		            cell.setOnMouseEntered((MouseEvent e) -> handleMouseEntered(e));
		            cell.setOnMouseExited((MouseEvent e) -> handleMouseExited(e));
		            
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
	
	public void handleOnDragEntered(MouseEvent e) {
		Node source = (Node) e.getSource();
        source.startFullDrag();
	}
	
	public void handleMouseEntered(MouseEvent e) {
		Node source = (Node)e.getSource();
		int rowIndex = GridPane.getRowIndex(source);
		ArrayList<Region> row = sortByRows.get(rowIndex);
		for (Region cell : row) {
			cell.getStyleClass().add("activeRow");
		}
	}
	
	public void handleMouseExited(MouseEvent e) {
		Node source = (Node)e.getSource();
		int rowIndex = GridPane.getRowIndex(source);
		ArrayList<Region> row = sortByRows.get(rowIndex);
		for (Region cell : row) {
			cell.getStyleClass().remove("activeRow");
		}
	}
	
	public void handleDragAndClick(MouseEvent e) {
		if (e.getButton().toString().equals("PRIMARY")) {
			Node source = (Node)e.getSource();
			((Region) source).setStyle("-fx-background-color: dodgerblue");
			blockedTimes.add((Region) source);
	        System.out.println(GridPane.getRowIndex(source)+" "+GridPane.getColumnIndex(source));
		} else {
			Node source = (Node)e.getSource();
			((Region) source).setStyle("-fx-background-color: #fcfcfc");
			blockedTimes.remove((Region) source);
	        System.out.println(GridPane.getRowIndex(source)+" "+GridPane.getColumnIndex(source));
		}
	}
}
