package frontEnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import api.Api;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Controller class for calendarSelect.fxml - the screen where you select your free time inputs
 *
 */
public class ScheduleSelectController extends Controller {
	Set<Region> blockedTimes = new HashSet<Region>(); //Selected times
	//Code representation of the grayed in cells
	Map<Integer, ArrayList<Region>> sortByRows = new HashMap<Integer, ArrayList<Region>>();
	Boolean addTimesFlag = true;
	ArrayList<Set<Region>> permanentlyBlockedTimes = new ArrayList<Set<Region>>();
	ArrayList<VBox> steps = new ArrayList<VBox>();
	int state = 1;
	int addIndex;
	
	@FXML
	GridPane scheduleGrid; //The grayed in region holding individual time slots
	
	@FXML
	Button addNew;
	
	@FXML
	VBox leftPaneBox;
	
	@FXML
	TextField addNewTextField;
	
	@FXML
	VBox step1;
	
	@FXML
	VBox step2;

	@FXML
	VBox step3;
	
	@FXML
	VBox header;
	
	@FXML
	HBox leftHBox;
	
	@FXML
	HBox rightHBox;
	
	@FXML
	Button nextButton;
	
	@FXML
	Button backButton;
	
	@FXML
	VBox scheduleGridDisplay;
	
	/**
	 * Set up
	 */
	@FXML
	public void initialize() {
		backButton.setOnMousePressed((MouseEvent e) -> goToDifferentStep(e, false));
		nextButton.setOnMousePressed((MouseEvent e) -> goToDifferentStep(e, true));
		addNew.setId("addNew");
		addNew.setOnMousePressed((MouseEvent e) -> addNewTimeBlock(e));
		addNewTextField.setOnKeyPressed((KeyEvent e) -> addNewTimeBlockWrapper(e));
		steps.add(step1);
		steps.add(step2);
		steps.add(step3);
		 for (int x = 1 ; x < 8; x++) {
		        for (int y = 0 ; y < 48 ; y++) {
		            Region cell = new Region();
		            scheduleGrid.getChildren().add(cell);
		            cell.getStyleClass().add("inactiveCell");
		            cell.setOnDragDetected((MouseEvent e) -> startSelect(e));
		            cell.setOnMousePressed((MouseEvent e) -> {
		            	determineDragType(e);
		            	selectDrag(e);
		            });
		            cell.setOnMouseDragEntered((MouseEvent e) -> selectDrag(e));
		            cell.setOnMouseEntered((MouseEvent e) -> drawHoverLine(e, this.sortByRows));
		            cell.setOnMouseExited((MouseEvent e) -> cleanUpHoverLine(e, this.sortByRows));
		            // whatever the backend needs cell.setId(value);
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
	 * Return a scene object that this class controls
	 */
	public Scene getScene() {
		return this.getScene("./ScheduleSelect.fxml");
	}
	
	private void disableCalendar() {
		for (Node n : scheduleGrid.getChildren()) {
			if (n.getClass() == Region.class) {
				if (n.getStyleClass().contains("activeCell")) {
					n.getStyleClass().remove("activeCell");
					n.getStyleClass().add("inactiveCell");
				}
				n.setDisable(true);
			}
	    }
	}
	
	private void parseTimeBlocks() {
		for (int i = 0; i < leftPaneBox.getChildren().size()-1; i++) {
			HBox box = (HBox) leftPaneBox.getChildren().get(i);
			box.setDisable(false);
			Button but = (Button) box.getChildren().get(0);
			but.setDisable(true);
	    }
		leftPaneBox.getChildren().remove(leftPaneBox.getChildren().size()-1);
		MainApp.setScheduleGridInformation(leftPaneBox);
	}
	
	// Event handlers
	// Some terminology definitions:
	// Selected cells -> the ones in deep blue, you can easily add/remove at a time
	// Blocked off cells -> cells designated as some activity, will be a different colour
	// Time block -> group of blocked off cells + their textual representation on the left pane (i.e. CSC369 or the like)
	// 
	
	/**
	 * Creates the coloured line that appears when you hover over a row of cells
	 * @param e	the recorded event
	 */
	public static void drawHoverLine(MouseEvent e, Map<Integer, ArrayList<Region>> sortByRows) {
		Node source = (Node)e.getSource();
		int rowIndex = GridPane.getRowIndex(source);
		ArrayList<Region> row = sortByRows.get(rowIndex);
		for (int i = 0; i < GridPane.getColumnIndex(source); i++) {
			row.get(i).getStyleClass().add("activeRow");
		}
	}
	
	/**
	 * Deletes the coloured line that appears when you hover over a row of cells when you exit
	 * @param e	the recorded event
	 */
	public static void cleanUpHoverLine(MouseEvent e, Map<Integer, ArrayList<Region>> sortByRows) {
		Node source = (Node)e.getSource();
		int rowIndex = GridPane.getRowIndex(source);
		ArrayList<Region> row = sortByRows.get(rowIndex);
		for (int i = 0; i < GridPane.getColumnIndex(source); i++) {
			row.get(i).getStyleClass().remove("activeRow");
		}
	}
	
	/**
	 * Handles the motion of clicking on any region of the schedule and begin selecting a block
	 * @param e	the recorded event
	 */
	public void startSelect(MouseEvent e) {
		Node source = (Node) e.getSource();
        source.startFullDrag();
	}
	
	/**
	 * Determines if the starting select happened on an already selected block (in which case
	 * the program should proceed to de-select everything in its path) or a non-selected block (in which case
	 * the program should select cells in its path)
	 * @param e	the recorded event
	 */
	public void determineDragType(MouseEvent e) {
		addTimesFlag = (!blockedTimes.contains((Region) e.getSource()));
	}
	
	/**
	 * Depending on the results of determineDragType, carry out the decided action
	 * @param e	the recorded event
	 */
	public void selectDrag(MouseEvent e) {
		if (e.getButton().toString().equals("PRIMARY")) {
			Region source = (Region)e.getSource();
			if (addTimesFlag && !blockedTimes.contains((Region) source) && !((Region) source).isDisabled()) {
				(source).getStyleClass().remove("inactiveCell");
				(source).getStyleClass().add("activeCell");
				blockedTimes.add(source);
			}
			else if (!addTimesFlag) {
				(source).getStyleClass().add("inactiveCell");
				(source).getStyleClass().remove("activeCell");
				blockedTimes.remove(source);
			}
		}
	}
	
	/**
	 * Go forward or back a step
	 * @param e			the recorded step
	 * @param forward	the direction of step
	 */
	public void goToDifferentStep(MouseEvent e, boolean forward) {
		int newState = forward ? state+1 : state-1;
		System.out.println(newState);
		if (!forward && state == 1) {
			MainApp.switchScene("AddTask", false);
		}
		else if (newState < 5) { 
			shiftHeader(newState, CustomizeableConstants.getHeaderString(newState));
			shiftPanel(newState);
			state = newState;
			addIndex = 0;
			List<Node> timeBlockList = leftPaneBox.getChildren();
			for (int i = 0; i < timeBlockList.size()-1; i++) {
				int currentId = Integer.parseInt(timeBlockList.get(i).getId());
				if (currentId < state && !timeBlockList.get(i+1).getId().equals(currentId+"")) {
					//found the last item
					addIndex = i + 1;
				}
			}
		} else {
			Api.setCal();
			disableCalendar();
			MainApp.setScheduleGridDisplay(scheduleGridDisplay);
			parseTimeBlocks();
			MainApp.switchScene("ScheduleDisplay", true);
		}
	}
	
	/**
	 * Add all selected blocks as a new time block when you hit enter
	 * @param e	the recorded key event
	 */
	public void addNewTimeBlockWrapper(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			addNewTimeBlock(e);
		}
	}
	
	/**
	 * Add all selected blocks as a new time block when you hit the + button
	 * @param e	the recorded key event
	 */
	public void addNewTimeBlock(Event e) {
		if (!blockedTimes.isEmpty() && !addNewTextField.getText().trim().isEmpty()) {
			String colour = CustomizeableConstants.getColour();
			Set<Region> newBlockedTimes = new HashSet<Region>();
			for(Region region : blockedTimes) {
				//send to backend times;
				region.setDisable(true);
				region.getStyleClass().remove("activeCell");
				region.setStyle("-fx-background-color: "+colour);
				region.setId(String.valueOf(state));
				newBlockedTimes.add(region);
			}
			permanentlyBlockedTimes.add(addIndex, newBlockedTimes);
			String timeBlockText = addNewTextField.getText().trim();
			Api.sendTaskToParse(newBlockedTimes, timeBlockText, state);
			Label timeBlockLabel = new Label(timeBlockText);
			timeBlockLabel.getStyleClass().add("timeBlock");
			timeBlockLabel.getStyleClass().add("fontRegular");
			timeBlockLabel.setStyle("-fx-padding: 5 0 0 0;");
			HBox timeBlockHBox = new HBox();
			Button timeBlockRemoveButton = new Button("x");
			timeBlockRemoveButton.getStyleClass().add("fontThin");
			timeBlockRemoveButton.setOnMousePressed((MouseEvent me) -> removeBlockedTimes(newBlockedTimes, timeBlockLabel));
			timeBlockRemoveButton.getStyleClass().add("generalButton");
			timeBlockRemoveButton.setStyle("-fx-text-fill: "+colour);
			timeBlockHBox.getChildren().add(timeBlockRemoveButton);
			timeBlockHBox.getChildren().add(timeBlockLabel);
			timeBlockHBox.setId(state+"");
			leftPaneBox.getChildren().add(addIndex, timeBlockHBox);
			MainApp.setScheduleGridMap(timeBlockLabel, newBlockedTimes);
			addNewTextField.clear();
			blockedTimes.clear();
		}
		else {
			PopupAlert pa = new PopupAlert('I');
			pa.getAlert();
		}
	}
	
	/**
	 * Remove an existing time block
	 * @param blockedTimes	set holding the time block to be deleted
	 */
	public void removeBlockedTimes(Set<Region> blockedTimes, Label l) {
		int index = permanentlyBlockedTimes.indexOf(blockedTimes);
		for (Region region : blockedTimes) {
			region.setDisable(false);
			region.setStyle("");
			region.getStyleClass().add("inactiveCell");
		}
		permanentlyBlockedTimes.remove(index);
		Api.deleteBlock(((Label)((HBox)leftPaneBox.getChildren().get(0)).getChildren().get(1)).getText());
		leftPaneBox.getChildren().remove(index);
		MainApp.rmScheduleGridMap(l);
	}
	
	/**
	 * Disable/Enable certain time blocks according to what next step is
	 * @param stepIndex	the next step
	 */
	public void shiftPanel(int stepIndex) {
		for (Node node : leftPaneBox.getChildren()) {
			if (!node.getId().equals("addNewHBox") && !node.getId().equals(stepIndex+"")) {
				((HBox) node).setDisable(true);
			}
			else if (node.getId().equals(stepIndex+"")) {
				node.setDisable(false);
			}
		}
	}
	
	/**
	 * Change the header and steps according to what next step is
	 * @param stepIndex		the next step
	 * @param headerTitle	the header of the next step
	 */
	public void shiftHeader(int stepIndex, String headerTitle) {
		leftHBox.getChildren().clear();
		rightHBox.getChildren().clear();
		
		int i = 1;
		while(i < stepIndex) {
			VBox prevStep = steps.get(i-1);
			((Label) prevStep.getChildren().get(1)).setText("0"+i);
			leftHBox.getChildren().add(steps.get(i-1));
			i++;
		}
		Label headerStep = (Label) header.getChildren().get(0);
		headerStep.setText("STEP "+stepIndex);
		Label headerString = (Label) header.getChildren().get(1);
		headerString.setText(headerTitle);
		leftHBox.getChildren().add(header);
		while(i-1 < steps.size()) {
			((Label) steps.get(i-1).getChildren().get(1)).setText("0"+(i+1));
			rightHBox.getChildren().add(steps.get(i-1));
			i++;
		}
	}
}
