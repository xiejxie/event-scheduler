package backEnd;

import java.util.ArrayList;

import backEnd.tasks.Task;

/**
 * The WeeklyCalendar class represents seven days
 * of one week and holds the information regarding
 * all Tasks given by the user.
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
	public String toString(){
		return  "N" + sunTasks +"\nM" + monTasks + "\nT" + tuesTasks +
				"\nW" + wedTasks +"\nR" + thursTasks +"\nF" + friTasks +
				"\nS" + satTasks;
		
	}
}
