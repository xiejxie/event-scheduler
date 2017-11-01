package backEnd;

import java.util.ArrayList;

import backEnd.tasks.Commute;
import backEnd.tasks.Courses;
import backEnd.tasks.Sleep;
import backEnd.tasks.Task;

public class ParseInput {

	private WeeklyCalendar thisWeek;
	public ParseInput(WeeklyCalendar w){
		thisWeek = w;
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
			switch(day){
				case 'M':
					thisWeek.monTasks.add(currCouse);
					break;
				case 'T':
					thisWeek.tuesTasks.add(currCouse);
					break;
				case 'W':
					thisWeek.wedTasks.add(currCouse);
					break;
				case 'R':
					thisWeek.thursTasks.add(currCouse);
					break;
				case 'F':
					thisWeek.friTasks.add(currCouse);
					break;
			}
			
		}
	}
	
	public void createCommuteAddToCal(int time){
		Task lastTask, firstTask;
		
		for(int counter = 0; counter < thisWeek.daysOfWeek.size(); counter ++){
			ArrayList<Task> today = thisWeek.daysOfWeek.get(counter);
			if(today.size() != 0){
				lastTask = today.get(today.size() - 1);
				today.add(getEndOfDayCommute(lastTask, time));
				firstTask = today.get(0);
				today.add(0, getEndOfDayCommute(firstTask, time));
			}	
		}
		
/*
		//only commute if going to courses
		if(thisWeek.monTasks.size() != 0){
			// getting the last course so can commute after
			lastTask = thisWeek.monTasks.get(thisWeek.monTasks.size()-1);
			thisWeek.monTasks.add(getEndOfDayCommute(lastTask, time));
			// getting the first course so can commute before
			firstTask = thisWeek.monTasks.get(0);
			thisWeek.monTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(thisWeek.tuesTasks.size() != 0){
			lastTask = thisWeek.tuesTasks.get(thisWeek.tuesTasks.size()-1);
			thisWeek.tuesTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = thisWeek.tuesTasks.get(0);
			thisWeek.tuesTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(thisWeek.wedTasks.size() != 0){
			lastTask = thisWeek.wedTasks.get(thisWeek.wedTasks.size()-1);
			thisWeek.wedTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = thisWeek.wedTasks.get(0);
			thisWeek.wedTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(thisWeek.thursTasks.size() != 0){
			lastTask = thisWeek.thursTasks.get(thisWeek.thursTasks.size()-1);
			thisWeek.thursTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = thisWeek.thursTasks.get(0);
			thisWeek.thursTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(thisWeek.friTasks.size() != 0){
			lastTask = thisWeek.friTasks.get(thisWeek.friTasks.size()-1);
			thisWeek.friTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = thisWeek.friTasks.get(0);
			thisWeek.friTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
	*/
		
	}
	
	public void addRestTimeToCal(int time){
		Task firstCommute, lastCommute;
		
		
	}
	
	public Commute getEndOfDayCommute(Task lastTask, int time){
		String startTime = lastTask.getEndTime();
		String endTime;
		//converting time to number of half hour blocks since midnight (easier to do arithmetic
		//than with strings
		int e = lastTask.getEndTimeAsInt(lastTask.getEndTime()) + (time/30);
		if(e%2==1){
			endTime =":30";
			e--;
		}
		else{
			endTime =":00";
		}
		String hour = String.valueOf(e/2);
		endTime = hour+endTime;
		//System.out.println(startTime + "\n" + endTime);
		Commute endOfDay = new Commute (0, startTime, endTime);
		return endOfDay;
	}
	
	public Commute getStartOfDayCommute(Task firstTask, int time){
		String endTime, startTime, hour;
		endTime = firstTask.getStartTime();
		int s = firstTask.getStartTimeAsInt(firstTask.getStartTime()) - (time/30);
		
		if(s%2==1){
			startTime =":30";
			s--;
		}
		else{
			startTime =":00";
		}
		hour = String.valueOf(s/2);
		startTime = hour+startTime;
		Commute startOfDay = new Commute (0, startTime, endTime);
		return startOfDay;
	}
<<<<<<< HEAD
	
	public void CreateECAddToCal(String ECDescr){
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
        Courses currEC = new Courses(ECName, 0, startTime, endTime, day);
        
        //based on the day of the course offering, have to add to right list
        switch(day){
            case 'M':
                thisWeek.monTasks.add(currEC);
                break;
            case 'T':
                thisWeek.tuesTasks.add(currEC);
                break;
            case 'W':
                thisWeek.wedTasks.add(currEC);
                break;
            case 'R':
                thisWeek.thursTasks.add(currEC);
                break;
            case 'F':
                thisWeek.friTasks.add(currEC);
                break;
        }
        
      }
	}

    public Sleep getSleepTime(int time){
  
        return null;
    }
}
