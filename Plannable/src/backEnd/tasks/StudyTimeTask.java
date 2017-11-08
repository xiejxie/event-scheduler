package backEnd.tasks;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import backEnd.tasks.Task;

public class StudyTimeTask extends Task {
	
	private long duration;
	private ArrayList <String> work;
	
	public StudyTimeTask(LocalTime sT, LocalTime eT, int p, char day){
		super("StudyTime", sT, eT, p);
		work = new ArrayList<String>();
		duration = sT.until(eT, ChronoUnit.MINUTES);
	}
}
