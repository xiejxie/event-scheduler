package backEnd;

import java.util.ArrayList;
import java.util.Collections;

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
		Collections.sort(thingsTODO);
	}
	
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
		}
	}
	
	public void manageStudyTime(StudyTimeTask studyToday){
		int totalTime = studyToday.getDuration();
		int currTime = 0;
		int index = 0;
		TODO currTODO = null;
		int timeSpent = 0;
		
		while(currTime < totalTime && index < thingsTODO.size()){
			currTODO = thingsTODO.get(index);
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
	}
	
	public void updatePriorities(){
		for (int i = 0; i < thingsTODO.size(); i++){
			if(thingsTODO.get(i).getPriority() != 0){
				thingsTODO.get(i).decrementPriority();
			}
		}
	}

}
