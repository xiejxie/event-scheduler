package backEnd;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backEnd.tasks.Courses;
import backEnd.tasks.ExtraCurriculars;
import backEnd.tasks.FreeTime;
import backEnd.tasks.StudyTimeTask;

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
	
	public void addCourseToCal(String courseName, HashMap<Character, LocalTime[]> courseInfo){
		Iterator<Character> courseInfoIterator = courseInfo.keySet().iterator();
		
		while(courseInfoIterator.hasNext()){
			Character nextCourseDay = courseInfoIterator.next();
			char day = nextCourseDay;
			
			LocalTime startTime = courseInfo.get(day)[0];
			LocalTime endTime = courseInfo.get(day)[1];
			//creating the object Courses for that course on that day
			Courses currCouse = new Courses(courseName, startTime, endTime, 0, day);
			
			//based on the day of the course offering, have to add to right list
			manager.addTaskToCalendar(currCouse, day);
		}	
	}

	public void addFreeAndStudyTimeToCal(String description, HashMap<Character, LocalTime[]> timeInfo){

		Iterator<Character> timeInfoIterator = timeInfo.keySet().iterator();
		
		while(timeInfoIterator.hasNext()){
			
			Character nextTimeDay = timeInfoIterator.next();
			char day = nextTimeDay;
			LocalTime startTime = timeInfo.get(day)[0];
			LocalTime endTime = timeInfo.get(day)[1];
			
			if(description.equals("Free Time")){
				FreeTime freeTimeTask = new FreeTime(startTime, endTime, 0, day);
				manager.addTaskToCalendar(freeTimeTask, day);
			}
			else{
				StudyTimeTask studyTimeTask = new StudyTimeTask(startTime, endTime, 0, day);
				manager.addTaskToCalendar(studyTimeTask, day);
			}
		}
	}

	public void addECToCal(String description, HashMap<Character, LocalTime[]> extraInfo){
		
		Iterator<Character> extraInfoIterator = extraInfo.keySet().iterator();
		
		while(extraInfoIterator.hasNext()){
			
			Character nextTimeDay = extraInfoIterator.next();
			char day = nextTimeDay;
			LocalTime startTime = extraInfo.get(day)[0];
			LocalTime endTime = extraInfo.get(day)[1];
			
			  //creating the object Courses for that course on that day
	        ExtraCurriculars currEC = new ExtraCurriculars(startTime, endTime, 0, description, day);
			   
	        //based on the day of the course offering, have to add to right list
	        manager.addTaskToCalendar(currEC , day);
		}
	}
	
	public void createThingTODO(String item, TODOManager tManage){
		String [] parts = item.split(":");
		String name = parts[0];
		char day = parts[1].charAt(1);
		int dur = Integer.parseInt(parts[1].substring(3));
		TODO t = new TODO(day, dur, name);
		tManage.addThingTODO(t);
	}
	
	// ==================================================
	// Backend testing methods
	// ==================================================
	
	//THIS FUNCTION DOES STRING CONVERSION AND IS FOR BACKEND TESTING PURPOSES
	public void createCourseAddToCal(String courseDescr){
		String courseName = courseDescr.substring(0, courseDescr.indexOf(":"));
		// getting just the course times
		String timings = courseDescr.substring(courseDescr.indexOf(":")+1);
		//getting each offering of the course on each day
		String [] daily = timings.split(",");
		
		HashMap<Character, LocalTime[]> courseInfo = new HashMap<Character, LocalTime[]>(); 
		
		for(int i = 0; i < daily.length; i++){
			String currDay = daily[i];
			char day = currDay.charAt(1);
			String startTimeString = currDay.substring(currDay.indexOf(day)+2, currDay.indexOf("-"));
			String endTimeString = currDay.substring(currDay.indexOf("-")+1);
			
			
			LocalTime[] timeArr = {convertToTime(startTimeString), convertToTime(endTimeString)};
			courseInfo.put(day, timeArr);
		}
		addCourseToCal(courseName, courseInfo);
	}
	
	//THIS FUNCTION DOES STRING CONVERSION AND IS FOR BACKEND TESTING PURPOSES
	public void createStudyFreeTimeAddToCal(String description, String timeType){
		Pattern pattern = Pattern.compile("([MTWRFSN]) (\\d\\d?:\\d\\d?)-(\\d\\d?:\\d\\d?)");
		Matcher m = pattern.matcher(description);
		char day;
		String start, end;
		
		HashMap<Character, LocalTime[]> freeTimeInfo = new HashMap<Character, LocalTime[]>();
		HashMap<Character, LocalTime[]> studyTimeInfo = new HashMap<Character, LocalTime[]>();
		
		while (m.find()){
			day = m.group(1).charAt(0);
			start = m.group(2);
			end = m.group(3);
			
			
			LocalTime[] timeArr = {convertToTime(start), convertToTime(end)};
			
			if(timeType.equals("free")){
				
				freeTimeInfo.put(day, timeArr);
			}
			else{
				studyTimeInfo.put(day,  timeArr);
			}
		}
		addFreeAndStudyTimeToCal("Free Time", freeTimeInfo);
		addFreeAndStudyTimeToCal("Study Time", studyTimeInfo);
	}

	//THIS FUNCTION DOES STRING CONVERSION AND IS FOR BACKEND TESTING PURPOSES
	public void createECAddToCal(String ECDescr){
		  String ECName = ECDescr.substring(0, ECDescr.indexOf(":"));
	      // getting just the extracurricular times
	      String timings = ECDescr.substring(ECDescr.indexOf(":")+1);
	      //getting each offering of the extracurricular activities on each day
	      String [] daily = timings.split(",");
	      
	      
	  	  HashMap<Character, LocalTime[]> extraInfo = new HashMap<Character, LocalTime[]>(); 
	      
	      for(int i = 0; i < daily.length; i++){
		        String currDay = daily[i];
		        char day = currDay.charAt(1);
		        String startTime = currDay.substring(currDay.indexOf(day)+2, currDay.indexOf("-"));
		        String endTime = currDay.substring(currDay.indexOf("-")+1);
		        
				LocalTime[] timeArr = {convertToTime(startTime), convertToTime(endTime)};
				extraInfo.put(day, timeArr);
	      }
	      addECToCal(ECName, extraInfo);
	}
	
	// ==================================================
	// Helper methods
	// ==================================================

	//Helper function for converting string format time to the Java LocalTime class
	public LocalTime convertToTime(String stringTime){
		String [] timeParts = stringTime.split(":");
		int hours = Integer.valueOf(timeParts[0]);
		int minutes = Integer.valueOf(timeParts[1]);
		LocalTime curTime = LocalTime.of(hours, minutes);
		return curTime;
	}
	
}