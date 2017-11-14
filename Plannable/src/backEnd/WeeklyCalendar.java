package backEnd;

import java.util.ArrayList;

import backEnd.tasks.Task;

/**
 * The WeeklyCalendar class represents seven days
 * of one week and holds the information regarding
 * all Tasks given by the user for the week.
 */
public class WeeklyCalendar {
		
	ArrayList<Task> monTasks = new ArrayList<Task>();
	ArrayList<Task> tuesTasks = new ArrayList<Task>();
	ArrayList<Task> wedTasks = new ArrayList<Task>();
	ArrayList<Task> thursTasks = new ArrayList<Task>();
	ArrayList<Task> friTasks = new ArrayList<Task>();
	ArrayList<Task> satTasks = new ArrayList<Task>();
	ArrayList<Task> sunTasks = new ArrayList<Task>();

	ArrayList<ArrayList<Task>> daysOfWeek = new ArrayList<ArrayList<Task>>();
	
	/**
	 * Creates a WeeklyCalendar instance with seven ArrayLists to be
	 * filled with tasks.
	 * 
	 */
	public WeeklyCalendar(){
		daysOfWeek.add(sunTasks);
		daysOfWeek.add(monTasks);
		daysOfWeek.add(tuesTasks);
		daysOfWeek.add(wedTasks);
		daysOfWeek.add(thursTasks);
		daysOfWeek.add(friTasks);
		daysOfWeek.add(satTasks);
	}
	
	@Override
	/**
	 * Prints each daily ArrayList of tasks as a String
	 * 
	 */
	public String toString(){
		return  "N" + sunTasks +"\nM" + monTasks + "\nT" + tuesTasks +
				"\nW" + wedTasks +"\nR" + thursTasks +"\nF" + friTasks +
				"\nS" + satTasks;
		
	}
}
