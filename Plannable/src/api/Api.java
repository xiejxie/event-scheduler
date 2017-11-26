package api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import backEnd.ParseInput;
import backEnd.TODOManager;
import backEnd.WeeklyCalendar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * The Api class functions as a bridge between the 
 * frontend and backend portions of this application.
 */
public final class Api {
	
	// Api's access to backend
	private static final ParseInput parse = new ParseInput(new WeeklyCalendar()); 
	private static final TODOManager tManage = new TODOManager();
	
	// Never instantiate this class
	private Api(){}
	
	/**
	 * Takes the frontend input for Courses, Extracurriculars and
	 * Free or Study time and sends the data to the appropriate
	 * functions in ParseInput.
	 */
	public static void sendTaskToParse(Set<Region> blocks, String name, int state){
		HashMap<Character, LocalTime []> info = new HashMap<>();
		Iterator<Region> r = blocks.iterator();
		LocalTime start = LocalTime.MIDNIGHT;
		LocalTime end = LocalTime.MIDNIGHT;
		while(r.hasNext()){
			Region curr = r.next();
			char day = dayAt(GridPane.getColumnIndex(curr));
			int row = GridPane.getRowIndex(curr);
			start = LocalTime.of(row/2, row % 2 == 0 ? 0 : 30);
			end = start.plus(30, ChronoUnit.MINUTES);
			
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
		switch(state) {
		case 1:
			parse.addCourseToCal(name, info);
			break;
		case 2:
			if(name.compareTo("Commute") == 0){
				int time = Math.abs(end.getHour() - start.getHour()) * 60 + Math.abs(end.getMinute() - start.getMinute()); 
				parse.createCommuteAddToCal(time);
			} else {
				parse.addECToCal(name, info);
			}
			break;
		case 3:
			int time = Math.abs(end.getHour() - start.getHour()) * 60 + Math.abs(end.getMinute() - start.getMinute());
			parse.createRestTimeAddToCal(time);
			break;
		case 4:
			parse.addFreeAndStudyTimeToCal(name, info);
			break;
		default:
			break;
		}
		
		/*
		// For debugging
		Iterator<Character> c = info.keySet().iterator();
		while(c.hasNext()) {
			char curr = c.next();
			System.out.println(curr + " " + info.get(curr)[0] + "-" + info.get(curr)[1]);
		}
		*/
		
		System.out.println(parse.returnCal());
	}
	
	/**
	 * Sends the information to backend to add the todo task to the calendar.
	 * TODO: cater to having extra arguments weight and difficulty in accordance
	 * with backend algorithm.
	 * 
	 * @param name the name of the todo task
	 * @param date the date at which it takes place
	 * @param time the time of the task
	 * @param toFinish the time it may take to finish the task
	 */
	public static void sendTODOToCal(String name, String date, int hour, int toFinish, int difficulty, int weighting) {
		// send to backend to process
		System.out.println("Task: " + name 
				+ "\tDate: " + date 
				+ "\tTime: " + hour + "th hour of day"
				+ "\tTo Finish: " + toFinish + " hours."
				+ "\tDifficulty: " + difficulty
				+ "\tWeighting: " + weighting);
		
		//parse.createThingTODO(name + ": " + dayAt(LocalDate.parse(date).getDayOfWeek().getValue()) + toFinish + ", " + hour + ", " + weighting + ", " + difficulty , tManage);
	}
	
	/**
	 * Sends the name to backend which will delete each task of that name.
	 * @param name the name of the task to be deleted
	 */
	public static void deleteBlock(String name) {
		// Send request to backend
		System.out.println("Delete: " + name);
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
