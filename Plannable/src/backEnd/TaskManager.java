package backEnd;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import backEnd.tasks.Commute;
import backEnd.tasks.Sleep;
import backEnd.tasks.Task;

/**
 * TaskManager is the class used to take in
 * task information objects and add these objects to the instance
 * of WeeklyCalendar.
 */
public class TaskManager {
	
	/** The instance of WeeklyCalendar that this instance of Task Manager
	 * will be adding to.*/
	private WeeklyCalendar week;
	
	/**
	 * Constructs a new TaskManager instance which will add to the 
	 * given WeeklyCalendar instance passed in to it.
	 * 
	 * @param week
	 * 		The instance of WeeklyCalendar that TaskManager will add to.
	 */
	public TaskManager(WeeklyCalendar week){
		this.week = week;
	}
	
	/**
	 * Adds a specific task object for a given day to the WeeklyCalendar instance.
	 * 
	 * @param task
	 * 		A Task object representing a task to be added to the WeeklyCalendar.
	 * @param day
	 * 		The day that this task occurs on. 
	 */
	public void addTaskToCalendar(Task task, char day){
		if (task == null){
			throw new NullPointerException();
		}
		switch(day){
		case 'M':
			week.monTasks.add(task);
			break;
		case 'T':
			week.tuesTasks.add(task);
			break;
		case 'W':
			week.wedTasks.add(task);
			break;
		case 'R':
			week.thursTasks.add(task);
			break;
		case 'F':
			week.friTasks.add(task);
			break;
		case 'S':
			week.satTasks.add(task);
			break;
		case 'N':
			week.sunTasks.add(task);
			break;
		}
	}
	/**
	 * A getter for the WeeklyCalendar instance of this TaskManager
	 * 
	 * @return
	 * 		The WeeklyCalendar attribute for this TaskManager. 
	 */
	public WeeklyCalendar getWeek(){
		return week;
	}
	
	/**
	 * Adds all the weekly commute tasks to the WeeklyCalendar instance.
	 * 
	 * @param time
	 * 		The duration in minutes, of the user's one-way commute. 
	 */
	public void addCommute(int time){
		Task lastTask, firstTask;
		for(int counter = 0; counter < week.daysOfWeek.size(); counter ++){
			ArrayList<Task> today = week.daysOfWeek.get(counter);
			if(today.size() != 0){
				lastTask = today.get(today.size() - 1);
				today.add(getEndOfDayCommute(lastTask, time));
				firstTask = today.get(0);
				today.add(0, getStartOfDayCommute(firstTask, time));
			}	
		}
	}
	/**
	 * Helper method that creates the end of day commute for a given day 
	 * based on the finishing time of the last task of that day.
	 * 
	 * @param lastTask
	 * 		The task object representing the last task of the day.
	 * @param time
	 * 		The commute time of the user in minutes.
	 * @return
	 * 		The resulting commute task taking into account the completion
	 * 		time of the previous task and the total commute time. The 
	 * 		start time of this task the the finishing time of the last task
	 * 		and the end time is the start time plus the commute duration.
	 */
	public Commute getEndOfDayCommute(Task lastTask, int time){
		LocalTime departureTime = lastTask.getEndTime();
		LocalTime arrivalTime = departureTime.plus(time, ChronoUnit.MINUTES);
		Commute endOfDay = new Commute (departureTime, arrivalTime, 0);
		return endOfDay;
	}
	/**
	 * Helper method that creates the start of day commute for a given day 
	 * based on the start time of the first task of that day.
	 * 
	 * @param firstTask
	 * 		The task object representing the first task of the day.
	 * @param time
	 * 		The commute time of the user in minutes.
	 * @return
	 * 		The resulting commute task taking into account the start
	 * 		time of the first task and the total commute time. The 
	 * 		end time of this task is the start time of the first (non-commute)
	 *		task and the start time is the end time minus the commute time.
	 */
	public Commute getStartOfDayCommute(Task firstTask, int time){
		LocalTime arrivalTime = firstTask.getStartTime();
		LocalTime departureTime = arrivalTime.minus(time, ChronoUnit.MINUTES);
		Commute startOfDay = new Commute (departureTime, arrivalTime, 0);
		return startOfDay;
	}
}