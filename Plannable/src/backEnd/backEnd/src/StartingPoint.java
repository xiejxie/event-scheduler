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
		System.out.println(Arrays.toString(week.monTasks.toArray()));
		System.out.println(Arrays.toString(week.tuesTasks.toArray()));
		System.out.println(Arrays.toString(week.wedTasks.toArray()));
		System.out.println(Arrays.toString(week.thursTasks.toArray()));
		System.out.println(Arrays.toString(week.friTasks.toArray()));


				
	}
	
	
}
