package backEnd;

import java.util.Arrays;
import java.util.Scanner;

public class StartingPoint {

	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		System.out.println("WELCOME TO PLANNABLE!!!");
		System.out.println("Before we get started, let's learn a bit about you");
		System.out.println("Please enter your name");
		String name = in.nextLine();
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
		System.out.println("Please enter your commute time in minutes");
		int commuteTime = in.nextInt();
		createAdd.createCommuteAddToCal(commuteTime);
		System.out.println("Please enter the times you would like to designate as free time, in the "
				+ "following format:\n M 10:00-11:00, R 10:00-11:00, F 18:00-19:00\n"
				+ "When you're finished entering times, type DONE");
		String freeTime = in.nextLine();
		while (!freeTime.equals("DONE")){
			createAdd.createFreeTimeAddToCal(freeTime);
			freeTime = in.nextLine();
		}
		
		System.out.println(week);
		
	}
}
