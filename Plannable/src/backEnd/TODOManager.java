package backEnd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import backEnd.tasks.StudyTimeTask;
import backEnd.tasks.Task;
/**
 * TODOManager is a class that
 * - takes all the tasks entered and enters them into the calendar
 * - contains the algorithm that organizes the users study time optimally
 * - returns the optimized calendar to the user
 */
public class TODOManager {
	
	private ArrayList<TODO> thingsTODO;
	
	public TODOManager(){
		thingsTODO = new ArrayList<TODO>();
	}
	
	public void addThingTODO(TODO t){
		thingsTODO.add(t);
	}
	
	public void sortList(){
		Collections.sort(thingsTODO, Collections.reverseOrder());
	}
	
	/**
	 * Adds all the tasks inputted by the user into the weekly calendar
	 * @param w
	 * The weekly calendar object
	 */
	public void addToCalendar(WeeklyCalendar w){
		sortList();
		ArrayList<ArrayList<Task>> days = w.daysOfWeek;
		//going through each day of the week
		for(int i = 0; i < days.size(); i++){
			ArrayList<Task> currDay = days.get(i);
			// going through each task on each day
			for(int j = 0; j < currDay.size(); j++){
				if(currDay.get(j) instanceof StudyTimeTask){
					manageStudyTime((StudyTimeTask)currDay.get(j));
					sortList();
				}
			}
			//Updates the due date priorities after a single day
			for(int k = 0; k < thingsTODO.size(); k++){
			  thingsTODO.get(k).updateDate();
			}
		}
	}
	
	/**
	 * Our main algorithm for organizing the study times based on a number of 
	 * factors such as deadline, difficulty, weight, and user priority.
	 * @param studyToday
	 * An initially empty StudyTimeTask object that will be allocated by the 
	 * algorithm for a specific study task.
	 */
	public void manageStudyTime(StudyTimeTask studyToday){
	    //variable setup
		int totalTime = studyToday.getDuration();
		int currTime = 0;
		int index = 0;
		TODO currTODO = null;
		int timeSpent = 0;
		List<Integer> num_of_hours = new ArrayList();
		
		//Determines number of hours each task will use
		if(totalTime >= 3){
		  int equal_hours_1 = (int) Math.ceil(totalTime / 3);
	      num_of_hours.add(equal_hours_1);
	      num_of_hours.add(equal_hours_1);
	      int equal_hours_2 = (int) Math.floor(totalTime / 3);
	      num_of_hours.add(equal_hours_2);
		}
		
		//Allocation of tasks to study time
		while(currTime < totalTime && index < thingsTODO.size()){
		    //If total number of hours is 1
		    if(totalTime < 2){
		      currTODO = thingsTODO.get(index);
		      currTime += totalTime;
		      currTODO.workedOnTODO(totalTime);
		      studyToday.addWork(currTODO.getName(), totalTime);
		      break;
		      
		    //If total number of hours is 2
		    } else if (totalTime < 3){
		      currTODO = thingsTODO.get(index);
              currTime += 1;
              currTODO.workedOnTODO(1);
              studyToday.addWork(currTODO.getName(), 1);
              index++;
              
              currTODO = thingsTODO.get(index);
              currTime += 1;
              currTODO.workedOnTODO(1);
              studyToday.addWork(currTODO.getName(), 1);
              break;
              
            //If total number of hours is more than 3
		    } else {
		          currTODO = thingsTODO.get(index);
		          System.out.println("name: " + currTODO.getName());
		          System.out.println("due date priority: " + currTODO.getDueDatePriority());
		          //moves on if due date has passed
		          if(currTODO.getDueDatePriority() > 7){
		            index++;
		          } else {
	                timeSpent = Math.min(num_of_hours.get(index), currTODO.getTimeAllocated());
	                currTime += timeSpent;
	                currTODO.workedOnTODO(timeSpent);
	                studyToday.addWork(currTODO.getName(), timeSpent);
	                currTODO.updatePriority();
	                index++;
		          }
		    }
		}
			
			/*
			if(currTODO.getPriority() == 0){
				index++;
				continue;
			}
			if(currTODO.getPriority() == 1 && currTODO.getTimeAllocated() != 0){
				timeSpent = currTODO.getTimeAllocated();
				currTime += timeSpent;
				currTODO.workedOnTODO(timeSpent);
				studyToday.addWork(currTODO.getName(), timeSpent);
				index++;
			}
			else{
				// should only work on one thing for a max of 2hrs
				timeSpent = Math.min(2, currTODO.getTimeAllocated());
				currTime += timeSpent;
				currTODO.workedOnTODO(timeSpent);
				studyToday.addWork(currTODO.getName(), timeSpent);
				index++;
			}

		}
		// worked on last task for too long, add back time
		if(currTime > totalTime){
			currTODO.addBack(currTime - totalTime);
			timeSpent = timeSpent - (currTime - totalTime);
			studyToday.addWork(currTODO.getName(), timeSpent);
			updatePriorities();
		}
		*/
	}
	/*
	public void updatePriorities(){
		for (int i = 0; i < thingsTODO.size(); i++){
			if(thingsTODO.get(i).getPriority() != 0){
				thingsTODO.get(i).updatePriority();
			}
		}
	}
	*/
	
}