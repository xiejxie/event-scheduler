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
    private int weight;
    /** An integer representing user priority. */
    private int user_priority;
    /** An integer representing due date priority */
    private int duedate_priority;
	
	
	   /**
     * Makes a new todo object instance. 
     * 
     * @param d
     *      The required completion day of this todo task.
     * @param t
     *      The time allocated for this todo task.
     * @param n
     *      The name of this todo task.
     * @param p
     *      The user priority of this todo task.
     * @param w
     *      The weighting of the task
     * @param diff
     *      The difficulty of the task
     */
	public TODO (char d, int t, String n, int p, int w, int diff) throws
	  IllegalArgumentException {
	  if(p < 1 || p > 5) { 
	    throw new IllegalArgumentException(); 
	  }
	  if(w < 0 || w > 100) { 
	    throw new IllegalArgumentException(); 
	  }
	  if(diff < 1 || diff > 5) { 
	    throw new IllegalArgumentException(); 
	  }
	  else {
	    dueDate = d;
	    timeAllocated = t;
	    name = n;
	    weight = convertWeight(w);
	    difficulty = diff;
	    user_priority = p;
	    assignPriority();
	  }
      
	}
	
	/**
	 * Converts a number from 0 to 100 to a number from 1 to 5
	 * @param weight   The weight of the assignment
	 * @return num     A number from 1 to 5 representing the weight
	 */
	public int convertWeight(int weight){
	  int num;
	  if(weight >= 40){ num = 5;}
	  else {
	    num = weight / 10;
	  }
	  return num;
	}
	/**
	 * A getter that returns the priority of this todo task. 
	 * 
	 * @return
	 * 		An integer representing the priority of the task
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
	    /**
	     * Uses a simple algorithm, where user priority and difficulty are weighted equally
	     * Weight is given highest flat priority
	     * Due date is given lowest priority
	     * This implementation could be changed without affecting the overall algorithm
	     */
	    int user_priority_factor = user_priority * 3;
	    int difficulty_factor = difficulty * 3;
	    int weight_factor = weight * 5;
	    
	    //Assigns a priority based on the due date
		switch(dueDate){
		case 'M':
			duedate_priority = 6;
			break;
		case 'T':
		    duedate_priority = 5;
			break;
		case 'W':
		    duedate_priority = 4;
			break;
		case 'R':
		    duedate_priority = 3;
			break;
		case 'F':
			duedate_priority = 2;
			break;
		case 'S':
			duedate_priority = 1;
			break;
		case 'N':
			duedate_priority = 7;
			break;
		}
		
		int duedate_factor = duedate_priority * 2;
	    priority = user_priority_factor + difficulty_factor + weight_factor
	        + duedate_factor;
	}
	
	/**
	 * A method that reduces the priority of this todo task.
	 * 
	 */
	public void updatePriority(){
		priority = (int) priority / 2;
	}
	
	/**
	 * A method that updates the due date
	 */
	public void updateDate(){
	    duedate_priority++;
	}
	
	/**
	 * A method that gets the duedate priority
	 */
	public int getDueDatePriority(){
	  return duedate_priority;
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
