package backEnd.tasks;

import java.time.LocalTime;

public class FreeTime extends Task {
	
	public FreeTime(LocalTime sT, LocalTime eT, int p, char day) {
		super("Free Time",sT, eT, p);
	}

}
