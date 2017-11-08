package backEnd;

public class TODO implements Comparable<TODO> {
	
	private char dueDate;
	private int timeAllocated;
	private String name;
	private int priority;
	
	public TODO (char d, int t, String n){
		dueDate = d;
		timeAllocated = t;
		name = n;
		assignPriority();
	}
	
	public int getPriority(){
		return priority;
	}
	
	public int getTimeAllocated(){
		return timeAllocated;
	}
	
	public String getName(){
		return name;
	}
	
	public void assignPriority(){
		switch(dueDate){
		case 'M':
			priority = 1;
			break;
		case 'T':
			priority = 2;
			break;
		case 'W':
			priority = 3;
			break;
		case 'R':
			priority = 4;
			break;
		case 'F':
			priority = 5;
			break;
		case 'S':
			priority = 6;
			break;
		case 'N':
			priority = 7;
			break;
		}
	}
	
	public void decrementPriority(){
		priority--;
	}
	
	public void workedOnTODO(int hours){
		timeAllocated -=hours;
	}
	public void addBack(int hours){
		timeAllocated+=hours;
	}

	@Override
	public int compareTo(TODO o) {
		return this.getPriority() - o.getPriority();
	}

}
