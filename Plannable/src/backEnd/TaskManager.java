package backEnd;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import backEnd.tasks.Commute;
import backEnd.tasks.Sleep;
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
	

	public WeeklyCalendar getWeek(){
		return week;
	}
	
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
	
	public Commute getEndOfDayCommute(Task lastTask, int time){
		LocalTime departureTime = lastTask.getEndTime();
		LocalTime arrivalTime = departureTime.plus(time, ChronoUnit.MINUTES);
		Commute endOfDay = new Commute (departureTime, arrivalTime, 0);
		return endOfDay;
	}
	
	public Commute getStartOfDayCommute(Task firstTask, int time){
		LocalTime arrivalTime = firstTask.getStartTime();
		LocalTime departureTime = arrivalTime.minus(time, ChronoUnit.MINUTES);
		Commute startOfDay = new Commute (departureTime, arrivalTime, 0);
		return startOfDay;
	}

	
	public void addRest(int time){
		Task tonightCommute, tomorrowMorningCommute;
		int totalSleepTime = time;
		
		System.out.println(week);
		
		for(int counter = 0; counter < week.daysOfWeek.size(); counter ++){
			
			ArrayList<Task> today = week.daysOfWeek.get(counter);
			ArrayList<Task> tomorrow;
			if(counter == week.daysOfWeek.size() - 1){
				tomorrow = week.daysOfWeek.get(0);
			}
			else{
				tomorrow = week.daysOfWeek.get(counter + 1);
			}
			
			tonightCommute = today.get(today.size() - 1);
			tomorrowMorningCommute = tomorrow.get(0);
			
			//Get maximum amount of sleep in morning of next day
			Sleep daySleep = getSleepTime(tomorrowMorningCommute, totalSleepTime, 'm');
			totalSleepTime -= daySleep.getSleepInHours();
			today.add(daySleep);
			if(totalSleepTime > 0){
				tomorrow.add(getSleepTime(tonightCommute, totalSleepTime, 'n'));
			}
		}
	}
    public Sleep getSleepTime(Task commute, int time, char which){
    	
    	//Morning sleep portion (Between 0:00 and departure time)
    	if(which == 'm'){
    		LocalTime departureTime = commute.getStartTime();
    		
    		//Will need to split sleep into 2 parts as it is more than or equal to midnight to morning departure
    		if((departureTime.minus(time, ChronoUnit.HOURS).isBefore(LocalTime.MIDNIGHT))){
    			return new Sleep(LocalTime.MIDNIGHT, departureTime, 0);
    		}
    		//If amount can all be slept between midnight and morning departure time
    		else{
    			LocalTime lateBedTime = departureTime.minus(time, ChronoUnit.HOURS);
    			
    			return new Sleep(lateBedTime,departureTime, 0);
    		}
    	}
    	//Night sleep time (Any extra sleep time required before 23:59) 
    	else{
    		LocalTime beforeMidnightSleep = LocalTime.of(23, 59);
    		LocalTime bedTime = LocalTime.MIDNIGHT.minus(time, ChronoUnit.HOURS);
    		return new Sleep(bedTime, beforeMidnightSleep, 0);
    	}
    }
	
}