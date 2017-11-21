package backEnd;

/**
 * This class represents an instance of a "todo" task that the user wants
 * to dedicate a certain amount of time to, and give a certain
 * priority to.
 * 
 *
 */
public class TODO implements Comparable<TODO> {
	
	/** A char representing the day that the task needs to be completed by. */
	private char dueDate;
	/** A integer representing the amount of time, in hours that will be dedicated to this task. */
	private int timeAllocated;
	/** The name of this task. */
	private String name;
	/** A integer representing the priority of the task. A lower priority represents a more important task.*/
	private int priority;
	/** An integer representing the difficulty of the task.*/
	private int difficulty;
	/** An integer representing the grade weight of the task.*/
    private double weight;
    /** An integer representing user priority. */
    private int user_priority;
	
	/**
	 * Makes a new todo object instance.
	 * 
	 * @param d
	 * 		The required completion day of this todo task.
	 * @param t
	 * 		The time allocated for this todo task.
	 * @param n
	 * 		The name of this todo task.
	 */
	public TODO (char d, int t, String n, double w, int diff){
		dueDate = d;
		timeAllocated = t;
		name = n;
		weight = w;
		difficulty = diff;
		assignPriority();
	}
	
	   /**
     * Makes a new todo object instance. An overloaded constructor with an 
     * additional priority parameter.
     * 
     * @param d
     *      The required completion day of this todo task.
     * @param t
     *      The time allocated for this todo task.
     * @param n
     *      The name of this todo task.
     * @param w
     *      The weighting of the task
     * @param diff
     *      The difficulty of the task
     */
	public TODO (char d, int t, String n, int p, double w, int diff){
      dueDate = d;
      timeAllocated = t;
      name = n;
      weight = w;
      difficulty = diff;
      user_priority = p;
	}
	
	/**
	 * A getter that returns the priority of this todo task. 
	 * 
	 * @return
	 * 		An integer from 1-7 representing the priority of the task.
	 */
	public int getPriority(){
		return priority;
	}
	
	/**
	 * A getter that returns the time allocated to this todo task.
	 * 
	 * @return
	 * 		An integer representing the number of hours allocated to the task.
	 */
	public int getTimeAllocated(){
		return timeAllocated;
	}
	
	/**
	 * A getter that returns the name of this todo task.
	 * 
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * The method that assigns a priority to the todo task based on its completion date.
	 * TODO: Assign priority based on difficulty, weight, and user priority
	 */
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
	
	/**
	 * A method that reduces the priority of this todo task.
	 * 
	 */
	public void decrementPriority(){
		priority--;
	}
	
	/**
	 * Reduces allocation time of this todo task by an passed in amount.
	 * 
	 * @param hours
	 * 		The time to reduce the todo task time allocation by.
	 */
	public void workedOnTODO(int hours){
		timeAllocated -=hours;
	}
	/**
	 * Adds more allocated time to this todo task by an passed in amount.
	 * 
	 * @param hours
	 * 		The time to increase the todo task time allocation by.
	 */
	public void addBack(int hours){
		timeAllocated+=hours;
	}

	@Override
	/**
	 * Compares this todo task object, to another todo task object and compares their priorities.
	 * 
	 */
	public int compareTo(TODO o) {
		return this.getPriority() - o.getPriority();
	}

}
