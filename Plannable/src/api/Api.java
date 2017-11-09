package api;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import backEnd.ParseInput;
import backEnd.WeeklyCalendar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * The Api class functions as a bridge between the 
 * frontend and backend portions of this application.
 */
public final class Api {
	
	private static final ParseInput parse = new ParseInput(new WeeklyCalendar()); 
	
	// Never instantiate this class
	private Api(){}
	
	/**
	 * Takes the frontend input for Courses and Extracurriculars and sends 
	 * the data to the appropriate functions in ParseInput.
	 */
	public static void sendTaskToParse(Set<Region> blocks, String name){
		HashMap<Character, LocalTime []> info = new HashMap<>();
		Iterator<Region> r = blocks.iterator();
		while(r.hasNext()){
			Region curr = r.next();
			char day = dayAt(GridPane.getColumnIndex(curr));
			int row = GridPane.getRowIndex(curr);
			LocalTime start = LocalTime.of(row/2, row % 2 == 0 ? 0 : 30);
			LocalTime end = start.plus(30, ChronoUnit.MINUTES);
			
			// If this is the first task of the day, make a new array
			if (!info.containsKey(day)) {
				info.put(day, new LocalTime[2]);
				info.get(day)[0] = start;
				info.get(day)[1] = end;
			}

			if(start.isBefore(info.get(day)[0])) {
				info.get(day)[0] = start;
			} else if (end.isAfter(info.get(day)[1])) {
				info.get(day)[1] = end;
			}
		}
		
		/** Call to ParseInput **/
		
		// For debugging
		Iterator<Character> c = info.keySet().iterator();
		while(c.hasNext()) {
			char curr = c.next();
			System.out.println(curr + " " + info.get(curr)[0] + "-" + info.get(curr)[1]);
		}
	}
	
	/**
	 * Returns the character for the day of the week 
	 * associated with 1-7 loop counter value num.
	 */
	public static Character dayAt (int num) {
		switch(num) {
		case 1:
			return 'S';
		case 2:
			return 'M';
		case 3:
			return 'T';
		case 4:
			return 'W';
		case 5:
			return 'R';
		case 6:
			return 'F';
		case 7:
			return 'N';
		default:
			System.out.println("Invalid int.");
			return 'X';
		}
	}
	
}
