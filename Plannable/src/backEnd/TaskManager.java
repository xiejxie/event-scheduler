package backEnd;

import backEnd.tasks.Commute;
import backEnd.tasks.Task;

public class TaskManager {
	
	private WeeklyCalendar week;
	
	public TaskManager(WeeklyCalendar week){
		this.week = week;
	}
	
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
		}
	}
	
	public void addCommute(int time){
		Task lastTask, firstTask;
		if(week.monTasks.size() != 0){
			// getting the last course so can commute after
			lastTask = week.monTasks.get(week.monTasks.size()-1);
			week.monTasks.add(getEndOfDayCommute(lastTask, time));
			// getting the first course so can commute before
			firstTask = week.monTasks.get(0);
			week.monTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(week.tuesTasks.size() != 0){
			lastTask = week.tuesTasks.get(week.tuesTasks.size()-1);
			week.tuesTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = week.tuesTasks.get(0);
			week.tuesTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(week.wedTasks.size() != 0){
			lastTask = week.wedTasks.get(week.wedTasks.size()-1);
			week.wedTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = week.wedTasks.get(0);
			week.wedTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(week.thursTasks.size() != 0){
			lastTask = week.thursTasks.get(week.thursTasks.size()-1);
			week.thursTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = week.thursTasks.get(0);
			week.thursTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		if(week.friTasks.size() != 0){
			lastTask = week.friTasks.get(week.friTasks.size()-1);
			week.friTasks.add(getEndOfDayCommute(lastTask, time));
			firstTask = week.friTasks.get(0);
			week.friTasks.add(0, getStartOfDayCommute(firstTask, time));
		}
		
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

	public WeeklyCalendar getWeek(){
		return week;
	}
	
}
