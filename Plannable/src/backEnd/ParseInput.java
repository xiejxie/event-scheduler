package backEnd;

import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backEnd.tasks.Courses;
import backEnd.tasks.ExtraCurriculars;
import backEnd.tasks.FreeTime;

import backEnd.tasks.Sleep;
import backEnd.tasks.StudyTimeTask;
import backEnd.tasks.Task;

/**
 * ParseInput is a class that:
 * - takes in raw text input
 * - processes the information
 * - calls the appropriate methods in TaskManager
 * to add new tasks
 */
public class ParseInput {

	private TaskManager manager;
	
	public ParseInput(WeeklyCalendar w){
		manager = new TaskManager(w);
	}
	
	public void createCommuteAddToCal(int time){
		manager.addCommute(time);
	}
	
	public void createRestTimeAddToCal(int time){
		manager.addRest(time);
	}
	
	public void createCourseAddToCal(String courseDescr){
		String courseName = courseDescr.substring(0, courseDescr.indexOf(":"));
		// getting just the course times
		String timings = courseDescr.substring(courseDescr.indexOf(":")+1);
		//getting each offering of the course on each day
		String [] daily = timings.split(",");
		
		for(int i = 0; i < daily.length; i++){
			String currDay = daily[i];
			char day = currDay.charAt(1);
			String startTimeString = currDay.substring(currDay.indexOf(day)+2, currDay.indexOf("-"));
			String endTimeString = currDay.substring(currDay.indexOf("-")+1);
			
			//creating the object Courses for that course on that day
			Courses currCouse = new Courses(courseName, convertToTime(startTimeString), convertToTime(endTimeString), 0, day);
			
			//based on the day of the course offering, have to add to right list
			manager.addTaskToCalendar(currCouse, day);
			
		}
	}
	
	public void createStudyFreeTimeAddToCal(String description, String timeType){
		Pattern pattern = Pattern.compile("([MTWRFSN]) (\\d\\d?:\\d\\d?)-(\\d\\d?:\\d\\d?)");
		Matcher m = pattern.matcher(description);
		char day;
		String start, end;
		Task t;
		while (m.find()){
			day = m.group(1).charAt(0);
			start = m.group(2);
			end = m.group(3);
			if(timeType.equals("free")){
				t = new FreeTime(convertToTime(start), convertToTime(end), 0, day);
			}
			else{
				t = new StudyTimeTask(convertToTime(start), convertToTime(end), 0, day);
			}
			manager.addTaskToCalendar(t, day);
		}
	}
	
	public void createECAddToCal(String ECDescr){
		  String ECName = ECDescr.substring(0, ECDescr.indexOf(":"));
	      // getting just the extracurricular times
	      String timings = ECDescr.substring(ECDescr.indexOf(":")+1);
	      //getting each offering of the extracurriculars on each day
	      String [] daily = timings.split(",");
	      
	      for(int i = 0; i < daily.length; i++){
		        String currDay = daily[i];
		        char day = currDay.charAt(1);
		        String startTime = currDay.substring(currDay.indexOf(day)+2, currDay.indexOf("-"));
		        String endTime = currDay.substring(currDay.indexOf("-")+1);
		        //creating the object Courses for that course on that day
		        ExtraCurriculars currEC = new ExtraCurriculars(convertToTime(startTime), convertToTime(endTime), 0, ECName, day);
		        
		        //based on the day of the course offering, have to add to right list
		        manager.addTaskToCalendar(currEC , day);
	      }
	}
	
	public LocalTime convertToTime(String stringTime){
		String [] timeParts = stringTime.split(":");
		int hours = Integer.valueOf(timeParts[0]);
		int minutes = Integer.valueOf(timeParts[1]);
		LocalTime curTime = LocalTime.of(hours, minutes);
		return curTime;
	}
	
	public void createThingTODO(String item, TODOManager tManage){
		String [] parts = item.split(":");
		String name = parts[0];
		char day = parts[1].charAt(1);
		int dur = Integer.parseInt(parts[1].substring(3));
		TODO t = new TODO(day, dur, name);
		tManage.addThingTODO(t);
	}
}