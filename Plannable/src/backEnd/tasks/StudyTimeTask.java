package backEnd.tasks;

import java.time.LocalTime;

import backEnd.tasks.Task;

public class StudyTimeTask extends Task {
	
	public StudyTimeTask(LocalTime sT, LocalTime eT, int p){
		super(sT, eT, p);
	}
}
