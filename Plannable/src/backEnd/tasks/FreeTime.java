package backEnd.tasks;

public class FreeTime extends Task {
	private char day;
	
	public FreeTime(String sT, String eT, int p, char day) {
		super(sT, eT, p);
		this.day = day;
	}

}
