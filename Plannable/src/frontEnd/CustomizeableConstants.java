package frontEnd;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Class to control the customizable portions of the UI, namely the colours of the time blocks and the text
 * of the header of each step
 */
public class CustomizeableConstants {
	static private String[] colourSet = {"#ffb3ba", "#ffdfba", "#ffffba", "#baffc9", "#bae1ff"};
	static private String[] steps = {"Your Courses", "Your Extracurriculars", "Your Evaluations", "Your ????"};
	/**
	 * @return	colour of the new time block
	 */
	public static String getColour() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, colourSet.length);
		return colourSet[randomNum];
	}
	
	/**
	 * @param state	the current step
	 * @return	the header string for the current step
	 */
	public static String getHeaderString(int state) {
		return steps[state-1];
	}
}
