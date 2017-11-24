package backEnd;

import java.util.Scanner;

/**
 * StartingPoint is the Main method for pure back end usage.
 * It prompts for the user to type input into console and 
 * calls the appropriate function in ParseInput.
 */
public class StartingPoint {

	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		System.out.println("WELCOME TO PLANNABLE!!!");
		
		WeeklyCalendar week = new WeeklyCalendar();
		ParseInput createAdd = new ParseInput(week);

		System.out.println("Please enter the courses you take, in the following format\nCSC369: "
				+ "M 10:00-11:00, W 10:00-11:00, F 18:00-19:00\n"
				+ "When you're finished entering your courses, type DONE");
		String currCourse = in.nextLine();
		while(! currCourse.equals("DONE")){
			createAdd.createCourseAddToCal(currCourse);
			currCourse = in.nextLine();
		}
		System.out.println("Entering courses.......");
	    
		System.out.println("Please enter any extracurriculars you have, in the "
		    + "following format\nChess Club: "
		    + "W 18:00-20:00\n"
		    + "When you're finished entering your extracurriculars, type DONE");
		String currEC = in.nextLine();
		while(! currEC.equals("DONE")){
		    createAdd.createECAddToCal(currEC);
		    currEC = in.nextLine();
		}
		System.out.println("Entering Extracurriculars.......");
		
		System.out.println("Please enter your one-way commute time in minutes");
		int commuteTime = in.nextInt();
		createAdd.createCommuteAddToCal(commuteTime);
	    System.out.println("Scheduling commute times......");
	    in.nextLine();	// Eat up newline character
	    
		/*
		System.out.println("Please enter your desired rest time in hours");
		int restTimeHours = Integer.parseInt(in.nextLine().trim());
		
		createAdd.createRestTimeAddToCal(restTimeHours);
		in.nextLine();
		*/
		System.out.println("Please enter the times you would like to designate as free time, in the "
				+ "following format:\nM 10:00-11:00, R 10:00-11:00, F 18:00-19:00\n"
				+ "When you're finished entering times, type DONE");
		String freeTime = in.nextLine();
		while (!freeTime.equals("DONE")){
			createAdd.createStudyFreeTimeAddToCal(freeTime, "free");
			freeTime = in.nextLine();
		}
		
		System.out.println("Please enter the times you would like to designate as study time, in the "
				+ "same format as free time\nYou should be studying everyday ;)\n"
				+ "When you're finished entering times, type DONE");
		String studyTime = in.nextLine();
		while (!studyTime.equals("DONE")){
			createAdd.createStudyFreeTimeAddToCal(studyTime,"study");
			studyTime = in.nextLine();
		}
		
		
		TODOManager tManage = new TODOManager();
		System.out.println("Please enter the things you need to complete, staring from tomorrow(Monday) to next Sunday"
				+ "\nPlease also ensure to enter the total amount of time(in hours) it will take to complete this item"
				+ "\nFinally, include the weighting (from 0-100) and difficulty (from 1-5) of the task, and an optional user priority"
				+ "\nEnter in the format CSC369 Test: F, 8, 20, 3, 4"
				+ "\nWhen you're finished, type DONE");
		String item = in.nextLine();
		while(!item.equals("DONE")){
			createAdd.createThingTODO(item, tManage);
			item = in.nextLine();
		}
		tManage.addToCalendar(week);
		
		in.close();

		System.out.println(week);
	}
}