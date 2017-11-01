package backEnd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backEnd.tasks.Courses;
import backEnd.tasks.FreeTime;

import backEnd.tasks.Sleep;
import backEnd.tasks.Task;

public class ParseInput {

//	private WeeklyCalendar thisWeek;
	private TaskManager manager;
	
	public ParseInput(WeeklyCalendar w){
//		thisWeek = w;
		manager = new TaskManager(w);
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
			String startTime = currDay.substring(currDay.indexOf(day)+2, currDay.indexOf("-"));
			String endTime = currDay.substring(currDay.indexOf("-")+1);
			//creating the object Courses for that course on that day
			Courses currCouse = new Courses(courseName, 0, startTime, endTime, day);
			
			//based on the day of the course offering, have to add to right list
			manager.addTaskToCalendar(currCouse, day);
			
		}
	}
	
	public void createCommuteAddToCal(int time){

		manager.addCommute(time);
		
	}
	
	public void addRestTimeToCal(int time){
		Task firstCommute, lastCommute;
		
	}
	
	public void createFreeTimeAddToCal(String description){
		Pattern pattern = Pattern.compile("([MTWRF]) (\\d\\d?:\\d\\d?)-(\\d\\d?:\\d\\d?)");
		Matcher m = pattern.matcher(description);
		char day;
		String start, end;
		while (m.find()){
			day = m.group(1).charAt(0);
			start = m.group(2);
			end = m.group(3);
			FreeTime ft = new FreeTime(start, end, 0, day);
			manager.addTaskToCalendar(ft, day);
		}
	}


	public Sleep getSleepTime(int time){
			
		return null;
	}
}
